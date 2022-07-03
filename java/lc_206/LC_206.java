package lc_206;

/**
 * @author 黄豪
 *206. 反转链表
反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class LC_206 {
	
}

class ListNode{
	int val;
	ListNode next;
	ListNode(int val){
		this.val = val;
	}
	ListNode(int val, ListNode next){
		this.val = val;
		this.next = next;
	}
}
//遍历
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
}


//递归
class Solution2{
	public ListNode reverseList(ListNode head) {
		if (head != null && head.next != null) {
			return head;			
		}
		ListNode p = reverseList(head.next);
		head.next.next = head;
		head.next = null;
		return p;
	}
}