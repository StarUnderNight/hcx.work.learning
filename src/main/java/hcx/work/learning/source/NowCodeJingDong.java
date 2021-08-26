package hcx.work.learning.source;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NowCodeJingDong {

    public static void main(String[] args) {
	new NowCodeJingDong().solve();
    }

//    private void solve() {
//	Scanner in = new Scanner(System.in);
//	int n = in.nextInt();
//	in.nextLine();
//	String str = in.nextLine();
//	int[] res = new int[n];
//	res[0] = 1;
//	for (int i = 1; i < n; i++) {
//	    int number1 = 0;
//	    int number2 = 0;
//	    for (int j = 0; j <= i; j++) {
//		if ('0' == str.charAt(j)) {
//		    number1++;
//		} else {
//		    number2++;
//		}
//
//	    }
//	    if (number1 == 0 || number2 == 0) {
//		res[i] = i + 1;
//		continue;
//	    }
//
//	    int len = max(number1, number2);
//	    if (len == 1) {
//		res[i] = 1;
//	    }
//	    int subStrNum1 = 0;
//	    int subStrNum2 = 0;
//	    for (int k = 0; k < i; k++) {
//		if (k > 0 && (k + 1) % len == 0) {
//		    if (subStrNum1 != number1 / len || subStrNum2 != number2 / len) {
//			res[i] = 1;
//		    }
//		    subStrNum1 = 0;
//		    subStrNum2 = 0;
//		}
//		int c1 = str.charAt(k) - '0';
//		if (c1 == 0) {
//		    subStrNum1++;
//		} else {
//		    subStrNum2++;
//		}
//
//	    }
//
//	    if (res[i] != 1) {
//		res[i] = len;
//	    }
//
//	}
//
//	for (int i = 0; i < n - 1; i++) {
//	    System.out.println(res[i] + " ");
//	}
//	System.out.println(res[n - 1]);
//    }

    private int max(int a, int b) {
	int tmp = a % b;
	while (tmp != 0) {
	    a = b;
	    b = tmp;
	    tmp = a % b;
	}
	return b;
    }

    private void solve() {

	int count = 0;
	Map<String, Boolean> map1 = new HashMap<String, Boolean>();
	Map<String, Boolean> map2 = new HashMap<String, Boolean>();
	int rowLen = 0;
	int colLen = 0;

	Scanner in = new Scanner(System.in);
	int n = in.nextInt();
	in.nextLine();

	for (int i = 0; i < n; i++) {
	    String key = in.nextLine().replace(" ", "-");
	    String[] strArr = key.split("-");
	    rowLen = Math.max(rowLen, Integer.parseInt(strArr[0]));
	    colLen = Math.max(colLen, Integer.parseInt(strArr[1]));

	    map1.put(key, false);
	}
	// 先计算左下方向
	for (String e : map1.keySet()) {
	    String v = e;
	    if (!map1.get(v)) { // 没有被访问过，则进入
		map1.put(v, true); // 设置为已访问
		String[] strA1 = v.split("-");
		int rowIdx = Integer.parseInt(strA1[0]);
		int colIdx = Integer.parseInt(strA1[1]);
		int min = Math.min(rowIdx, colIdx);
		int rowStart = rowIdx - min; // 斜线开始下标
		int colStart = colIdx - min;

		while (rowStart++ <= rowLen && colStart++ <= colLen) {
		    String pos = rowStart + "-" + colStart;
		    if (map1.containsKey(pos) && !map1.get(pos)) {
			// 该斜方向计数+1
			count++;
		    }
		}

	    }
	}

    }

//    private void solve() {
//	Scanner in = new Scanner(System.in);
//	int n = in.nextInt();
//
//	pos = new int[n][2]; // 家庭住址
//	map = new HashMap<String, Boolean>();
//	in.nextLine();
//	
//	for (int i = 0; i < n; i++) {
//	    String key0 = in.nextLine();
//	    String key = key0.replace(" ", "-");
//	    map.put(key, false);
//	}

//	count = 0;
//
//	for (String e : map.keySet()) {
//	    String idx = e;
//	    if (!map.get(idx)) {
//		bfs(idx);
//	    }
//	}
//	System.out.println(count);
//    }
//
//    private void bfs(String idx) {
//	// 判断自己有没有在map中 或者有没有被访问过
//	if (!map.containsKey(idx) || map.get(idx)) {
//	    return;
//	}
//	// 把自己设置为已访问
//	count++;
//	map.put(idx, true);
//
//	// 四个方向邻居节点
//	int[] site = parse(idx);
//	int x = site[0];
//	int y = site[1];
//	for (int i = 0; i < 4; i++) {
//	    bfs((x + NEGI[i][0]) + "-" + (y + NEGI[i][1]));
//	}
//    }
//
//    private int[] parse(String idx) {
//	String[] arr = idx.split("-");
//	int[] res = new int[2];
//	res[0] = Integer.parseInt(arr[0]);
//	res[1] = Integer.parseInt(arr[1]);
//	return res;
//    }
//
//    /*
//     * 5* 3 4* 4 5 * 5 6 * 4 7* 3 8
//     */
}
