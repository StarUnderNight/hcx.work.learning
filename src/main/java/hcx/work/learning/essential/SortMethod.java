package hcx.work.learning.essential;

public class SortMethod {

	// 堆排序

	public void heapSort(int[] arr) {
		// 首先建堆，从最后一个非叶子节点开始
		int begin = (arr.length - 2) / 2;
		for (; begin > 0; begin--) {
			heapAdjust(arr, begin, arr.length - 1);
		}

		// 建完堆后，排序
		for (int i = arr.length - 1; i >= 0; i--) {
			// 把堆顶和最后一个交换
			swap(arr, 0, i);
			heapAdjust(arr, 0, i - 1);
		}
	}

	public void heapAdjust(int[] arr, int heapPeak, int len) {

		int leftChild = heapPeak * 2 + 1;
		int rightChild = (heapPeak + 1) * 2;
		if (leftChild > len) {
			return;
		}
		int maxIdx = leftChild;
		if (rightChild < len && arr[leftChild] < arr[rightChild]) {
			maxIdx = rightChild;
		}
		// 交换顶点与maxIdx;
		if (arr[maxIdx] > arr[heapPeak]) {
			swap(arr, maxIdx, heapPeak);
			// 继续考察节点maxIdx的子节点
			heapAdjust(arr, maxIdx, len);
		}

	}

	// 交换
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
