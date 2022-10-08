//
// Created by hhoa on 22-10-7.
//

#include "Solution.h"

string Solution::replaceSpace(string s) {
    string ans;
    for (char i : s){
        if (i == ' ') {
            ans.append("%20");
        }else{
            ans.append(1, i);
        }
    }
    return ans;
}
