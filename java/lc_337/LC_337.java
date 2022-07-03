package lc_337;

import tools.TreeNode;

/*
 *@author: 黄豪
 *@date : 2021年9月28日
 *@todo:337. 打家劫舍 III
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
*/
public class LC_337 {

}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private void dfs(TreeNode root){
        if (root == null)
            return;
        int i = root.val;
        int j = 0;
        if (root.right != null){
            dfs(root.right);
            j += root.right.val;
            if (root.right.left != null){
                i+= root.right.left.val;
            }
            if (root.right.right != null){
                i+= root.right.right.val;
            }
        }
        if (root.left != null){
            dfs(root.left);
            j += root.left.val;
            if (root.left.left != null){
                i+= root.left.left.val;
            }
            if (root.left.right != null){
                i+= root.left.right.val;
            }
        }
        root.val = Math.max(i, j);
        return;
    }
    public int rob(TreeNode root) {
        dfs(root);
        return root.val;
    }
}