package lc_1609;

import java.util.ArrayDeque;
import java.util.Deque;

import tools.TreeNode;

/*
 *@author: 黄豪
 *@date : 2021年12月25日
 *@todo:1609. 奇偶树
如果一棵二叉树满足下述几个条件，则可以称为 奇偶树 ：

二叉树根节点所在层下标为 0 ，根的子节点所在层下标为 1 ，根的孙节点所在层下标为 2 ，依此类推。
偶数下标 层上的所有节点的值都是 奇 整数，从左到右按顺序 严格递增
奇数下标 层上的所有节点的值都是 偶 整数，从左到右按顺序 严格递减
给你二叉树的根节点，如果二叉树为 奇偶树 ，则返回 true ，否则返回 false 。
*/
public class LC_1609 {

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
//队列层序遍历
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        int tier = 0;
        if (root.val % 2 == 0){
            return false;
        }
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size(); 
            int pre = 0;
            for (int i = 0; i < size; i++){
                if (i != 0){
                    if (tier % 2 == 0){
                        if (queue.peek().val <= pre){
                            return false;
                        }
                    }else{
                        if (queue.peek().val >= pre){
                            return false;
                        }
                    }
                }
                TreeNode curNode = queue.poll();
                pre = curNode.val;
                if (pre % 2 == 0 && tier % 2 == 0) return false;
                if (pre % 2 == 1 && tier % 2 == 1) return false;
                if (curNode.left != null){
                    queue.offer(curNode.left);
                }
                if (curNode.right != null){
                    queue.offer(curNode.right);
                }
            }
            tier++;
        }
        return true;
    }
}