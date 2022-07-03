package lc_144;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import tools.TreeNode;

/**
 * @author 黄豪
 *144. 二叉树的前序遍历
给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */
public class LC_144 {

}
//递归
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preorderTraversal(root, res);
        return res;
    }
    public void preorderTraversal(TreeNode root, List<Integer> res){
        if (root == null) return;
        res.add(root.val);
        preorderTraversal(root.left, res);
        preorderTraversal(root.right, res);
    }
}
//栈
class Solution1 {
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty() || root != null){
            while (root != null){
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            root = root.right;
        }
        return res;
    }
}
//mirrors遍历
class Solution2 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        while (root != null){
            if (root.left != null){
                TreeNode predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root){
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null){
                    predecessor.right = root;
                    res.add(root.val);
                    root = root.left;
                }else{
                    root = root.right;
                    predecessor.right = null;
                }
            }else{
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}