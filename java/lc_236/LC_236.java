package lc_236;

import tools.TreeNode;

/**
 * @author 黄豪
 *236. 二叉树的最近公共祖先
给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LC_236 {

}
class Solution {
    private TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.ans = null;
        dfs(root, p, q);
        return this.ans;
    }
    public boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if (root == null) return false;
        boolean isL = dfs(root.left, p, q);
        boolean isR = dfs(root.right, p, q);
        if ((isL && isR) || (root.val == p.val || root.val == q.val) && (isL || isR)){
            this.ans = root;
        }
        return root.val == p.val || root.val == q.val || isL || isR;
    }
}