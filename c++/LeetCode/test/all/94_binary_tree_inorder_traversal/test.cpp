//
// Created by hhoa on 22-9-29.
//

#include <iostream>
#include <cassert>
#include "Solution.h"

int main(){
    TreeNode treeNode1({1, 2, 3, 4, 5, 6});
    std::vector<int> vec = Solution::inorderTraversal(&treeNode1);
    assert(vec == std::vector({4, 2, 5, 1, 6, 3}));
}
