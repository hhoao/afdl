//
// Created by hhoa on 22-9-29.
//
#include "vector"
#include "TreeNode.h"

#ifndef LEETCODE_SOLUTION_H
#define LEETCODE_SOLUTION_H
/**
 * 94. 二叉树的中序遍历
给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 */
class Solution {
public:
    /**
     * 迭代
     * @param root
     * @return
     */
    static std::vector<int> inorderTraversal(TreeNode *root);
    /**
     * Mirrors
     * @param root 根节点
     * @return 遍历结果
     */
    static std::vector<int> inorderTraversal1(TreeNode *root);
};


#endif //LEETCODE_SOLUTION_H
