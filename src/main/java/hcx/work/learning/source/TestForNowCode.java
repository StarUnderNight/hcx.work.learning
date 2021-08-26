package hcx.work.learning.source;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TestForNowCode {

    public static void main(String[] args) {
	// [[1,1,1,1,0],[0,1,0,1,0],[1,1,2,1,1],[0,2,0,0,1]]
	int[][] input = new int[][] { { 1, 1, 1, 1, 0 }, { 0, 1, 0, 1, 0 }, { 1, 1, 2, 1, 1 }, { 0, 2, 0, 0, 1 } };

	System.out.println(new TestForNowCode().minSailCost(input));
    }

    private int start = 65;
    private int end = 90;

    public void t2(int n, int k) {
	List<Character> list = new ArrayList<Character>();
	for (int i = start; i <= end; i++) {
	    list.add((char) i);
	}
	StringBuilder bs = new StringBuilder();
	bs.append(list.get(0));
	for (int i = 0; i < n - 1; i++) {
	    StringBuilder cache = new StringBuilder(bs);
	    bs.append(list.get(i));
	    bs.append(adjust(cache));
	}

    }

    private StringBuilder adjust(StringBuilder bs) {
	StringBuilder cache = new StringBuilder();
	Map<Character, Character> map = new HashMap<Character, Character>();
	int ar = end;
	for (int i = start; i <= end; i++) {
	    map.put((char) i, (char) ar);
	    ar--;
	}
	for (int i = 0; i < bs.length(); i++) {
	    cache.append(map.get(bs.charAt(i)));
	}
	cache.reverse();
	return cache;
    }

    public static int t3() {
	Scanner in = new Scanner(System.in);
	String line = in.nextLine();
	String[] strArr = line.split(" ");
	int len = strArr.length;
	int[] arr = new int[len];

	for (int i = 0; i < len; i++) {
	    arr[i] = Integer.parseInt(strArr[i]);
	}

	int[] left = new int[len];
	int[] right = new int[len];
	Arrays.fill(left, 1);
	Arrays.fill(right, 1);

	for (int i = 0; i < len; i++) {
	    if (arr[i] > arr[(i + len - 1) % len]) {
		left[i] = left[(i - 1) % len] + 1;
	    }
	}

	for (int i = len - 1; i >= 0; i--) {
	    if (arr[i] > arr[(i + 1) % len]) {
		right[i] = right[(i + 1) % len] + 1;
	    }
	}

	int ans = 0;
	for (int i = 0; i < len; i++) {
	    ans += Math.max(left[i], right[i]);
	}
	return ans;
    }

    public static int t1() {
	Scanner in = new Scanner(System.in);
	String line = in.nextLine();
	int target = in.nextInt();
	String[] strArr = line.split(" ");
	int len = strArr.length;
	int[] arr = new int[len];

	for (int i = 0; i < len; i++) {
	    arr[i] = Integer.parseInt(strArr[i]);
	}

	int count = 0;

	for (int i = 0; i < len; i++) {
	    for (int j = i + 1; j < len; j++) {
		if (arr[i] + arr[j] <= target) {
		    count++;
		}
	    }
	}

	return count;

    }

    private int rowLen;
    private int colLen;
    private boolean[][] accessed;
    private List<Integer> ansList;
    private int count;

    public int minSailCost(int[][] input) {
	// write code here
	rowLen = input.length;
	colLen = input[0].length;
	if (input[rowLen - 1][colLen - 1] == 2) {
	    return -1;
	}

	accessed = new boolean[rowLen][colLen]; // 访问标志
	int cost = bfs(input, 0, 0);
	return cost - Integer.MIN_VALUE;

    }

    private int bfs(int[][] input, int x, int y) {
	// 从0,0开始，越界+已访问处理
	if (x >= rowLen || y < 0 || y >= colLen || accessed[x][y] || input[x][y] == 2) {
	    return Integer.MAX_VALUE;
	}

	accessed[x][y] = true;

	int cost = input[x][y] == 0 ? 2 : 1; // 判断水路还是陆路

	// 如果该节点是最终节点
	if (x == rowLen - 1 && y == colLen - 1) {
	    return Integer.MIN_VALUE + cost;
	}

	int rightCost = bfs(input, x + 1, y);

	int downCost = bfs(input, x, y + 1);

	int minCost = Math.min(downCost, rightCost);

	return minCost + cost;

    }

}
