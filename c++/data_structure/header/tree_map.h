#pragma once
class TreeMap {
	enum Color
	{
		RED = 'R',
		BLACK = 'B'
	};
	class Node {
	public:
		Node* parent;
		Node* left;
		Node* right;
		Color color;
		int key;
		int value;
	};

private:
	Node* nil;
	Node* root;
	Node* rbGet(int key);//获取节点
	void inorderTraversal(Node* node);//中序遍历
	bool rbDeleteFixup(Node* x);//删除修补
	bool rbDelete(Node* node);//删除
	Node* getMiniNode(Node* node);//获取最小节点
	bool rbPutFixup(Node* node);//插入修补
	void rightRotate(Node* pre);//右旋
	void leftRotate(Node* pre);//左旋
	bool rbPut(Node* node);//插入
	void rbTransplant(Node* cur, Node* pre);

public:
	TreeMap() {
		Node* nil = new Node;
		nil->color = BLACK;
		this->nil = nil;
		this->root = nil;
	}

	void inorderTraversal();//中序遍历
	bool rbDelete(int key);//删除
	bool rbPut(int key, int value);//插入

};

