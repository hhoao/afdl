#include "tree_map.h"
#include <stdio.h>
#include <stdlib.h>

//红黑树是每个结点都带有颜色属性的二叉查找树，颜色或红色或黑色。[3]  在二叉查找树强制一般要求以外，对于任何有效的红黑树我们增加了如下的额外要求:
//性质1.结点是红色或黑色。[3]
//性质2.根结点是黑色。[3]
//性质3.所有叶子都是黑色。（叶子是NIL结点）[3]
//性质4.每个红色结点的两个子结点都是黑色。（从每个叶子到根的所有路径上不能有两个连续的红色结点）
//性质5.从任一节结点到其每个叶子的所有路径都包含相同数目的黑色结点。[3]

void TreeMap::inorderTraversal() {
	inorderTraversal(this->root);
}
void TreeMap::inorderTraversal(Node* node) {
	if (node == this->nil) {
		return;
	}
	inorderTraversal(node->left);
	printf("key = %d, value = %d, color = %c, parentKey = %d, parentColor = %c\n", node->key, node->value, node->color, node->parent->key, node->parent->color);
	inorderTraversal(node->right);
}
TreeMap::Node* TreeMap::rbGet(int key) {
	Node* res = this->root;
	while (res != this->nil) {
		if (res->key == key) {
			return res;
		}
		else if (res->key > key) {
			res = res->left;
		}
		else {
			res = res->right;
		}
	}
	return NULL;
}

TreeMap::Node* TreeMap::getMiniNode(Node* node) {
	while (node->left != this->nil) {
		node = node->left;
	}
	return node;
}
void TreeMap::rbTransplant(Node* cur, Node* pre) {
	if (pre->parent == this->nil) {
		this->root = cur;
	}
	else if (pre->parent->left == pre) {
		pre->parent->left = cur;
	}
	else {
		pre->parent->right = cur;
	}
	cur->parent = pre->parent;
}

bool TreeMap::rbDeleteFixup(Node* x) {
	while (x != this->root && x->color == BLACK) {
		if (x->parent->left == x) {
			Node* w = x->parent->right;
			if (w->color == RED) {//把红色变节点为x父节点为case2做条件
				w->color = BLACK;
				x->parent->color = RED;
				leftRotate(x->parent);
				w = x->parent->right;
			}
			if (w->left->color == BLACK && w->right->color == BLACK) {//让整个支路都少1黑高,x一直上升直到成为红色节点,退出循环后再将x节点转化为黑色增加当前路径的黑高
				w->color = RED;
				x = x->parent;
			}
			else if (w->right->color == BLACK) {//把w->right->color转化为红色,也就是转化为case4再跳出循环
				w->color = RED;//这前后两步是为了不让黑高变化 当前必为红色后转为黑色
				w->left->color = BLACK;
				rightRotate(w);
			}
			else {//右边黑高不变增加左边黑高(这种情况w->right->color必为红色)
				w->color = x->parent->color;
				w->right->color = BLACK;
				x->parent->color = BLACK;
				leftRotate(x->parent);
				x = this->root;
			}
		}
		else {
			Node* w = x->parent->left;
			if (w->color == RED) {
				w->color = BLACK;
				x->parent->color = RED;
				rightRotate(x->parent);
				w = x->parent->left;
			}
			if (w->left->color == BLACK && w->right->color == BLACK) {
				x = x->parent;
				w->color = RED;
			}
			else if (w->left->color == BLACK) {
				w->right->color = BLACK;
				w->color = RED;
				leftRotate(w);
			}
			else {
				w->color = x->parent->color;
				x->parent->color = BLACK;
				w->left->color = BLACK;
				rightRotate(x->parent);
				x = this->root;
			}
		}
	}
	x->color = BLACK;
	return true;
}

bool TreeMap::rbDelete(Node* node) {
	Node* y = node, * x;
	TreeMap::Color org_color = y->color;
	if (node->left == this->nil) {
		x = node->right;
		rbTransplant(x, y);
	}
	else if (node->right == this->nil) {
		x = node->left;
		rbTransplant(x, y);
	}
	else {
		y = getMiniNode(node->right);
		org_color = y->color;
		x = y->right;
		if (y->parent == node) {
			x->parent = y;
		}
		else {
			rbTransplant(x, y);
			y->right = node->right;
			node->right->parent = y;
		}
		y->color = node->color;
		y->left = node->left;
		node->left->parent = y;
		rbTransplant(y, node);
	}
	delete node;
	if (org_color == BLACK) {
		return rbDeleteFixup(x);
	}
	return true;
}

bool TreeMap::rbDelete(int key) {
	return rbDelete(rbGet(key));
}

void TreeMap::rightRotate(Node* pre) {
	Node* cur = pre->left;
	pre->left = cur->right;
	if (cur->right != this->nil) {
		cur->right->parent = pre;
	}
	if (pre->parent == this->nil) {
		this->root = cur;
	}
	else if (pre == pre->parent->left) {
		pre->parent->left = cur;
	}
	else {
		pre->parent->right = cur;
	}
	cur->parent = pre->parent;
	pre->parent = cur;
	cur->right = pre;
}

void TreeMap::leftRotate(Node* pre) {
	Node* cur = pre->right;
	pre->right = cur->left;
	if (cur->left != this->nil) {
		cur->left->parent = pre;
	}
	if (pre->parent == this->nil) {
		this->root = cur;
	}
	else if (pre->parent->left == pre) {
		pre->parent->left = cur;
	}
	else {
		pre->parent->right = cur;
	}
	cur->parent = pre->parent;
	pre->parent = cur;
	cur->left = pre;
}

bool TreeMap::rbPutFixup(Node* node) {
	while (node->parent->color == RED) {
		if (node->parent->parent->left == node->parent->parent) {
			if (node->parent->parent->right->color == RED) {//不影响黑高，互换红色节点的位置
				node->parent->parent->right->color = BLACK;
				node->parent->parent->color = RED;
				node->parent->color = BLACK;
				node = node->parent->parent;
			}
			else if (node == node->parent->right) {//不影响黑高，把红色节点顶上去
				node = node->parent;
				leftRotate(node);
			}
			else {//完成修补
				node->parent->color = BLACK;
				node->parent->parent->color = RED;
				rightRotate(node->parent->parent);
			}
		}
		else {
			if (node->parent->parent->left->color == RED) {
				node->parent->parent->left->color = BLACK;
				node->parent->parent->color = RED;
				node->parent->color = BLACK;
				node = node->parent->parent;
			}
			else if (node == node->parent->left) {
				node = node->parent;
				rightRotate(node);
			}
			else {
				node->parent->color = BLACK;
				node->parent->parent->color = RED;
				leftRotate(node->parent->parent);
			}
		}
	}
	this->root->color = BLACK;
	return true;
}

bool TreeMap::rbPut(Node* node) {
	Node* y = this->nil, * x = this->root;
	while (x != this->nil) {
		y = x;
		if (node->key > x->key) {
			x = x->right;
		}
		else {
			x = x->left;
		}
	}
	node->parent = y;
	if (y == this->nil) {
		this->root = node;
	}
	else if (y->key > node->key) {
		y->left = node;
	}
	else {
		y->right = node;
	}
	node->left = this->nil;
	node->right = this->nil;
	return rbPutFixup(node);
}

bool TreeMap::rbPut(int key, int value) {
	Node* node = new Node;
	if (node == NULL) {
		printf("内存分配失败，程序终止");
		exit(-1);
	}
	node->key = key;
	node->value = value;
	node->color = RED;
	return rbPut(node);
}
