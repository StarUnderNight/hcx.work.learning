package hcx.work.learning.struct;

public class DynamicProcess {

	/** main ����
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
	 * @return �ߵ�(m-1, n-1)λ�õķ�ʽ
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
	 * lint 669 ������ͬ����Ӳ���Լ�һ���ܽ��. дһ������������������ܽ����Ի�ȡ�����ٵ�Ӳ������.
	  * �������Ӳ�ҵ�������Ͼ��޷����ܽ��������, ��ô���� -1. ���룺 [1, 2, 5] 11 ����� 3 ���ͣ� 11 = 5 + 5 + 1
	 * 
	 * @param arr Ӳ������
	 * @param m   �ܽ��
	 * @return
	 */
	public static int coinChange(int[] arr, int m) {
		// �ȿ�����
		int[] f = new int[m + 1]; // f[i] ��ʾ��ֵΪiʱ������Ҫ����СӲ����
		int len = arr.length;

		f[0] = 0;
		for (int i = 1; i <= m; i++) {
			f[i] = Integer.MAX_VALUE;
			for (int j = 0; j < len; j++) { // ������ֵ
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
