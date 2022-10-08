//
// Created by hhoa on 22-9-25.
//

#include "Solution.h"

bool Solution::findNumberIn2DArray(vector<vector<int>> &matrix, int target) {
    int n = matrix.size();
    int m = matrix[0].size();
    int l = 0, r = n - 1;
    if (m == 0 || n == 0) {
        return false;
    }

    while (l < r) {
        int mid = (r - l + 1) / 2 + l;
        if (matrix[mid][0] > target) {
            r = mid - 1;
        } else {
            l = mid;
        }
    }
    int x = l;
    l = 0, r = m - 1;
    while (l < r) {
        int mid = (r - l + 1) / 2 + l;
        if (matrix[0][mid] > target) {
            r = mid - 1;
        } else {
            l = mid;
        }
    }
    int y = l;
    for (int i = 0; i <= x; i++) {
        for (int j = 0; j <= y; j++) {
            if (matrix[i][j] == target) {
                return true;
            }
        }
    }
    return false;
}

bool findNumberIn2DArray(vector<vector<int>> &matrix, int target) {
    int i = matrix.size() - 1, j = 0;
    while (i >= 0 && j < matrix[0].size()) {
        if (matrix[i][j] > target) i--;
        else if (matrix[i][j] < target) j++;
        else return true;
    }
    return false;
}