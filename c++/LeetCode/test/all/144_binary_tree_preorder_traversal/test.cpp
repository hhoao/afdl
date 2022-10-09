#include <iostream>
#include "Solution.h"
#include <assert.h>

//
// Created by hhoa on 22-9-29.
//

int main(){
    TreeNode treeNode1({1, 2, 3});
    std::vector<int> vec = Solution::preorderTraversal(&treeNode1);
    assert(vec == std::vector({1, 2, 3}));
    std::vector<int> vec1 = Solution::preorderTraversal1(&treeNode1);
    assert(vec1 == std::vector({1, 2, 3}));
    std::vector<int> vec2 = Solution::preorderTraversal2(&treeNode1);
    assert(vec2== std::vector({1, 2, 3}));
}