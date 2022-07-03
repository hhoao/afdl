package lc_61;

/**
 * @author 黄豪
 *61. 旋转链表
给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 */
public class LC_61 {

}

class ListNode {
	int val;
	ListNode next;
	ListNode() {}
	ListNode(int val) { this.val = val; }
	ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return null;
		if (head.next == null)
			return head;

		ListNode old_tail = head;
		int n;
		for (n = 1; old_tail.next != null; n++) old_tail = old_tail.next;
		old_tail.next = head;

		ListNode new_tail = head;
		for (int i = 0; i < n - k % n - 1; i++) new_tail = new_tail.next;
		ListNode new_head = new_tail.next;

		new_tail.next = null;
		return new_head;
	}
}