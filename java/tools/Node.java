package tools;

import java.util.ArrayList;
import java.util.List;

public class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;
	public List<Node> neighbors;
	public Node random;
	public Node(int val) {
		this.val = val;
		next =null;
		random = null;
		neighbors = new ArrayList<>();
	}
	public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
	public Node(int val, Node left, Node right, Node next) {
		super();
		this.val = val;
		this.left = left;
		this.right = right;
		this.next = next;
	}
	public int getVal() {
		return val;
	}
	public void setVal(int val) {
		this.val = val;
	}
	public Node getLeft() {
		return left;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public Node getRight() {
		return right;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public Node getNext() {
		return next;
	}
	public void setNext(Node next) {
		this.next = next;
	}
}
