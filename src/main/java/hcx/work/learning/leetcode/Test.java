package hcx.work.learning.leetcode;

public class Test<T, K, L> {
    public static void main(String[] args) {

	new Test().test(13);
	StringBuilder sb = new StringBuilder("12345");
	sb.delete(1, 3);
	System.out.println(sb.toString());

    }

    private int age = 10;

    public void test(final int h) {
	class InClass {
	    public void inPrint() {
		System.out.println("h = " + h + "; age = " + age);
	    }
	}
	new InClass().inPrint();
    }

    private void test(int a, int b) {

    }
}
