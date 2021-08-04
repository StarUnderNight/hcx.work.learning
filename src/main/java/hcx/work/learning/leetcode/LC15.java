package hcx.work.learning.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC15 {
	public static void main(String[] args) {
		int[] arr = { 0, -1, 1, 2, -1, -1, -2 };
		new LC15().heapSort(arr);
		System.out.println("������" + Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println("������2 " + Arrays.toString(arr));
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
			// ���nums[i] > 0����ô����������Ľ���϶�����0����ֱ��break;
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
					// ����ֵ
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

	// ������

	public void heapSort(int[] nums) {
		// ������
		int len = nums.length;
		int begin = (len - 2) / 2; // ���н��ѵ����һ����Ҷ�ӽڵ�
		for (int i = begin; i >= 0; i--) {
			maxHeap(nums, i, len);
		}
		// ��ʱnums��һ���󶥶ѣ����Ű���������
		for (int i = len - 1; i > 0; i--) {
			// ������һ��Ԫ�غ�i��Ȼ����¶�
			swap(nums, 0, i);
			maxHeap(nums, 0, i);
		}

	}

	public void maxHeap(int[] nums, int root, int size) {
		// 0 - size�൱����û������õ����飬��size+1 - len�����Ѿ�������˵�
		int maxIdx = root * 2 + 1; // ��Ҷ�ӽڵ�
		if (maxIdx >= size) { // û��Ҷ�ӽڵ��ˣ�ֱ�ӷ���
			return;
		}
		// �ж���û����Ҷ�ӽڵ�
		int right = (root + 1) * 2;
		if (right < size) {
			// ˵����Ҷ�ӽڵ�
			// �Ƚ������ӽڵ�˭��
			maxIdx = nums[maxIdx] > nums[right] ? maxIdx : right;
		}
		// �����ӽڵ������ֵ��root�Ƚ�
		if (nums[root] < nums[maxIdx]) {
			// ����
			swap(nums, root, maxIdx);
			// ͬʱ����maxIdx�Ķ�
			maxHeap(nums, maxIdx, size);
		}
	}

	public void swap(int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
