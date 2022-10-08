//
// Created by hhoa on 22-9-24.
//

#include "Solution.h"

int Solution::maximalSquare(vector<vector<char>> &matrix) {
    int n = matrix.size();
    int m = matrix[0].size();
    int size = 0;
    vector<vector<int>> f(n, vector<int>(m));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (matrix[i][j] == '1') {
                if (i == 0 || j == 0) {
                    f[i][j] = 1;
                } else {
                    f[i][j] = min(f[i - 1][j - 1], min(f[i - 1][j], f[i][j - 1])) + 1;
                }
                size = max(size, f[i][j]);
            }
        }
    }
    return size * size;
}