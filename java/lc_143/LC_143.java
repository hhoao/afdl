package lc_143;

import tools.ListNode;

/**
 * @author 黄豪
 *143. 重排链表
给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…

你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */
public class LC_143 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution2 solution2 = new Solution2();
        solution2.reorderList(node1);
    }
}

class Solution2 {
    public void reorderList(ListNode head) {
        ListNode left = head, right = head;
        if (head == null || right.next == null || right.next.next == null) {
            return;
        }
        ListNode tail = null;
        while (right.next != null && right.next.next != null) {
            tail = left;
            left = left.next;
            right = right.next.next;
        }
        ListNode middle, pre = null;
        if (right.next != null) {
            tail = left;
            middle = right;
        } else {
            middle = left.next;
        }
        tail.next = null;
        while (middle != null) {
            ListNode tmp = middle.next;
            middle.next = pre;
            pre = middle;
            middle = tmp;
        }
        ListNode current = head;
        while (current != null) {
            ListNode tmp = current.next;
            ListNode midTmp = pre.next;
            current.next = pre;
            pre.next = tmp == null ? pre.next : tmp;
            pre = midTmp;
            current = tmp;
        }
    }
}
//我的代码
class Solution {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode quick = head;
        while (quick.next != null && quick.next.next != null){
            quick = quick.next.next;
            slow = slow.next;
        }
        ListNode post = recoverList(slow.next);
        while (head != slow){
            ListNode next= head.next;
            ListNode postnext =post.next;
            head.next = post;
            post.next = next;
            head = next;
            post = postnext;
        }
        head.next = post;
        if (post != null) post.next = null;
    }
    public ListNode recoverList(ListNode head){
        ListNode prev=  null;
        while (head != null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
