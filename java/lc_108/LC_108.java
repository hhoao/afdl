package lc_108;

import tools.TreeNode;

/**
 * @author 黄豪
 *108. 将有序数组转换为二叉搜索树
给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。

高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
public class LC_108 {

}
//中序遍历,左边数字作为根节点
class Solution{
	public TreeNode sortedArrayToBST(int[] nums) {
		return buildBST(nums, 0, nums.length - 1);
	}
	private TreeNode buildBST(int[] nums, int l, int r) {
		if (l > r) return null;
		int mid = (l + r) >> 1;
		TreeNode root= new TreeNode(nums[mid]);
		root.left = buildBST(nums, l, mid - 1);
		root.right = buildBST(nums, mid + 1, r);
		return root;
	}
}