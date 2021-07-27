package hcx.work.learning.essential;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Test {
    public static void main(String[] args) {
	LinkedList<Integer> link = new LinkedList<Integer>();
	for (int i = 0; i < 10; i++) {
	    link.add(i);
	}
	ArrayList<Integer> list = new ArrayList<Integer>(link);

	Iterator<Integer> iterator = list.iterator();
	while (iterator.hasNext()) {
	    System.out.println(iterator.next());
	}
	"a".equals(null);
	java.security.Security.setProperty("networkaddress.cache.ttl", "10");
    }
}
