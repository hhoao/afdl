//
// Created by hhoa on 22-9-29.
//

#include <stack>
#include "Solution.h"

std::vector<int> Solution::inorderTraversal(TreeNode *root) {
    std::vector<int> ans;
    std::stack<TreeNode *> stack;
    while (root != nullptr || !stack.empty()) {
        while (root != nullptr){
            stack.push(root);
            root = root->left;
        }
        root = stack.top();
        ans.emplace_back(root->val);
        stack.pop();
        root = root->right;
    }
    return ans;
}

std::vector<int> Solution::inorderTraversal1(TreeNode *root) {
    std::vector<int> res;
    TreeNode* predecessor = nullptr;
    while (root != nullptr){
        if (root->left != nullptr) {
            predecessor = root->left;
            while (predecessor ->right != nullptr && predecessor->right != root){
                predecessor = predecessor->right;
            }
            if (predecessor->right == root){
                res.emplace_back(root->val);
                predecessor->right = nullptr;
                root = root->right;
            }else{
                predecessor->right = root;
                root = root->left;
            }
        } else{
            res.emplace_back(root->val);
            root = root->right;
        }
    }
    return res;
}