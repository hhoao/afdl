package lc_113;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import tools.TreeNode;

/**
 * @author 黄豪
 *113. 路径总和 II
给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。

叶子节点 是指没有子节点的节点。
 */
public class LC_113 {

}
//递归
class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
    	if (root == null) return res;
        dfs(res, root, 0, targetSum, new ArrayList<Integer>());
        return res;
    }
    public void dfs(List<List<Integer>> res, TreeNode root, int num, int targetSum, List<Integer> temp) {
        temp.add(root.val);
    	if (root.left == null && root.right == null && num +root.val == targetSum) {
    		res.add(new ArrayList<>(temp)); 
            temp.remove(temp.size() - 1);
    		return ;
    	}else if (root.left == null && root.right == null) {
            temp.remove(temp.size() - 1);
    		return;
    	}
		if (root.left != null) {
			dfs(res, root.left, num + root.val, targetSum, temp);
			
		}
		if (root.right != null) {
			dfs(res, root.right, num + root.val, targetSum, temp);
		}
		temp.remove(temp.size() - 1);
    }
}
//官方
//深度优先搜索
class Solution1 {
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Deque<Integer> path = new LinkedList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        dfs(root, sum);
        return ret;
    }

    public void dfs(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        path.offerLast(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            ret.add(new LinkedList<Integer>(path));
        }
        dfs(root.left, sum);
        dfs(root.right, sum);
        path.pollLast();
    }
}
//广度优先搜索
class Solution2 {
    List<List<Integer>> ret = new LinkedList<List<Integer>>();
    Map<TreeNode, TreeNode> map = new HashMap<TreeNode, TreeNode>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queueNode = new LinkedList<TreeNode>();
        Queue<Integer> queueSum = new LinkedList<Integer>();
        queueNode.offer(root);
        queueSum.offer(0);

        while (!queueNode.isEmpty()) {
            TreeNode node = queueNode.poll();
            int rec = queueSum.poll() + node.val;

            if (node.left == null && node.right == null) {
                if (rec == sum) {
                    getPath(node);
                }
            } else {
                if (node.left != null) {
                    map.put(node.left, node);
                    queueNode.offer(node.left);
                    queueSum.offer(rec);
                }
                if (node.right != null) {
                    map.put(node.right, node);
                    queueNode.offer(node.right);
                    queueSum.offer(rec);
                }
            }
        }

        return ret;
    }

    public void getPath(TreeNode node) {
        List<Integer> temp = new LinkedList<Integer>();
        while (node != null) {
            temp.add(node.val);
            node = map.get(node);
        }
        Collections.reverse(temp);
        ret.add(new LinkedList<Integer>(temp));
    }
}