//
// Created by hhoa on 22-10-8.
//
#include <queue>
#include <utility>
#include <stack>
#include "vector"

#ifndef LEETCODE_TREENODE_H
#define LEETCODE_TREENODE_H

class TreeNode {
public:
    int val{};
    TreeNode *left{};
    TreeNode *right{};

    explicit TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}

    explicit TreeNode(std::vector<int> vec) {
        buildTree(std::move(vec));
    }

    ~TreeNode() {
        delete this->left;
        delete this->right;
    }

private:
    void buildTree(std::vector<int> vec) {
        this->val = vec[0];
        std::queue<TreeNode *> queue;
        TreeNode *cur = this;
        for (int i = 1; i < vec.size(); i++) {
            if (i % 2 == 0) {
                cur->right = new TreeNode(vec[i]);
                queue.push(cur->right);
                cur = queue.front();
                queue.pop();
            } else {
                cur->left = new TreeNode(vec[i]);
                queue.push(cur->left);
            }
        }
    }
};

#endif //LEETCODE_TREENODE_H
