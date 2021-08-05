package hcx.work.learning.leetcode;

public class LC25 {
	class ListNode {
		int val;
		ListNode next;

		ListNode() {
		}

		ListNode(int val) {
			this.val = val;
		}

		ListNode(int val, ListNode next) {
			this.val = val;
			this.next = next;
		}
	}

	public ListNode reverseKGroup(ListNode head, int k) {
		ListNode ans = new ListNode(0, head);
		ListNode pre = ans;
		ListNode tail = ans;

		while (tail.next != null) {
			for (int i = 0; i < k && tail != null; i++) {
				tail = tail.next;

			}
			if (tail == null) {
				break;
			}

			ListNode start = pre.next;
			ListNode next = tail.next;

			tail.next = null;

			pre.next = reverse(start);
			start.next = next;
			pre = start;
			tail = start;
		}

		return ans;
	}

	public ListNode reverse(ListNode head) {
		ListNode pre = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
}
