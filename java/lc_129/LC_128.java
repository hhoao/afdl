package lc_129;

import java.util.LinkedList;
import java.util.Queue;

import tools.TreeNode;

/**
 * @author 黄豪
 *129. 求根节点到叶节点数字之和
给你一个二叉树的根节点 root ，树中每个节点都存放有一个 0 到 9 之间的数字。
每条从根节点到叶节点的路径都代表一个数字：

例如，从根节点到叶节点的路径 1 -> 2 -> 3 表示数字 123 。
计算从根节点到叶节点生成的 所有数字之和 。

叶节点 是指没有子节点的节点。
 */
public class LC_128 {

}
//我的题解
class Solution {
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        preOrderTraverse(root, 0);
        return sum;
    }
    public void preOrderTraverse(TreeNode root, int total){
        total = total * 10 + root.val;
        if (root.left == null && root.right== null) sum += total;
        
        if (root.left != null) preOrderTraverse(root.left, total);
        if (root.right != null) preOrderTraverse(root.right, total);
    }
}
//官方 深度优先搜索
class Solution1 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int prevSum) {
        if (root == null) {
            return 0;
        }
        int sum = prevSum * 10 + root.val;
        if (root.left == null && root.right == null) {
            return sum;
        } else {
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
//广度优先搜索
class Solution2 {
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        Queue<Integer> numQueue = new LinkedList<Integer>();
        nodeQueue.offer(root);
        numQueue.offer(root.val);
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            int num = numQueue.poll();
            TreeNode left = node.left, right = node.right;
            if (left == null && right == null) {
                sum += num;
            } else {
                if (left != null) {
                    nodeQueue.offer(left);
                    numQueue.offer(num * 10 + left.val);
                }
                if (right != null) {
                    nodeQueue.offer(right);
                    numQueue.offer(num * 10 + right.val);
                }
            }
        }
        return sum;
    }
}
