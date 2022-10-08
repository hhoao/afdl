//
// Created by hhoa on 22-10-8.
//
#include <cassert>
#include <iostream>
#include "Solution.h"


int main(){
    auto* A = new TreeNode({3,4,5,1,2});
    auto* B = new TreeNode({4, 1});
    Solution solution;
    assert(solution.isSubStructure(A, B) == true);
    auto* A1 = new TreeNode({1, 2, 3});
    auto* B1 = new TreeNode({3, 1});
    assert(solution.isSubStructure(A1, B1) == false);
    delete A;
    delete B;
    delete A1;
    delete B1;
}