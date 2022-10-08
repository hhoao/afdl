//
// Created by hhoa on 22-10-8.
//

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
示例 1：

输入：A = [1,2,3], B = [3,1]
输出：false
示例 2：

输入：A = [3,4,5,1,2], B = [4,1]
输出：true
 */
#include "Solution.h"

bool Solution::isSubStructure(TreeNode *A, TreeNode *B, bool start) {
    if (B == nullptr) {
        return true;
    }
    if (A == nullptr) {
        return false;
    }
    return (A->val == B->val && isSubStructure(A->right, B->right, true) && isSubStructure(A->left, B->left, true)) ||
           (!start && (isSubStructure(A->left, B, false) || isSubStructure(A->right, B, false)));
}

bool Solution::isSubStructure(TreeNode *A, TreeNode *B) {
    if (B == nullptr) {
        return false;
    }
    return isSubStructure(A, B, false);
}
