#include <vector>
#include "Solution.h"

using namespace std;
//
// Created by hhoa on 22-9-25.
//

int Solution::findRepeatNumber(vector<int> &nums) {
    vector<int> visited(nums.size());
    vector<int> repeat;
    for (int num: nums) {
        if (!visited[num]) {
            visited[num] = true;
        } else {
            return num;
        }
    }
    return 0;
}

// 官方: 原地交换
int findRepeatNumber1(vector<int> &nums) {
    int i = 0;
    while (i < nums.size()) {
        if (nums[i] == i) {
            i++;
            continue;
        }
        if (nums[nums[i]] == nums[i])
            return nums[i];
        swap(nums[i], nums[nums[i]]);
    }
    return -1;
};
