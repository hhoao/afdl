package lc_783;

import java.util.ArrayDeque;
import java.util.Deque;

import tools.TreeNode;

/**
 * @author 黄豪
 *783. 二叉搜索树节点最小距离
给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同
 */
public class LC_783 {

}
class Solution {
    private int pre = - 1;
    private int ans = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        this.ans = Integer.MAX_VALUE;
        this.pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root) {
        if (root == null) return ;
        dfs(root.left);
        if (pre == -1){
            pre = root.val;
        }else{
            ans = Math.min(root.val - pre, ans);
            pre = root.val;
        }
        dfs(root.right);
    }
}
//迭代
class Solution1 {
    private int pre = - 1;
    private int ans = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        this.ans = Integer.MAX_VALUE;
        this.pre = -1;
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (!deque.isEmpty() || root != null){
            while(root != null){
                deque.push(root);
                root = root.left;
            }
            root = deque.pop();
            if (pre == -1){
                pre = root.val;
            }else{
                ans = Math.min(root.val - pre, ans);
                pre = root.val;
            }
            root = root.right;
        }
        return ans;
    }
}
//mirror
class Solution2 {
    private int pre = - 1;
    private int ans = Integer.MAX_VALUE;

    public int minDiffInBST(TreeNode root) {
        this.ans = Integer.MAX_VALUE;
        this.pre = -1;
        while (root != null){
            if (root.left != null){
                TreeNode decessor = root.left;
                while (decessor.right != null && decessor.right != root){
                    decessor = decessor.right;
                }
                if (decessor.right == null){
                    decessor.right=root;
                    root = root.left;
                }else{
                    if (pre == -1){
                    pre = root.val;
                    }else{
                        ans = Math.min(root.val - pre, ans);
                        pre = root.val;
                    }
                    decessor.right = null;
                    root = root.right;
                }
            }else{
                if (pre == -1){
                    pre = root.val;
                }else{
                    ans = Math.min(root.val - pre, ans);
                    pre = root.val;
                }
                root = root.right;
            }
        }
        return ans;
    }
}