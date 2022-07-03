package lc_109;

import java.util.ArrayList;
import java.util.List;

import tools.ListNode;
import tools.TreeNode;

/**
 * @author 黄豪
 *109. 有序链表转换二叉搜索树
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。

本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 */
public class LC_109 {

}
class Solution {
	private List<Integer> list;
    public TreeNode sortedListToBST(ListNode head) {
    	buildArray(head);
    	if (list == null || list.size() == 0) return null; 
    	return buildBST(0, list.size() - 1);
    }
    private TreeNode buildBST(int l, int r) {
    	if (l > r) return null;
    	int mid = (l + r) >> 1;
    	TreeNode root=  new TreeNode(list.get(mid));
    	root.left = buildBST(l, mid - 1);
    	root.right = buildBST(mid + 1, r);
    	return root;
    }
    private void buildArray(ListNode head) {
    	list = new ArrayList<>();
    	while(head != null) {
    		list.add(head.val);
    		head = head.next;
    	}
    }
}
//官方//分治
class Solution1 {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }
        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
//分治,中序遍历加优化
class Solution2 {
    ListNode globalHead;

    public TreeNode sortedListToBST(ListNode head) {
        globalHead = head;
        int length = getLength(head);
        return buildTree(0, length - 1);
    }

    public int getLength(ListNode head) {
        int ret = 0;
        while (head != null) {
            ++ret;
            head = head.next;
        }
        return ret;
    }

    public TreeNode buildTree(int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right + 1) / 2;
        TreeNode root = new TreeNode();
        root.left = buildTree(left, mid - 1);
        root.val = globalHead.val;
        globalHead = globalHead.next;
        root.right = buildTree(mid + 1, right);
        return root;
    }
}