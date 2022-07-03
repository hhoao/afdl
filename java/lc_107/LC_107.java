package lc_107;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tools.TreeNode;

/**
 * @author 黄豪
 *107. 二叉树的层序遍历 II
给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class LC_107 {

}
class Solution{
	public List<List<Integer>> levelOrderBottom(TreeNode root){
		List<List<Integer>> res = new ArrayList<>();
		if (root == null) return res;
		Deque<TreeNode> queue = new ArrayDeque<>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> level = new ArrayList<>();
			for (int i = 0 ;i < size; i++) {
				TreeNode node = queue.poll();
				level.add(node.val);
				if (node.left != null ) queue.offer(node.left);
				if (node.right != null) queue.offer(node.right);
			}
			res.add(level);
		}
		Collections.reverse(res);
		return res;
	}
}
//官方	
class Solution1 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList<List<Integer>>();
        if (root == null) {
            return levelOrder;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                TreeNode left = node.left, right = node.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            levelOrder.add(0, level);
        }
        return levelOrder;
    }
}