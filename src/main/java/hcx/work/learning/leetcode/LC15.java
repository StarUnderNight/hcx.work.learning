package hcx.work.learning.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
	public static void main(String[] args) {
		int[] arr = { 0, -1, 1, 2, -1, -1, -2 };
		new LC15().heapSort(arr);
		System.out.println("排序结果" + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("排序结果2 " + Arrays.toString(arr));
		List<List<Integer>> list = new LC15().threeSum(arr);
		for (int i = 0; i < list.size(); i++) {
			List<Integer> tmp = list.get(i);
			for (int j = 0; j < tmp.size(); j++) {
				System.out.print(" " + tmp.get(j));
			}
			System.out.println();
		}
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 3) {
			return list;
		}

		int len = nums.length;
		int left = 0;
		int right = 0;

		heapSort(nums);

		for (int i = 0; i < len; i++) {
			// 如果nums[i] > 0，那么后面加起来的结果肯定大于0，则直接break;
			if (nums[i] < 0) {
				break;
			}
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}

			left = i + 1;
			right = len - 1;

			while (left < right) {

				int res = nums[left] + nums[right] + nums[i];
				if (res == 0) {
					// 加入值
					List<Integer> tmpList = new ArrayList<Integer>();
					tmpList.add(nums[i]);
					tmpList.add(nums[left]);
					tmpList.add(nums[right]);
					list.add(tmpList);
					left++;
					right--;

				} else if (res > 0) {
					right--;
				} else {
					left++;
				}

				while (left < right && nums[left] == nums[left + 1]) {
					left++;
				}
				while (left < right && nums[right] == nums[right - 1]) {
					right--;
				}
			}
		}
		return list;

	}

	// 堆排序

	public void heapSort(int[] nums) {
		// 构建堆
		int len = nums.length;
		int begin = (len - 2) / 2; // 进行建堆的最后一个非叶子节点
		for (int i = begin; i >= 0; i--) {
			maxHeap(nums, i, len);
		}
		// 此时nums是一个大顶堆，接着把数组排序
		for (int i = len - 1; i > 0; i--) {
			// 交换第一个元素和i，然后更新堆
			swap(nums, 0, i);
			maxHeap(nums, 0, i);
		}

	}

	public void maxHeap(int[] nums, int root, int size) {
		// 0 - size相当于是没有排序好的数组，而size+1 - len，是已经排序好了的
		int maxIdx = root * 2 + 1; // 左叶子节点
		if (maxIdx >= size) { // 没有叶子节点了，直接返回
			return;
		}
		// 判断有没有右叶子节点
		int right = (root + 1) * 2;
		if (right < size) {
			// 说明有叶子节点
			// 比较左右子节点谁大
			maxIdx = nums[maxIdx] > nums[right] ? maxIdx : right;
		}
		// 左右子节点中最大值和root比较
		if (nums[root] < nums[maxIdx]) {
			// 交换
			swap(nums, root, maxIdx);
			// 同时调整maxIdx的堆
			maxHeap(nums, maxIdx, size);
		}
	}

	public void swap(int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
