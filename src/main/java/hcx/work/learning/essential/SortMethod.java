package hcx.work.learning.essential;

public class SortMethod {

	// ������

	public void heapSort(int[] arr) {
		// ���Ƚ��ѣ������һ����Ҷ�ӽڵ㿪ʼ
		int begin = (arr.length - 2) / 2;
		for (; begin > 0; begin--) {
			heapAdjust(arr, begin, arr.length - 1);
		}

		// ����Ѻ�����
		for (int i = arr.length - 1; i >= 0; i--) {
			// �ѶѶ������һ������
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
		// ����������maxIdx;
		if (arr[maxIdx] > arr[heapPeak]) {
			swap(arr, maxIdx, heapPeak);
			// ��������ڵ�maxIdx���ӽڵ�
			heapAdjust(arr, maxIdx, len);
		}

	}

	// ����
	public void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
