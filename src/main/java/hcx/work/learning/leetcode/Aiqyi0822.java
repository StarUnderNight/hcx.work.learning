package hcx.work.learning.leetcode;

public class Aiqyi0822 {
    public static void main(String[] args) {
	int[] test1 = new int[] { 1, 2, 3, 8, 5, 3, 6 };
	int[] test2 = new int[] { 2, 2, 3, 8, 8, 6, 5, 10, 7, 6 };
	System.out.println(new Aiqyi0822().longestMountain(test2));
    }

    public int longestMountain(int[] arr) {
	int max = Integer.MIN_VALUE;
	int len = arr.length;

	if (len == 2) {
	    return Math.abs(arr[0] - arr[1]);
	}

	int start = 0;
	int end = 1;

	while (end < len) {
	    while (end < len && arr[end] >= arr[end - 1]) {
		end++;
	    }
	    // 上升序列结束，计算振幅
	    max = Math.max(max, arr[end - 1] - arr[start]);

	    start = end - 1;
	    // 计算下降序列
	    while (end < len && arr[end] < arr[end - 1]) {
		end++;
	    }
	    max = Math.max(max, arr[end - 1] - arr[start]);
	    start = end - 1;

	}
	return max;

    }

    public static String[] solve(String[] item, String query) {

	return null;
    }
}
