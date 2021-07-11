package hcx.work.learning.leetcode;

import java.util.Deque;
import java.util.LinkedList;

public class LC42 {

    public static void main(String[] args) {
	int[] arr = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
	System.out.println("stack: " + methodStack(arr));
	System.out.println("multi pointer: " + methodMultiPointer(arr));
    }

    // stack
    public static int methodStack(int[] arr) {
	Deque<Integer> stack = new LinkedList<Integer>();
	int ans = 0;
	int len = arr.length;

	for (int i = 0; i < len; i++) {

	    // ���ջ��Ϊ�գ����ҵ�ǰԪ�ش���ջ��Ԫ��
	    while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
		int top = stack.pop(); // ȡ��ջ��Ԫ��
		if (stack.isEmpty()) { // ���ջ��
		    break;
		}
		// �Ƚ�ȡ����ջ��Ԫ������λ�ã�����ǰ��Ĳ�ֵ
		int topLeft = stack.peek();
		int minHeight = arr[topLeft] > arr[i] ? arr[i] : arr[topLeft];
		ans += (minHeight - arr[top]) * (i - topLeft - 1);
	    }
	    // ��ǰԪ����ջ
	    stack.push(i);
	}
	return ans;

    }

    public static int methodMultiPointer(int[] arr) {
	int left = 0;
	int right = arr.length - 1;
	int leftMax = 0;
	int rightMax = 0;
	int ans = 0;

	while (left < right) {
	    if (arr[left] < arr[right]) {
		if (arr[left] > leftMax) {
		    leftMax = arr[left];
		} else {
		    // ���㵱ǰλ��ˮ��
		    ans += leftMax - arr[left];
		}
		left++;
	    } else {
		if (arr[right] > rightMax) {
		    rightMax = arr[right];
		} else {
		    // ���㵱ǰλ��ˮ��
		    ans += rightMax - arr[right];
		}
		right--;
	    }
	}
	return ans;
    }

}
