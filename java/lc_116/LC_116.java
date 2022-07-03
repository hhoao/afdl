package lc_116;

import tools.Node;

/**
 * @author 黄豪
 *116. 填充每个节点的下一个右侧节点指针
给定一个 完美二叉树 ，其所有叶子节点都在同一层，每个父节点都有两个子节点。二叉树定义如下：

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。

初始状态下，所有 next 指针都被设置为 NULL。
 */
public class LC_116 {

}

//我的代码
class Solution1 {
    public Node connect(Node root) {
        if (root == null) return null;
        Node tail = root;
        Node predecessor = null;
        while (root.left != null){
            predecessor= root.left;
            
            while (root != null){
                Node prenode = root;
                root.left.next = root.right;
                root = root.next;
                if (root != null)
                    prenode.right.next = root.left;
            }
            root = predecessor;
        }
        return tail;
    }
}
//官方
class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        
        Node leftmost = root;
        
        while (leftmost.left != null) {
            Node head = leftmost;
            
            while (head != null) {
                head.left.next = head.right;
                if (head.next != null) {
                    head.right.next = head.next.left;
                }

                head = head.next;
            }

            leftmost = leftmost.left;
        }
        
        return root;
    }
}