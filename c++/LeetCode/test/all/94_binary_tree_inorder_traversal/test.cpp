//
// Created by hhoa on 22-9-29.
//

#include <iostream>
#include <cassert>
#include "Solution.h"

int main(){
    TreeNode treeNode1({1, 2, 3});
    std::vector<int> vec = Solution::inorderTraversal1(&treeNode1);
    assert(vec == std::vector({2, 1, 3}));
}