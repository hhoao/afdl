package lc_226;

import tools.TreeNode;

/**
 * @author �ƺ�
 *226. ��ת������
��תһ�ö�������
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