package lc_94;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import tools.TreeNode;

/**
 * @author 黄豪
 *94. 二叉树的中序遍历
给定一个二叉树的根节点 root ，返回它的 中序 遍历。
 */
public class LC_94 {
}

//栈
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        Deque<TreeNode> stk = new LinkedList<TreeNode>();
        while (root != null || !stk.isEmpty()) {
            while (root != null) {
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
//递归
class Solution1{
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> ans=  new ArrayList<Integer>();
		traversal(root, ans);
		return ans;
	}
	public void traversal(TreeNode node, List<Integer> ans) {
		if (node == null) return ; 
		traversal(node.left, ans);
		ans.add(node.val);
		traversal(node.right, ans);
	}
}
//Morris中序遍历
class Solution3 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode predecessor = null;

        while (root != null) {
            if (root.left != null) {
                // predecessor 节点就是当前 root 节点向左走一步，然后一直向右走至无法走为止
                predecessor = root.left;
                while (predecessor.right != null && predecessor.right != root) {
                    predecessor = predecessor.right;
                }
                
                // 让 predecessor 的右指针指向 root，继续遍历左子树
                if (predecessor.right == null) {
                    predecessor.right = root;
                    root = root.left;
                }
                // 说明左子树已经访问完了，我们需要断开链接
                else {
                    res.add(root.val);
                    predecessor.right = null;
                    root = root.right;
                }
            }
            // 如果没有左孩子，则直接访问右孩子
            else {
                res.add(root.val);
                root = root.right;
            }
        }
        return res;
    }
}