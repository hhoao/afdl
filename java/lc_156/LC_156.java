package lc_156;

import tools.ListNode;

/**
 * @author 黄豪
 *160. 相交链表
编写一个程序，找到两个单链表相交的起始节点。	
 */
public class LC_156 {

}
//我的代码
class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int n = 0, m = 0;
        ListNode tailA = headA, tailB = headB;
        while (tailA != null && tailB != null){
            tailA = tailA.next;
            n++;
            tailB = tailB.next;
            m++;
        }
        if (tailA == null){
            while (tailB != null){
                m++;
                tailB = tailB.next;
            }
        }else{
            while (tailA != null){
                n++;
                tailA = tailA.next;
            }
        }
        if (n > m){
            for (int i = 0; i< n - m; i++){
                headA = headA.next;
            }
        }else{
            for (int i = 0; i< m - n; i++){
                headB = headB.next;
            }
        }
        while (headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        return headA;
    }
}
