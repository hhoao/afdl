//
// Created by hhoa on 22-9-25.
//

#include <vector>
#include "Solution.h"
#include "iostream"

int main(){
    vector<int> nums({2, 3, 1, 0, 2, 5, 3});
    int repeat_num =  Solution::findRepeatNumber(nums);
    std::cout << repeat_num;
}