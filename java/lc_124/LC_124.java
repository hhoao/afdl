package lc_124;

import tools.TreeNode;

/**
 * @author 黄豪
 *124. 二叉树中的最大路径和
路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。

路径和 是路径中各节点值的总和。

给你一个二叉树的根节点 root ，返回其 最大路径和 。
 */
public class LC_124 {

}
//我的代码
class Solution {
    int maxTotal = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        getTotal(root);
        return maxTotal;
    }
    public int getTotal(TreeNode root){
        int leftMaxSum = 0, rightMaxSum = 0;
        if (root.left != null) leftMaxSum = getTotal(root.left);   
        if (root.right != null) rightMaxSum = getTotal(root.right);
        int tempTotal = Math.max(root.val, Math.max(leftMaxSum+root.val, rightMaxSum+root.val));
        maxTotal = Math.max(maxTotal, Math.max(tempTotal, leftMaxSum+root.val + rightMaxSum));
        return tempTotal;
    }
}
//官方
class Solution1 {
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }
        
        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.val + leftGain + rightGain;

        // 更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }
}