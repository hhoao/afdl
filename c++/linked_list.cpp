# include <stdio.h>
# include <malloc.h>
# include <stdlib.h>
template <class Type>
class LinkedList
{
	class Node {
	public:
		Node* pNext;
		Type data;
		Node() {}
		Node(Type data) {
			this->data = data;
		}
	};
public:
	Node* node;
	LinkedList() {
		this->node = new Node();
	}
	bool insert(int pos, Type value) {
		int i = 1;
		Node* cur = new Node(value);
		Node* node = this->node->pNext;
		while (node != NULL && i != pos) {
			i++;
			node = node->pNext;
		}
		if (i == pos && node != NULL) {
			cur->pNext = node->pNext;
			node->pNext = &cur;
			return true;
		}
		return false;
	}
	bool add(Type value) {
		Node* new_node = new Node(value);
		Node* cur = this->node;
		while (cur->pNext != NULL) {
			cur = cur->pNext;
		}
		cur->pNext = new_node;
		return true;
	}
	Type get(int index) {
		int i = 0;
		Node* node = this->node->pNext;
		while (node->pNext != NULL && i != index) {
			i++;
			node = node->pNext;
		}
		if (i != index) {
			return NULL;
		}
		return i == index ? node->data : NULL;
	}
	int size()
	{
		int len = 0;
		Node* cur = this->node->pNext;
		while (cur != NULL)
		{
			len++;
			cur = cur->pNext;
		}
		return len;
	}


	bool is_empty()
	{
		return this->node == NULL;
	}
	bool remove(int pos)
	{
		if (pos < 1) {
			return false;
		}
		int i = 1;
		Node* pre = this->node;
		Node* node = pre->pNext;
		while (node != NULL && i != pos) {
			i++;
			pre = pre->pNext;
			node = node->pNext;
		}
		if (i == pos) {
			pre->pNext = node->pNext;
			delete(node);
			return true;
		}
		return false;
	}
};
