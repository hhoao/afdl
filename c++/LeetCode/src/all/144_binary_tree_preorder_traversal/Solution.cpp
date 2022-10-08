//
// Created by hhoa on 22-9-29.
//

#include <functional>
#include <stack>
#include "Solution.h"

std::vector<int> Solution::preorderTraversal(TreeNode *root) {
    std::function<void(TreeNode *, std::vector<int> &)> f;
    f = [&](TreeNode *root, std::vector<int> &vec) {
        if (root == nullptr) {
            return;
        }
        vec.emplace_back(root->val);

        f(root->left, vec);
        f(root->right, vec);
    };
    std::vector<int> ans;
    f(root, ans);
    return ans;
}

std::vector<int> Solution::preorderTraversal1(TreeNode *root) {
    std::vector<int> ans;
    std::stack<TreeNode *> stk;
    while (root != nullptr || !stk.empty()) {
        while (root != nullptr) {
            ans.emplace_back(root->val);
            stk.push(root);
            root = root->left;
        }
        root = stk.top();
        stk.pop();
        root = root->right;
    }
    return ans;
}

// mirrors
std::vector<int> Solution::preorderTraversal2(TreeNode *root) {
    std::vector<int> ans;
    TreeNode *processor;
    while (root != nullptr) {
        if (root->left != nullptr) {
            processor = root->left;
            while (processor->right != nullptr && processor->right != root) {
                processor = processor->right;
            }
            if (processor->right == root) {
                processor->right = nullptr;
                root = root->right;
            } else {
                processor->right = root;
                ans.emplace_back(root->val);
                root = root->left;
            }
        } else {
            ans.emplace_back(root->val);
            root = root->right;
        }
    }
    return ans;
}

//官方 Mirrors
 std::vector<int> Solution::preorderTraversal3(TreeNode *root) {
    std::vector<int> res;
    if (root == nullptr) {
        return res;
    }

    TreeNode *p1 = root, *p2 = nullptr;

    while (p1 != nullptr) {
        p2 = p1->left;
        if (p2 != nullptr) {
            while (p2->right != nullptr && p2->right != p1) {
                p2 = p2->right;
            }
            if (p2->right == nullptr) {
                res.emplace_back(p1->val);
                p2->right = p1;
                p1 = p1->left;
                continue;
            } else {
                p2->right = nullptr;
            }
        } else {
            res.emplace_back(p1->val);
        }
        p1 = p1->right;
    }
    return res;
}