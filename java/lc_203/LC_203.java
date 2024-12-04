package lc_203;

import tools.ListNode;

/**
 * @author 黄豪
 *203. 移除链表元素
给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 */
public class LC_203 {

}
//我的代码
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return head;
        ListNode vir = new ListNode(-1, head);
       
        ListNode pTail = head, pre = vir;
        
        while (pTail != null){
            while (pTail != null && pTail.val == val){
                pTail = pTail.next;
                pre.next = pTail;
            }
            pre = pre.next;
            if (pTail != null) pTail = pTail.next;
        }
        return vir.next;
    }
}
