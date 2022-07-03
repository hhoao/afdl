#include<stdio.h>
#include<stdlib.h>

enum COLOR {
	RED = 'R',
	BLACK = 'B'
};
typedef struct Node {
	struct Node* parent;
	struct Node* left;
	struct Node* right;
	COLOR color;
	int key;
	int value;
}NODE, * PNODE;

typedef struct RBTree {
	PNODE nil;
	PNODE root;
}RBTREE, * PRBTREE;

PNODE rbGet(PRBTREE prbTree, int key);//获取节点
void inorderTraversal(PRBTREE prbTree);//中序遍历
void inorderTraversal(PRBTREE prbTree, PNODE pNode);//中序遍历
bool rbDeleteFixup(PRBTREE prbTree, PNODE x);//删除修补
bool rbDelete(PRBTREE prbTree, PNODE pNode);//删除
bool rbDelete(PRBTREE prbTree, int key);//删除
PNODE getMiniNode(PRBTREE prbTree, PNODE pNode);//获取最小节点
bool rbPutFixup(PRBTREE prbTree, PNODE pNode);//插入修补
void rightRotate(PRBTREE prbTree, PNODE pre);//右旋
void leftRotate(PRBTREE prbTree, PNODE pre);//左旋
bool rbPut(PRBTREE prbTree, PNODE pNode);//插入
bool rbPut(PRBTREE prbTree, int key, int value);//插入
PRBTREE createRBTree();//创建红黑树

int main() {
	PRBTREE prbTree = createRBTree();
	rbPut(prbTree, 1, 2);
	rbPut(prbTree, 2, 42);
	rbPut(prbTree, 3, 42);
	rbPut(prbTree, 4, 42);
	rbPut(prbTree, 5, 2);
	rbPut(prbTree, 6, 42);
	rbPut(prbTree, 7, 42);
	rbPut(prbTree, 8, 42);
	inorderTraversal(prbTree);
	rbDelete(prbTree, 4);

	printf("\n\n\n");
	inorderTraversal(prbTree);
	return 0;
}
void inorderTraversal(PRBTREE prbTree) {
	inorderTraversal(prbTree, prbTree->root);
}
void inorderTraversal(PRBTREE prbTree, PNODE pNode) {
	if (pNode == prbTree->nil) {
		return;
	}
	inorderTraversal(prbTree, pNode->left);
	printf("key = %d, value = %d, color = %c, parentKey = %d, parentColor = %c\n", pNode->key, pNode->value, pNode->color, pNode->parent->key, pNode->parent->color);
	inorderTraversal(prbTree, pNode->right);
}

PNODE rbGet(PRBTREE prbTree, int key) {
	PNODE res = prbTree->root;
	while (res != prbTree->nil) {
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

PNODE getMiniNode(PRBTREE prbTree, PNODE pNode) {
	while (pNode->left != prbTree->nil) {
		pNode = pNode->left;
	}
	return pNode;
}
void rbTransplant(PRBTREE prbTree, PNODE cur, PNODE pre) {
	if (pre->parent == prbTree->nil) {
		prbTree->root = cur;
	}
	else if (pre->parent->left == pre) {
		pre->parent->left = cur;
	}
	else {
		pre->parent->right = cur;
	}
	cur->parent = pre->parent;
}

bool rbDeleteFixup(PRBTREE prbTree, PNODE x) {
	while (x != prbTree->root && x->color == BLACK) {
		if (x->parent->left == x) {
			PNODE w = x->parent->right;
			if (w->color == RED) {//把红色变节点为x父节点为case2做条件
				w->color = BLACK;
				x->parent->color = RED;
				leftRotate(prbTree, x->parent);
				w = x->parent->right;
			}
			if (w->left->color == BLACK && w->right->color == BLACK) {//让整个支路都少1黑高,x一直上升直到成为红色节点,退出循环后再将x节点转化为黑色增加当前路径的黑高
				w->color = RED;
				x = x->parent;
			}
			else if (w->right->color == BLACK) {//把w->right->color转化为红色,也就是转化为case4再跳出循环
				w->color = RED;//这前后两步是为了不让黑高变化 当前必为红色后转为黑色
				w->left->color = BLACK;
				rightRotate(prbTree, w);
			}
			else {//右边黑高不变增加左边黑高(这种情况w->right->color必为红色)
				w->color = x->parent->color;
				w->right->color = BLACK;
				x->parent->color = BLACK;
				leftRotate(prbTree, x->parent);
				x = prbTree->root;
			}
		}
		else {
			PNODE w = x->parent->left;
			if (w->color == RED) {
				w->color = BLACK;
				x->parent->color = RED;
				rightRotate(prbTree, x->parent);
				w = x->parent->left;
			}
			if (w->left->color == BLACK && w->right->color == BLACK) {
				x = x->parent;
				w->color = RED;
			}
			else if (w->left->color == BLACK) {
				w->right->color = BLACK;
				w->color = RED;
				leftRotate(prbTree, w);
			}
			else {
				w->color = x->parent->color;
				x->parent->color = BLACK;
				w->left->color = BLACK;
				rightRotate(prbTree, x->parent);
				x = prbTree->root;
			}
		}
	}
	x->color = BLACK;
	return true;
}

bool rbDelete(PRBTREE prbTree, PNODE pNode) {
	PNODE y = pNode, x;
	COLOR org_color = y->color;
	if (pNode->left == prbTree->nil) {
		x = pNode->right;
		rbTransplant(prbTree, x, y);
	}
	else if (pNode->right == prbTree->nil) {
		x = pNode->left;
		rbTransplant(prbTree, x, y);
	}
	else {
		y = getMiniNode(prbTree, pNode->right);
		org_color = y->color;
		x = y->right;
		if (y->parent == pNode) {
			x->parent = y;
		}
		else {
			rbTransplant(prbTree, x, y);
			y->right = pNode->right;
			pNode->right->parent = y;
		}
		y->left = pNode->left;
		pNode->left->parent = y;
		rbTransplant(prbTree, y, pNode);
	}
	free(pNode);
	if (org_color == BLACK) {
		return rbDeleteFixup(prbTree, x);
	}
	return true;
}

bool rbDelete(PRBTREE prbTree, int key) {
	return rbDelete(prbTree, rbGet(prbTree, key));
}

void rightRotate(PRBTREE prbTree, PNODE pre) {
	PNODE cur = pre->left;
	pre->left = cur->right;
	if (cur->right != prbTree->nil) {
		cur->right->parent = pre;
	}
	if (pre->parent == prbTree->nil) {
		prbTree->root = cur;
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

void leftRotate(PRBTREE prbTree, PNODE pre) {
	PNODE cur = pre->right;
	pre->right = cur->left;
	if (cur->left != prbTree->nil) {
		cur->left->parent = pre;
	}
	if (pre->parent == prbTree->nil) {
		prbTree->root = cur;
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

bool rbPutFixup(PRBTREE prbTree, PNODE pNode) {
	while (pNode->parent->color == RED) {
		if (pNode->parent->parent->left == pNode->parent->parent) {
			if (pNode->parent->parent->right->color == RED) {//不影响黑高，互换红色节点的位置	
				pNode->parent->parent->right->color = BLACK;
				pNode->parent->parent->color = RED;
				pNode->parent->color = BLACK;
				pNode = pNode->parent->parent;
			}
			else if (pNode == pNode->parent->right) {//不影响黑高，把红色节点顶上去
				pNode = pNode->parent;
				leftRotate(prbTree, pNode);
			}
			else {//完成修补
				pNode->parent->color = BLACK;
				pNode->parent->parent->color = RED;
				rightRotate(prbTree, pNode->parent->parent);
			}
		}
		else {
			if (pNode->parent->parent->left->color == RED) {
				pNode->parent->parent->left->color = BLACK;
				pNode->parent->parent->color = RED;
				pNode->parent->color = BLACK;
				pNode = pNode->parent->parent;
			}
			else if (pNode == pNode->parent->left) {
				pNode = pNode->parent;
				rightRotate(prbTree, pNode);
			}
			else {
				pNode->parent->color = BLACK;
				pNode->parent->parent->color = RED;
				leftRotate(prbTree, pNode->parent->parent);
			}
		}
	}
	prbTree->root->color = BLACK;
	return true;
}

bool rbPut(PRBTREE prbTree, PNODE pNode) {
	PNODE y = prbTree->nil, x = prbTree->root;
	while (x != prbTree->nil) {
		y = x;
		if (pNode->key > x->key) {
			x = x->right;
		}
		else {
			x = x->left;
		}
	}
	pNode->parent = y;
	if (y == prbTree->nil) {
		prbTree->root = pNode;
	}
	else if (y->key > pNode->key) {
		y->left = pNode;
	}
	else {
		y->right = pNode;
	}
	pNode->left = prbTree->nil;
	pNode->right = prbTree->nil;
	return rbPutFixup(prbTree, pNode);
}

bool rbPut(PRBTREE prbTree, int key, int value) {
	PNODE pNode = (PNODE)malloc(sizeof(NODE));
	if (pNode == NULL) {
		printf("内存分配失败，程序终止");
		exit(-1);
	}
	pNode->key = key;
	pNode->value = value;
	pNode->color = RED;
	return	rbPut(prbTree, pNode);
}
PRBTREE createRBTree() {
	PRBTREE prbTree = (PRBTREE)malloc(sizeof(RBTREE));
	if (prbTree == NULL) {
		printf("内存分配失败，程序终止");
		exit(-1);
	}
	PNODE nil = (PNODE)malloc(sizeof(NODE));

	if (nil == NULL) {
		printf("内存分配失败，程序终止");
		exit(-1);
	}
	nil->color = BLACK;
	prbTree->nil = nil;
	prbTree->root = nil;
	return prbTree;
}