#include "vector"
#include "TreeNode.h"
//
// Created by hhoa on 22-9-29.
//

#ifndef LEETCODE_SOLUTION_H
#define LEETCODE_SOLUTION_H

/**
 * 144. 二叉树的前序遍历
给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
 */

class Solution {
public:
    /**
     * 递归
     * @param root 根节点
     * @return 遍历的结果
     */
    static std::vector<int> preorderTraversal(TreeNode *root);
    /**
     * 迭代
     * @param root 根节点
     * @return 遍历的结果
     */
    static std::vector<int> preorderTraversal1(TreeNode *root);
    /**
     * Mirrors
     */
    static std::vector<int> preorderTraversal2(TreeNode *root);
    /**
     * 官方Mirrors
     * @param root 根节点
     * @return 遍历的结果
     */
    static std::vector<int> preorderTraversal3(TreeNode *root);
};


#endif //LEETCODE_SOLUTION_H
