package hcx.work.learning.lintcode;

public class LT31 {
    public static void main(String[] args) {
	int[] arr = { 2, 4, 434, 54, 34 };

    }
    // 自己做的
    // public int partitionArray(int[] nums, int k) {
    // // write your code here
    // int len = nums.length;
    // if (len == 0) {
    // return 0;
    // }
    // int left = 0;
    // int right = len - 1;
    // int temp = 0;
    // while (left < right) {
    // if (nums[left] >= k) {
    // temp = nums[left];
    // nums[left] = nums[right];
    // nums[right] = temp;
    // right--;
    // } else {
    // left++;
    // }
    // }

    // return nums[left] < k ? left + 1 : left;
    // }

    // 标准答案
    public int partitionArray(int[] nums, int k) {
	int len = nums.length;
	int left = 0;
	int right = len - 1;

	while (left <= right) {
	    while (left <= right && nums[left] < k) {
		left++;
	    }
	    while (left <= right && nums[right] >= k) {
		right--;
	    }

	    if (left <= right) {
		int temp = nums[left];
		nums[left] = nums[right];
		nums[right] = temp;
		left++;
		right--;
	    }
	}
	return left;
    }
}
