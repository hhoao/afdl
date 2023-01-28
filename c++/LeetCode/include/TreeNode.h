//
// Created by hhoa on 22-10-8.
//
#include <queue>
#include <utility>
#include <stack>
#include <string>
#include <optional>
#include "vector"

typedef bool STATUS;
#ifndef LEETCODE_TREENODE_H
#define LEETCODE_TREENODE_H
#define null nullptr

struct nullable_int {
    nullable_int *null_value;
    int value;

    nullable_int(nullable_int *v) {
        if (v == nullptr) {
            null_value = v;
        }
    }
    nullable_int(int v) : value(v) {
        null_value = this;
    }
};

class TreeNode {
public:
    TreeNode *left{};
    TreeNode *right{};
    int val{};

    TreeNode(std::vector<nullable_int> vec) {
        buildTree(std::move(vec));
    }

    ~TreeNode() {
        delete this->left;
        delete this->right;
    }

private:
    explicit TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    void buildTree(std::vector<nullable_int> vec) {
        this->val = vec[0].value;
        std::queue<TreeNode *> queue;
        TreeNode *cur = this;
        for (int i = 1; i < vec.size(); i++) {
            if (i % 2 == 0) {
                if (vec[i].null_value == nullptr){
                    cur->right = nullptr;
                }else {
                    cur->right = new TreeNode(vec[i].value);
                    queue.push(cur->right);
                }
                cur = queue.front();
                queue.pop();
            } else {
                if (vec[i].null_value == nullptr) {
                    cur->left = nullptr;
                }else{
                    cur->left = new TreeNode(vec[i].value);
                    queue.push(cur->left);
                }
            }
        }
    }
};

#endif //LEETCODE_TREENODE_H
