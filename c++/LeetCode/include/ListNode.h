//
// Created by hhoa on 22-10-8.
//

#ifndef LEETCODE_LISTNODE_H
#define LEETCODE_LISTNODE_H
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode* next) : val(x), next(next) {}
};
#endif //LEETCODE_LISTNODE_H
