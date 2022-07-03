package lc_98;

import java.util.Deque;
import java.util.LinkedList;
import tools.TreeNode;

/**
 * @author 黄豪
 *98. 验证二叉搜索树
给定一个二叉树，判断其是否是一个有效的二叉搜索树。

假设一个二叉搜索树具有如下特征：

节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。
 */
public class LC_98 {
	public static void main(String[] args) {
		Solution3 solution = new Solution3();
		TreeNode tree7 = new TreeNode(7);
		
		TreeNode tree3 = new TreeNode(3, tree7);
		TreeNode tree6 = new TreeNode(6, tree3);
		//TreeNode tree1 = new TreeNode(-1);
		//TreeNode tree1_2 = new TreeNode(0, tree1);
		TreeNode tree4 = new TreeNode(4);
		TreeNode tree5 = new TreeNode(5, tree4, tree6);
		System.out.println(solution.isValidBST(tree5));
	}
}
// 递归
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }	
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}
//迭代+栈
class Solution1 {
    public boolean isValidBST(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<TreeNode>();
        double inorder = -Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
              // 如果中序遍历得到的节点的值小于等于前一个 inorder，说明不是二叉搜索树
            if (root.val <= inorder) {
                return false;
            }
            inorder = root.val;
            root = root.right;
        }
        return true;
    }
}
//Morris中序遍历
class Solution3 {
	public boolean isValidBST(TreeNode root) {
		double inorder = -Double.MAX_VALUE; 
		while (root != null) {
			if (root.left != null) {
				TreeNode predecessor = root.left;
				while (predecessor.right != null && predecessor.right != root) {
					predecessor = predecessor.right;
				}
				if (predecessor.right == null) {
					predecessor.right = root;
					root = root.left;
				}else {
					predecessor.right = null;
					if (root.val <= inorder) return false;
					inorder = root.val;
					root = root.right;
				}
			}else {
				if (root.val <= inorder) return false;
				inorder = root.val;
				root = root.right;
			}
		}
		return true;
	}
}