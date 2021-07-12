package hcx.work.learning.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class LC43 {

    public static void main(String[] args) {
	String num1 = "2";
	String num2 = "3";
	new LC43().multiplyString(num1, num2);
	System.out.println(new LC43().multiplyByArr(num1, num2));
    }

    public String multiplyByArr(String num1, String num2) {
	if ("0".equals(num1) || "0".equals(num2)) {
	    return "0";
	}
	String a = null;
	String b = null;
	if (num1.length() > num2.length()) {
	    a = num1;
	    b = num2;
	} else {
	    a = num2;
	    b = num1;
	}
	int lenA = a.length();
	int lenB = b.length();

	int arr[] = new int[lenA + lenB];
	// 遍历乘数
	for (int i = lenB - 1; i >= 0; i--) {
	    int v1 = b.charAt(i) - '0';
	    for (int j = lenA - 1; j >= 0; j--) {
		int v2 = a.charAt(j) - '0';
		int v = v1 * v2;
		arr[i + j + 1] = arr[i + j + 1] + v % 10;
		arr[i + j] = arr[i + j] + v / 10;
	    }
	}
	System.out.println(Arrays.toString(arr));

	// 处理进位
	int e = 0;
	StringBuffer sb = new StringBuffer();
	for (int i = lenA + lenB - 1; i >= 0; i--) {
	    int v = (arr[i] + e) % 10;
	    e = (arr[i] + e) / 10;
	    sb.append(v);
	}

	sb.reverse();
	System.out.println(sb.toString());
	String str = sb.toString();
	if ('0' == (sb.charAt(0))) {
	    return str.substring(1, str.length());
	}
	return str;

    }

    /*
     * 用字符串来保存乘积的值，这样操作，每次都要保存进位的值，以及每次都要加0，复杂度太高，可以考虑用数组来存储
     */
    public String multiplyString(String num1, String num2) {
	int len1 = num1.length();
	int len2 = num2.length();
	if ("0".equals(num1) || "0".equals(num2)) {
	    return "0";
	}

	String ans = "0";

	for (int i = len2 - 1; i >= 0; i--) {
	    StringBuffer sb = new StringBuffer();
	    int b = num2.charAt(i) - '0';
	    int e = 0; // 进位
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
