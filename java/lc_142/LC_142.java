package lc_142;

import tools.ListNode;

/**
 * @author 黄豪
 *142. 环形链表 II
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。

说明：不允许修改给定的链表。

进阶：

你是否可以使用 O(1) 空间解决此题？
 */
public class LC_142 {

}
// 使用快慢指针在环形链表中只有两种情况
// 1. 慢指针和快指针间隔两个距离
//    这时候无论谁先动，在下一步都是间隔一个距离。
// 2. 慢指针和快指针间隔一个距离
//    这时候无论谁先动，后动那个指针都会遇上先动的指针。
//快慢指针
class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode quick = head;
        while (quick.next != null && quick.next.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if (slow == quick){
                ListNode ptr = head;
                while (ptr != slow){
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }
}

class Solution1 {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slot = head.next, fast = head.next.next;
        while (slot != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            slot = slot.next;
            fast = fast.next.next;
        }
        ListNode start = head;
        while (start != slot) {
            start = start.next;
            slot = slot.next;
        }
        return start;
    }
}
