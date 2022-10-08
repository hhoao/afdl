//
// Created by hhoa on 22-10-7.
//
#include <cassert>
#include <iostream>
#include "Solution.h"

int main(){
    ListNode node(1);
    ListNode node3(3);
    ListNode node2(2);
    node.next = &node3;
    node3.next = &node2;

    auto res = Solution::reversePrint(&node);
    std::vector compared({2, 3, 1});
    assert(res == compared);
}
