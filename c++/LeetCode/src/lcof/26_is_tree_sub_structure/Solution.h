//
// Created by hhoa on 22-10-8.
//

#ifndef LEETCODE_SOLUTION_H
#define LEETCODE_SOLUTION_H
#include "TreeNode.h"

class Solution {
private:
    bool isSubStructure(TreeNode *A, TreeNode *B, bool start);
public:
    bool isSubStructure(TreeNode *A, TreeNode *B);
};



#endif //LEETCODE_SOLUTION_H
