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

	    // 如果栈不为空，并且当前元素大于栈顶元素
	    while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
		int top = stack.pop(); // 取出栈顶元素
		if (stack.isEmpty()) { // 如果栈空
		    break;
		}
		// 比较取出的栈顶元素所在位置，与其前后的差值
		int topLeft = stack.peek();
		int minHeight = arr[topLeft] > arr[i] ? arr[i] : arr[topLeft];
		ans += (minHeight - arr[top]) * (i - topLeft - 1);
	    }
	    // 当前元素入栈
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
		    // 计算当前位置水滴
		    ans += leftMax - arr[left];
		}
		left++;
	    } else {
		if (arr[right] > rightMax) {
		    rightMax = arr[right];
		} else {
		    // 计算当前位置水滴
		    ans += rightMax - arr[right];
		}
		right--;
	    }
	}
	return ans;
    }

}
