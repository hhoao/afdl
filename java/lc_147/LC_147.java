package lc_147;

import tools.ListNode;

/**
 * @author 黄豪
 *147. 对链表进行插入排序
对链表进行插入排序。


插入排序的动画演示如上。从第一个元素开始，该链表可以被认为已经部分排序（用黑色表示）。
每次迭代时，从输入数据中移除一个元素（用红色表示），并原地将其插入到已排好序的链表中。

 

插入排序算法：

插入排序是迭代的，每次只移动一个元素，直到所有元素可以形成一个有序的输出列表。
每次迭代中，插入排序只从输入数据中移除一个待排序的元素，找到它在序列中适当的位置，并将其插入。
重复直到所有输入数据插入完为止。
 */
public class LC_147 {

}
//我的代码
class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode vir = new ListNode(-1, head);
        ListNode pTail = head;
        while (pTail.next != null){
            if (pTail.next.val > pTail.val){
                pTail = pTail.next;
            }else{
                ListNode cur = pTail.next;
                ListNode post = pTail.next.next;
                pTail.next = post;
                ListNode temp = vir;
                while (cur.val > temp.next.val){
                    temp = temp.next;
                }
                cur.next= temp.next;
                temp.next = cur;
            }
        }
        return vir.next;
    }
}