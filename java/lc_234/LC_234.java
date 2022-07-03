package lc_234;

import tools.ListNode;

/**
 * @author 黄豪
 *234. 回文链表
请判断一个链表是否为回文链表。
 */
public class LC_234 {

}
//哈希法
class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode t=head;
		int base = 11, mod = 1000000007;
    	int left = 0, right = 0, mul = 1;
        while(t!=null){
        	left = (int) (((long) left * base + t.val) % mod);
        	right = (int) ((right + (long) mul * t.val) % mod);
            mul = (int) ((long) mul * base % mod);
            t=t.next;
        }
        return left==right;
    }
}
//快慢指针
class Solution1 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }        

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode reverseList(ListNode head) {
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

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}