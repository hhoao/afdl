package lc_897;

import tools.TreeNode;

/**
 * @author 黄豪
 *897. 递增顺序搜索树
给你一棵二叉搜索树，请你 按中序遍历 将其重新排列为一棵递增顺序搜索树，使树中最左边的节点成为树的根节点，并且每个节点没有左子节点，只有一个右子节点。
 */
public class LC_897 {

}
//我的代码
class Solution {
    private TreeNode head;
    public TreeNode increasingBST(TreeNode root) {
        head = new TreeNode();
        TreeNode phead = head;
        inorderTraversal(root);
        return phead.right;
    }
    public void inorderTraversal(TreeNode root){
        if (root == null) return;
        inorderTraversal(root.left);
        head.right = new TreeNode(root.val);
        head = head.right;
        inorderTraversal(root.right);
    }
}
//原地修改
class Solution1 {
    private TreeNode head;
    private TreeNode currNode;
    public TreeNode increasingBST(TreeNode root) {
        head = new TreeNode();
        currNode = head;
        inorderTraversal(root);
        return head.right;
    }
    public void inorderTraversal(TreeNode root){
        if (root == null) return;
        inorderTraversal(root.left);
        root.left = null;
        currNode.right = root;
        currNode = currNode.right;
        inorderTraversal(root.right);
    }
}