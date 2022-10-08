//
// Created by hhoa on 22-9-24.
//
#include "vector"
using namespace std;

#ifndef LEETCODE_SOLUTION_H
#define LEETCODE_SOLUTION_H


class Solution {
public:
    /**
     * 221. 最大正方形
在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
     * @param matrix 正方形矩阵
     * @return 面积
     */
    int maximalSquare(vector<vector<char>> &matrix);
};


#endif //LEETCODE_SOLUTION_H
