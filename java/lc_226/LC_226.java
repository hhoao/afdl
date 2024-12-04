package lc_226;

import tools.TreeNode;

/**
 * @author 黄豪
 *226. 翻转二叉树
翻转一棵二叉树。
 */
public class LC_226 {

}
class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }
}
