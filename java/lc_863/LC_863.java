package lc_863;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tools.TreeNode;

/*
 *@author: 黄豪
 *@date : 2021年7月29日
 *@todo:
*/
public class LC_863 {

}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    List<Integer> ans = new ArrayList<>();
    Map<TreeNode, TreeNode> map = new HashMap<>();
    public void getK(TreeNode node, int k){
        if (node == null){
            return;
        }
        if (k == 0){
            ans.add(node.val);
            return;
        }
        getK(node.left, k-1);
        getK(node.right, k-1);
    }
    public void findK(TreeNode node, TreeNode preNode, int k){
        if (node == null){
            return;
        }
        if (k == 0){
            ans.add(node.val);
        }
        TreeNode next = node.left == preNode ? node.right : node.left;
        getK(next, k -1);
        findK(map.get(node), node, k - 1);
    }
    public void inTraversal(TreeNode root, TreeNode target, int k){
        if (root == null){
            return;
        }
        if (root == target){
            if (k == 0){
                ans.add(root.val);
                return;
            }
           findK(map.get(root), root, k-1); 
           getK(root.left, k-1);
           getK(root.right, k-1);
           return;
        }
        if (root.left != null) map.put(root.left, root);
        if (root.right != null) map.put(root.right, root);
        inTraversal(root.left, target, k);
        inTraversal(root.right, target, k);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        inTraversal(root, target, k);
        return ans;
    }
}
