#include "linked_list.h"

template
class linked_list<int>;

template<class type>
class linked_list<type>::_list_node {
public:
    _list_node *pNext = nullptr;
    type data;

    _list_node() = default;;

    explicit _list_node(type data) {
        this->data = data;
    }
};

template<class type>
linked_list<type>::linked_list() {
    this->_node = new _list_node();
}

template<class type>
linked_list<type>::~linked_list() {
    _list_node *p = this->_node;
    while (p != nullptr) {
        _list_node *pre_node = p;
        p = p->pNext;
        delete pre_node;
    }
}

template<class type>
bool linked_list<type>::insert(int index, type value) {
    int i = 0;
    auto *cur = new _list_node(value);
    _list_node *node = this->_node;
    while (node != nullptr && i != index) {
        i++;
        node = node->pNext;
    }
    if (i == index && node != nullptr) {
        cur->pNext = node->pNext;
        node->pNext = cur;
        return true;
    }
    return false;
}

template<class Type>
bool linked_list<Type>::add(Type value) {
    auto *new_node = new _list_node(value);
    _list_node *cur = this->_node;
    while (cur->pNext != nullptr) {
        cur = cur->pNext;
    }
    cur->pNext = new_node;
    return true;
}

template<class Type>
Type linked_list<Type>::get(int index) {
    int i = 0;
    _list_node *node = this->_node->pNext;
    while (node->pNext != nullptr && i != index) {
        i++;
        node = node->pNext;
    }
    if (i != index) {
        return 0;
    }
    return i == index ? node->data : 0;
}

template<class Type>
int linked_list<Type>::size() {
    int len = 0;
    _list_node *cur = this->_node->pNext;
    while (cur != nullptr) {
        len++;
        cur = cur->pNext;
    }
    return len;
}


template<class Type>
bool linked_list<Type>::is_empty() {
    return this->_node->pNext == nullptr;
}

template<class Type>
bool linked_list<Type>::remove(int index) {
    if (index < 0) {
        return false;
    }
    int i = 0;
    _list_node *pre = this->_node;
    _list_node *node = pre->pNext;
    while (node != nullptr && i != index) {
        i++;
        pre = pre->pNext;
        node = node->pNext;
    }
    if (i == index) {
        pre->pNext = node->pNext;
        delete (node);
        return true;
    }
    return false;
}