package lc_237;

import tools.ListNode;

/**
 * @author 黄豪
 *237. 删除链表中的节点
请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。

 

现有一个链表 -- head = [4,5,1,9]，它可以表示为:
 */
public class LC_237 {

}
class Solution {
    public void deleteNode(ListNode node) {
        ListNode next = node.next;
        node.val = next.val;
        ListNode tail = next.next;
        node.next = tail;
    }
}
