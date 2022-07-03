package lc_226;

import tools.TreeNode;

/**
 * @author »ÆºÀ
 *226. ·­×ª¶þ²æÊ÷
·­×ªÒ»¿Ã¶þ²æÊ÷¡£
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