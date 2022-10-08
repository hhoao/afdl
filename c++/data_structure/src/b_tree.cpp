//
// Created by hhoa on 22-9-28.
//
#include <stack>
#include <iostream>
#include "b_tree.h"
#include "vector"


class b_tree::_tree_node {
public:
    // 关键字
    std::vector<std::pair<int, int>> _k_vs;
    // 是否为叶子
    bool _leaf{true};
    // 孩子
    std::vector<_tree_node *> _children;
    // 最小度
    int _minmum_degree;
    // 关键字个数
    int _n{0};

    _tree_node(bool leaf, int n, int minmum_degree) : _minmum_degree(minmum_degree), _leaf(leaf), _n(n) {
        _children = std::vector<_tree_node *>(_minmum_degree * 2, nullptr);
        _k_vs = std::vector<std::pair<int, int>>(_minmum_degree * 2 - 1);
    };
};

//int b_tree::floor(_tree_node* node, int key) {
//
//}
//int b_tree::ceiling(_tree_node* node, int key) {
//
//}
std::pair<int, int> b_tree::remove(int key, _tree_node *node) {
    int i = 0;
    while (i < node->_n && key > node->_k_vs[i].first) {
        i++;
    }
    if (node->_k_vs[i].first == key) {
        if (node->_leaf) {
            std::pair<int, int> delete_k_v = node->_k_vs[i];
            for (int j = i; j < node->_n - 1; j++) {
                node->_k_vs[i] = node->_k_vs[i + 1];
            }
            node->_n--;
            return delete_k_v;
        } else {
            _tree_node *predecessor = node->_children[i];
            _tree_node *successor = node->_children[i + 1];
            std::pair<int, int> inst(-1, -1);

            if (predecessor->_n >= _minmum_degree) {
                // 2a
                while (!predecessor->_leaf) {
                    predecessor = predecessor->_children[predecessor->_n];
                }
                inst = predecessor->_k_vs[predecessor->_n - 1];
                predecessor->_children[predecessor->_n] = nullptr;
                predecessor->_n--;
            } else if (successor->_n >= _minmum_degree) {
                // 2b
                while (!successor->_leaf) {
                    successor = successor->_children[0];
                }
                inst = successor->_k_vs[0];
                for (int j = 0; j < successor->_n; j++){
                    successor->_k_vs[i] = successor->_k_vs[i+1];
                    successor->_children[i] = successor->_children[i+1];
                }
                successor->_children[successor->_n] = nullptr;
                successor->_n--;
            } else {
                // 2c
                auto ret = node->_k_vs[i];
                for (int j = 0; j < successor->_n; j++) {
                    predecessor->_k_vs[j + predecessor->_n] = successor->_k_vs[j];
                    predecessor->_children[j + predecessor->_n + 1] = successor->_children[j];
                }
                predecessor->_children[2 * (_minmum_degree - 1)] = successor->_children[_minmum_degree - 1];
                _tree_node* remove_node = node->_children[i+1];
                delete remove_node;
                while (i < node->_n - 1) {
                    node->_k_vs[i] = node->_k_vs[i+1];
                    i++;
                }
                node->_n--;
                return ret;
            }
            std::pair<int, int> replace_k_v = remove(inst.first, node);
            node->_k_vs[i] = replace_k_v;
            return node->_k_vs[i];
        }
    }else {
        if (node->_children[i]->_n == _minmum_degree - 1 && node->_children[i]->_n == _minmum_degree - 1){
            // 3b
            node->_children[i]->_k_vs[_minmum_degree] = node->_k_vs[i];
            for (int j = 0; j < _minmum_degree - 1; j++){
                node->_children[i]->_k_vs[_minmum_degree + j + 1] = node->_children[i + 1]->_k_vs[j];
                node->_children[i]->_children[_minmum_degree + j] = node->_children[i + 1]->_children[j];
                node->_children[i + 1]->_children[j] = nullptr;
            }
            node->_children[i]->_children[2 * _minmum_degree + 1] = node->_children[i + 1]->_children[_minmum_degree];
            node->_children[i + 1]->_children[_minmum_degree] = nullptr;

            node->_children[i]->_n += _minmum_degree;
            node->_children[i+1]->_n += 0;

            _tree_node* delete_node = node->_children[i+1];
            while (i < node->_n){
                node->_k_vs[i] = node->_k_vs[i+1];
                node->_children[i+1] = node->_children[i+2];
                i++;
            }
            node->_children[node->_n + 1] = nullptr;
            delete delete_node;
            node->_n--;
            remove(key, node->_children[i]);
        } else{
            // 3a
            remove(key, node->_children[i]);
            if (node->_children[i]->_n == _minmum_degree - 2) {
                node->_children[i]->_k_vs[node->_n] = node->_k_vs[i];
                node->_children[i]->_children[node->_n+1] = node->_children[i+1]->_children[0];
                node->_k_vs[i] = node->_children[i+1]->_k_vs[0];
                for (int j = 0; j < node->_children[i+1]->_n; j++){
                    node->_children[i+1]->_k_vs[j] = node->_children[i+1]->_k_vs[j+1];
                    node->_children[i+1]->_children[j] = node->_children[i+1]->_children[j+1];
                }
                node->_children[i+1]->_children[node->_children[i+1]->_n] = nullptr;
                node->_children[i+1]->_n--;
            }
        }
    }
}

void b_tree::remove(int key) {
    remove(key, this->_root);
}

std::vector<std::pair<int, int>> b_tree::traverse() {
    std::vector<std::pair<int, int>> res;
    std::stack<std::pair<_tree_node *, std::pair<_tree_node *, int>>> stk;
    std::pair<_tree_node *, std::pair<_tree_node *, int>> curr(this->_root,
                                                               std::pair<_tree_node *, int>(nullptr, 1));
    while (!stk.empty() || curr.first != nullptr) {
        while (curr.first && !curr.first->_leaf) {
            stk.push(curr);
            curr = std::pair<_tree_node *, std::pair<_tree_node *, int>>(curr.first->_children[0],
                                                                         std::pair<_tree_node *, int>(
                                                                                 curr.first, 1));
        }
        if (curr.second.second - 1 > curr.second.first->_n) {
            curr = stk.top();
            if (curr.second.first == nullptr) return res;
            if (curr.second.second - 1 < curr.second.first->_n) {
                res.emplace_back(curr.second.first->_k_vs[curr.second.second - 1]);
            }
            stk.pop();
        } else {
            if (curr.first->_leaf) {
                for (int i = 0; i < curr.first->_n; i++) {
                    res.emplace_back(curr.first->_k_vs[i]);
                }
            }
            if (curr.second.second - 1 < curr.second.first->_n) {
                res.emplace_back(curr.second.first->_k_vs[curr.second.second - 1]);
            }
        }
        curr = std::pair<_tree_node *, std::pair<_tree_node *, int>>(
                curr.second.first->_children[curr.second.second],
                std::pair<_tree_node *, int>(
                        curr.second.first,
                        curr.second.second + 1));
    }
    return res;
};


b_tree::b_tree() {
    _root = new _tree_node(true, 0, _minmum_degree);
}

b_tree::~b_tree() {
    if (_root == nullptr) {
        return;
    }
    std::stack<_tree_node *> stk;
    _tree_node *p = _root;
    while (!stk.empty() || p != nullptr) {
        if (!p->_leaf) {
            for (_tree_node *child: p->_children) {
                if (child != nullptr) {
                    stk.push(child);
                }
            }
        }
        delete p;
        p = nullptr;
        if (!stk.empty()) {
            p = stk.top();
            stk.pop();
        }
    }
}


void b_tree::split_child(_tree_node *x, int index) const {
    _tree_node *y = x->_children[index];
    auto *z = new _tree_node(y->_leaf, _minmum_degree - 1, this->_minmum_degree);

    for (int i = 0; i < this->_minmum_degree - 1; i++) {
        z->_k_vs[i] = y->_k_vs[i + this->_minmum_degree];
    }
    if (!y->_leaf) {
        for (int i = 0; i < this->_minmum_degree; i++) {
            z->_children[i] = y->_children[i + this->_minmum_degree];
            y->_children[i + this->_minmum_degree] = nullptr;
        }
    }
    y->_n = this->_minmum_degree - 1;
    for (int i = x->_n; i >= index + 1; i--) {
        x->_children[i + 1] = x->_children[i];
    }
    x->_children[index + 1] = z;
    for (int i = x->_n - 1; i >= index; i--) {
        x->_k_vs[i + 1] = x->_k_vs[i];
    }
    x->_k_vs[index] = y->_k_vs[_minmum_degree - 1];
//    y->_k_vs[_minmum_degree].first = -1;
//    y->_k_vs[_minmum_degree].second = -1;
    x->_n++;
}

void b_tree::put(int key, int value) {
    _tree_node *r = this->_root;
    if (r->_n == 2 * this->_minmum_degree - 1) {
        auto s = new _tree_node(false, 0, this->_minmum_degree);
        this->_root = s;
        s->_children[0] = r;
        split_child(s, 0);
        insert_non_full(s, key, value);
    } else {
        insert_non_full(this->_root, key, value);
    }
}

int b_tree::search(_tree_node *root, int key) {
    int i = 0;
    while (i < root->_n && key > root->_k_vs[i].first) {
        i++;
    }
    if (i < root->_n && key == root->_k_vs[i].first) {
        return root->_k_vs[i].second;
    } else if (root->_leaf) {
        return -1;
    } else {
        return search(root->_children[i], key);
    }
}

void b_tree::insert_non_full(_tree_node *x, int key, int value) {
    int i = x->_n;
    if (x->_leaf) {
        while (i > 0 && key < x->_k_vs[i - 1].first) {
            x->_k_vs[i] = x->_k_vs[i - 1];
            i--;
        }
        std::pair<int, int> pair(key, value);
        x->_k_vs[i] = pair;
        x->_n++;
    } else {
        while (i > 0 && key < x->_k_vs[i - 1].first) {
            i--;
        }

        if (x->_children[i]->_n == 2 * _minmum_degree - 1) {
            split_child(x, i);
            if (key > x->_k_vs[i].first) {
                i++;
            }
        }
        insert_non_full(x->_children[i], key, value);
    }
}

int b_tree::search(int key) {
    return search(_root, key);
}
