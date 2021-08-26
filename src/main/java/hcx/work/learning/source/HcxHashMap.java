package hcx.work.learning.source;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class HcxHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {

    static class Node<K, V> implements Map.Entry<K, V> {
	final int hash; // hashֵ
	final K key;
	V value;
	Node<K, V> next;

	Node(int hash, K key, V value, Node<K, V> next) {
	    this.hash = hash;
	    this.key = key;
	    this.value = value;
	    this.next = next;
	}

	public final K getKey() {
	    return key;
	}

	public final V getValue() {
	    return value;
	}

	public final String toString() {
	    return key + "=" + value;
	}

	public final int hashCode() {
	    return Objects.hashCode(key) ^ Objects.hashCode(value);
	}

	// ����ֵ�ķ���
	public final V setValue(V newValue) {
	    V oldValue = value;
	    value = newValue;
	    return oldValue;
	}

	public final boolean equals(Object o) {
	    if (o == this) { // �鿴�����Ƿ����
		return true;
	    }
	    if (o instanceof Map.Entry) { // �ж���������ǲ���Map.Entry��ʵ��
		Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
		/*
		 * �������Ƚ����ߵļ���ֵ�Ƿ���ȣ������ȣ�����ͬһ������
		 * �Ƚϵ�ԭ�򣬲²�����Ϊ�ַ��������ڳ������У������String��������ֵ����ʵ�������õĶ���ͬһ������
		 * ����֮�⣬����Integer��-127,128��Χ�ڵ���
		 */

		if (Objects.equals(key, e.getKey()) && Objects.equals(value, e.getValue())) {
		    return true;
		}
	    }
	    return false;
	}
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
	// TODO Auto-generated method stub
	return null;
    }

}
