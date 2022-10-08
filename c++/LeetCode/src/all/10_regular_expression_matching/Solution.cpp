//
// Created by hhoa on 22-9-23.
//

#include <vector>
#include "Solution.h"

// 动态规划
bool Solution::isMatch(string s, string p) {
    vector<vector<int>> dp(s.size() + 1, vector<int>(p.size() + 1));
    dp[0][0] = true;
    for (int i = 1; i <= s.size(); i++) {
        for (int j = 1; j <= p.size(); j++) {
            if (p[j - 1] == '.' || p[j - 1] == s[i - 1]) {
                dp[i][j] = dp[i - 1][j - 1];
            } else if (p[j - 1] == '*') {
                dp[i][j] = dp[i][j - 2];
                if (s[i - 1] == p[j - 2] || p[j - 2] == '.') {
                    dp[i][j] |= dp[i - 1][j];
                }
            }
        }
    }
    return dp[s.size()][p.size()];
}

// 官方动态规划
bool isMatch1(string s, string p) {
    int m = s.size();
    int n = p.size();

    auto matches = [&](int i, int j) {
        if (i == 0) {
            return false;
        }
        if (p[j - 1] == '.') {
            return true;
        }
        return s[i - 1] == p[j - 1];
    };

    vector<vector<int>> f(m + 1, vector<int>(n + 1));
    f[0][0] = true;
    for (int i = 0; i <= m; ++i) {
        for (int j = 1; j <= n; ++j) {
            if (p[j - 1] == '*') {
                f[i][j] |= f[i][j - 2];
                if (matches(i, j - 1)) {
                    f[i][j] |= f[i - 1][j];
                }
            } else {
                if (matches(i, j)) {
                    f[i][j] |= f[i - 1][j - 1];
                }
            }
        }
    }
    return f[m][n];
}
