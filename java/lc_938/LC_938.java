package lc_938;

import java.util.ArrayDeque;
import java.util.Deque;

import tools.TreeNode;

/**
 * @author 黄豪
 *938. 二叉搜索树的范围和
给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 */
public class LC_938 {

}
//我的代码递归
class Solution {
    private int sum, low, high;
    public int rangeSumBST(TreeNode root, int low, int high) {
        this.sum = 0; 
        this.low = low;
        this.high = high;
        inorderTraversal(root);
        return sum;
    }
    public void inorderTraversal(TreeNode root){
        if (root == null) return;
        inorderTraversal(root.left);
        if (root.val >= low && root.val <= high) sum+=root.val;
        inorderTraversal(root.right);
    }
}
//栈
class Solution1 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum =  0;
        Deque<TreeNode> stack  = new ArrayDeque<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if (root.val >= low && root.val <= high) sum+=root.val;
            root = root.right;
        }
        return sum;
    }
}
//mirrors中序遍历
class Solution2 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        while (root != null){
            if (root.left != null){
                TreeNode decessor = root.left;
                while (decessor.right != null && decessor.right != root){
                    decessor = decessor.right;
                }
                if (decessor.right == null){
                    decessor.right = root;
                    root = root.left;
                }else{
                    if (root.val >= low && root.val <= high) sum+=root.val;
                    decessor.right = null;
                    root = root.right;
                }
            }else{
                if (root.val >= low && root.val <= high) sum+=root.val;
                root = root.right;
            }
        }
        return sum;
    }
}
