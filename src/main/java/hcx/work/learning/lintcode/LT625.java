package hcx.work.learning.lintcode;

public class LT625 {

    public void partition2(int[] nums, int low, int high) {
	// write your code here
	if (nums == null || nums.length <= 1) {
	    return;
	}
	int first = -1;
	int second = -1;
	int temp = 0;
	int len = nums.length;
	// first指向第一部分的最后一个，second指向第二部分的最后一个
	for (int i = 0; i < len; i++) {
	    if (nums[i] < low) { //
		temp = nums[i];

		nums[i] = nums[second + 1];
		nums[second + 1] = nums[first + 1];
		nums[first + 1] = temp;
		first++;
		second++;
	    } else if (nums[i] <= high) {
		temp = nums[i];
		nums[i] = nums[second + 1];
		nums[second + 1] = temp;
		second++;
	    }
	}
    }
}
