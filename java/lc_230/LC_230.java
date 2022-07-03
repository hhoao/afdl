package lc_230;

import java.util.ArrayDeque;
import java.util.Deque;

import tools.TreeNode;

/**
 * @author 黄豪
 *230. 二叉搜索树中第K小的元素
给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。

 
 */
public class LC_230 {

}
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        while (root != null || !stack.isEmpty()){
            while (root != null){
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            if (--k == 0) return root.val;
            root = root.right; 
        }
        return -1;
    }
}