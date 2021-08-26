package hcx.work.learning.struct;

public class DynamicProcess {

	/** main 方法
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 2, 5 };
		int m = 11;
		System.out.println(coinChange(arr, m));
		System.out.println(uinqu(10, 12));
	}

	private static boolean canJump(int[] arr) {
		// TODO Auto-generated method stub
		int len = arr.length;
		boolean[] dp = new boolean[len];
		dp[0] = true;

		for (int j = 1; j < len; j++) {
			dp[j] = false;
			for (int i = 0; i < j; i++) {
				if (dp[i] && arr[i] + i >= j) {
					dp[j] = true;
					break;
				}
			}
		}
		return dp[len - 1];
	}

	/**
	 * @param m
	 * @param n
	 * @return 走到(m-1, n-1)位置的方式
	 */
	public static int uinqu(int m, int n) {
		int[][] dp = new int[m][n];
		dp[0][0] = 1;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 1;
				} else {
					dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
				}
			}
		}

		return dp[m - 1][n - 1];
	}

	/**
	 * lint 669 给出不同面额的硬币以及一个总金额. 写一个方法来计算给出的总金额可以换取的最少的硬币数量.
	  * 如果已有硬币的任意组合均无法与总金额面额相等, 那么返回 -1. 输入： [1, 2, 5] 11 输出： 3 解释： 11 = 5 + 5 + 1
	 * 
	 * @param arr 硬币数组
	 * @param m   总金额
	 * @return
	 */
	public static int coinChange(int[] arr, int m) {
		// 先开数组
		int[] f = new int[m + 1]; // f[i] 表示面值为i时，所需要的最小硬币数
		int len = arr.length;

		f[0] = 0;
		for (int i = 1; i <= m; i++) {
			f[i] = Integer.MAX_VALUE;
			for (int j = 0; j < len; j++) { // 遍历面值
				if (i >= arr[j] && f[i - arr[j]] != Integer.MAX_VALUE) {
					f[i] = Math.min(f[i - arr[j]] + 1, f[i]);
				}

			}
		}

		if (f[m] == Integer.MAX_VALUE) {
			f[m] = -1;
		}
		return f[m];
	}
}
