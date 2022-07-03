package lc_257;

import java.util.ArrayList;
import java.util.List;

import tools.TreeNode;

/**
 * @author 黄豪
 *257. 二叉树的所有路径
给定一个二叉树，返回所有从根节点到叶子节点的路径。

说明: 叶子节点是指没有子节点的节点。
 */
public class LC_257 {

}
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        inorderTraversal(root, new StringBuffer(), ans);
        return ans;
    }
    public void inorderTraversal(TreeNode root, StringBuffer sbf, List<String> ans){
        if (root == null) {
            return ;
        }
        
        sbf.append("->"+root.val);
        if (root.left == null && root.right == null) {
            ans.add(sbf.substring(2, sbf.length()).toString());
            return;
        }
        inorderTraversal(root.left, new StringBuffer(sbf.toString()), ans);
        inorderTraversal(root.right, new StringBuffer(sbf.toString()), ans);
    }
}