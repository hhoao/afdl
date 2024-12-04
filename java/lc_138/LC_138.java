package lc_138;

import java.util.HashMap;
import java.util.Map;

import tools.Node;

/**
 * @author 黄豪 138. 复制带随机指针的链表 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random
 *         ，该指针可以指向链表中的任何节点或空节点。
 * 
 *         构造这个链表的 深拷贝。 深拷贝应该正好由 n 个 全新 节点组成，其中每个新节点的值都设为其对应的原节点的值。新节点的 next 指针和
 *         random
 *         指针也都应指向复制链表中的新节点，并使原链表和复制链表中的这些指针能够表示相同的链表状态。复制链表中的指针都不应指向原链表中的节点 。
 * 
 *         例如，如果原链表中有 X 和 Y 两个节点，其中 X.random --> Y 。那么在复制链表中对应的两个节点 x 和 y ，同样有
 *         x.random --> y 。
 * 
 *         返回复制链表的头节点。
 * 
 *         用一个由 n 个节点组成的链表来表示输入/输出中的链表。每个节点用一个 [val, random_index] 表示：
 * 
 *         val：一个表示 Node.val 的整数。 random_index：随机指针指向的节点索引（范围从 0 到
 *         n-1）；如果不指向任何节点，则为 null 。 你的代码 只 接受原链表的头节点 head 作为传入参数。
 */
public class LC_138 {

}

//我的代码
class Solution {
	Map<Node, Node> map = new HashMap<>();

	public Node copyRandomList(Node head) {
		if (head == null)
			return null;
		if (map.containsKey(head))
			return map.get(head);
		Node node = new Node(head.val);
		map.put(head, node);
		node.random = copyRandomList(head.random);
		node.next = copyRandomList(head.next);
		return node;
	}
}

//官方 回溯
class Solution1 {
	// HashMap which holds old nodes as keys and new nodes as its values.
	HashMap<Node, Node> visitedHash = new HashMap<Node, Node>();

	public Node copyRandomList(Node head) {

		if (head == null) {
			return null;
		}

		// If we have already processed the current node, then we simply return the
		// cloned version of
		// it.
		if (this.visitedHash.containsKey(head)) {
			return this.visitedHash.get(head);
		}

		// Create a new node with the value same as old node. (i.e. copy the node)
		Node node = new Node(head.val);

		// Save this value in the hash map. This is needed since there might be
		// loops during traversal due to randomness of random pointers and this would
		// help us avoid
		// them.
		this.visitedHash.put(head, node);

		// Recursively copy the remaining linked list starting once from the next
		// pointer and then from
		// the random pointer.
		// Thus we have two independent recursive calls.
		// Finally we update the next and random pointers for the new node created.
		node.next = this.copyRandomList(head.next);
		node.random = this.copyRandomList(head.random);

		return node;
	}
}

//空间迭代
/*
 * //Definition for a Node. class Node { public int val; public Node next;
 * public Node random;
 * 
 * public Node() {}
 * 
 * public Node(int _val,Node _next,Node _random) { val = _val; next = _next;
 * random = _random; } };
 */
class Solution2 {
// Visited dictionary to hold old node reference as "key" and new node reference as the "value"
	HashMap<Node, Node> visited = new HashMap<Node, Node>();

	public Node getClonedNode(Node node) {
		// If the node exists then
		if (node != null) {
			// Check if the node is in the visited dictionary
			if (this.visited.containsKey(node)) {
				// If its in the visited dictionary then return the new node reference from the
				// dictionary
				return this.visited.get(node);
			} else {
				// Otherwise create a new node, add to the dictionary and return it
				this.visited.put(node, new Node(node.val));
				return this.visited.get(node);
			}
		}
		return null;
	}

	public Node copyRandomList(Node head) {

		if (head == null) {
			return null;
		}

		Node oldNode = head;

		// Creating the new head node.
		Node newNode = new Node(oldNode.val);
		this.visited.put(oldNode, newNode);

		// Iterate on the linked list until all nodes are cloned.
		while (oldNode != null) {
			// Get the clones of the nodes referenced by random and next pointers.
			newNode.random = this.getClonedNode(oldNode.random);
			newNode.next = this.getClonedNode(oldNode.next);

			// Move one step ahead in the linked list.
			oldNode = oldNode.next;
			newNode = newNode.next;
		}
		return this.visited.get(head);
	}
}
