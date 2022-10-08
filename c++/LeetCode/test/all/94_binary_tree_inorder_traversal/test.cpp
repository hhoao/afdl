//
// Created by hhoa on 22-9-29.
//

#include <iostream>
#include <cassert>
#include "Solution.h"

int main(){
    TreeNode treeNode1(1);
    TreeNode treeNode2(2);
    TreeNode treeNode3(3);
    treeNode1.right = &treeNode2;
    treeNode2.left = &treeNode3;
    std::vector<int> vec = Solution::inorderTraversal1(&treeNode1);
    assert(vec == std::vector({1, 3, 2}));
}