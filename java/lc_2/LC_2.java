/**
时间：2020年10月8日21:58:01
题目：两数相加——2
*给出两个?非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照?逆序?的方式存储的，并且它们的每个节点只能存储?一位?数字。
*
*如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
*
*您可以假设除了数字 0 之外，这两个数都不会以 0?开头。
*
*示例：
*
*输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
*输出：7 -> 0 -> 8
*原因：342 + 465 = 807
**/
package lc_2;
import java.util.*;

public class LC_2 {
	public static void main(String[] args) throws Exception {
		Scanner s = new Scanner(System.in);
		ListNode l1 = null, l2 = null, head1 = null, head2 = null;

		System.out.println("请输入ListNode1中的数:");
		while(s.hasNextInt()) {
			if (head1 == null) {
				head1 = l1 = new ListNode(s.nextInt());
			}else {
				head1.next = new ListNode(s.nextInt());
				head1 = head1.next;
			}
		}
		s.nextLine();
		System.out.println("请输入ListNode2中的数:");
		while(s.hasNextInt()) {
			if (head2 == null) {
				head2 = l2 = new ListNode(s.nextInt());
			}else {
				head2.next = new ListNode(s.nextInt());
				head2 = head2.next;
			}
		}
		s.close();
		
		ListNode l3 = Solution.addTwoNumbers(l1, l2);

		while (l3 != null) {
			System.out.printf("%d  ", l3.val);
			l3 = l3.next;
		}
	}
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
			
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        
        return head;
    }
}
