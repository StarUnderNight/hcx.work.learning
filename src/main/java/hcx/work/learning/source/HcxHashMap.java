package hcx.work.learning.source;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class HcxHashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {

    static class Node<K, V> implements Map.Entry<K, V> {
	final int hash; // hash值
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

	// 设置值的方法
	public final V setValue(V newValue) {
	    V oldValue = value;
	    value = newValue;
	    return oldValue;
	}

	public final boolean equals(Object o) {
	    if (o == this) { // 查看引用是否相等
		return true;
	    }
	    if (o instanceof Map.Entry) { // 判断这个对象是不是Map.Entry的实例
		Map.Entry<?, ?> e = (Map.Entry<?, ?>) o;
		/*
		 * 接下来比较两者的键和值是否相等，如果相等，就是同一个对象
		 * 比较的原因，猜测是因为字符串变量在常量池中，如果用String做键或者值，其实他们引用的都是同一个对象
		 * 除此之外，还有Integer的-127,128范围内的数
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
