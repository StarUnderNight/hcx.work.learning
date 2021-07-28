package hcx.work.learning.leetcode;

import java.util.HashMap;

public class LT391 {
	public static void main(String[] args) {
		int[][] arr = { { 1, 10 }, { 2, 3 }, { 5, 8 }, { 4, 7 } };
		int ans = new LT391().solve(arr);
		System.out.println(ans);
	}

	public int solve(int[][] intervals) {
		int max = 0;

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < intervals.length; i++) {

			int j = 0;
			for (j = intervals[i][0]; j < intervals[i][1]; j++) {
				if (map.get(j) == null) {
					map.put(j, 1);
				} else {
					map.put(j, map.get(j) + 1);
				}
			}
			if (map.get(j) == null) {
				map.put(j, -1);
			} else {
				map.put(j, map.get(j) - 1);
			}
		}

		for (Integer i : map.keySet()) {
			max = Math.max(max, map.get(i));
		}

		return max;
	}
}
