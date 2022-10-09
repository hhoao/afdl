//
// Created by hhoa on 22-10-7.
//
#include "vector"
#include "ListNode.h"

using namespace std;

#ifndef LEETCODE_SOLUTION_H
#define LEETCODE_SOLUTION_H

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 * 示例 1：
 * 输入：head = [1,3,2]
 * 输出：[2,3,1]
 */
class Solution {
public:
    static vector<int> reversePrint(ListNode *head);
};


#endif //LEETCODE_SOLUTION_H
