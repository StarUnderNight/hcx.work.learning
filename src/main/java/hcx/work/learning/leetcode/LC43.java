package hcx.work.learning.leetcode;

public class LC43 {

    public static void main(String[] args) {
	String num1 = "2323";
	String num2 = "2323";
	new LC43().multiply(num1, num2);
    }

    public String multiply(String num1, String num2) {
	int len1 = num1.length();
	int len2 = num2.length();
	if ("0".equals(num1) || "0".equals(num2)) {
	    return "0";
	}

	String ans = "0";

	for (int i = len2 - 1; i >= 0; i--) {
	    StringBuffer sb = new StringBuffer();
	    int b = num2.charAt(i) - '0';
	    int e = 0; // ½øÎ»
	    for (int k = len2 - 1; k > i; k--) {
		sb.insert(0, "0");
	    }
	    for (int j = len1 - 1; j >= 0; j--) {
		int v = (num1.charAt(j) - '0') * b + e;
		e = v / 10;
		v = v % 10;
		sb.insert(0, v + "");
	    }
	    if (e != 0) {
		sb.insert(0, e + "");
	    }
	    ans = plus(ans, sb.toString());

	}
	return ans;
    }

    public String plus(String a, String b) {
	int lenA = a.length();
	int lenB = b.length();
	int e = 0;
	int count = 1;
	StringBuffer sb = new StringBuffer();
	while (count <= lenA || count <= lenB) {
	    int vA = count <= lenA ? a.charAt(lenA - count) - '0' : 0;
	    int vB = count <= lenB ? b.charAt(lenB - count) - '0' : 0;
	    int v = vA + vB + e;
	    e = v / 10;
	    v = v % 10;
	    sb.insert(0, v + "");
	    count++;
	}
	if (e != 0) {
	    sb.insert(0, e + "");
	}
	return sb.toString();
    }
}
