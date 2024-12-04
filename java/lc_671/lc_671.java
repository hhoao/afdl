package lc_671;

import tools.TreeNode;

/*
 *@author: 黄豪
 *@date : 2021年7月27日
 *@todo:671. 二叉树中第二小的节点
给定一个非空特殊的二叉树，每个节点都是正数，并且每个节点的子节点数量只能为 2 或 0。如果一个节点有两个子节点的话，那么该节点的值等于两个子节点中较小的一个。

更正式地说，root.val = min(root.left.val, root.right.val) 总成立。

给出这样的一个二叉树，你需要输出所有节点中的第二小的值。如果第二小的值不存在的话，输出 -1 。
*/
public class lc_671 {

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
    int second = -1;
    public void find(TreeNode root){
        if (root == null){
            return;
        }
       if (root.left.val == root.val){
            if (root.right.val != root.val){
                second = second == -1 ? root.right.val : Math.min(root.right.val, second);
            }
            findSecondMinimumValue(root.left);
        }
        if (root.right.val == root.val){
            if (root.left.val != root.val){
                second = second == -1 ? root.left.val : Math.min(root.left.val, second);
            }
            findSecondMinimumValue(root.right);
        } 
    }
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null){
            return -1;
        }
        find(root);
        
        return second;
    }
}
