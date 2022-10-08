//
// Created by hhoa on 22-10-7.
//

#include <algorithm>
#include "Solution.h"

vector<int> Solution::reversePrint(ListNode *head) {
    vector<int> res;
    ListNode* p = head;
    while (p != nullptr){
        res.emplace_back(p->val);
        p = p->next;
    }
    reverse(res.begin(), res.end());
    return res;
}
