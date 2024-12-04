package lc_2928;

/**
 * LC_2928
 * //给你两个正整数 n 和 limit 。
 * //
 * // 请你将 n 颗糖果分给 3 位小朋友，确保没有任何小朋友得到超过 limit 颗糖果，请你返回满足此条件下的 总方案数 。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：n = 5, limit = 2
 * //输出：3
 * //解释：总共有 3 种方法分配 5 颗糖果，且每位小朋友的糖果数不超过 2 ：(1, 2, 2) ，(2, 1, 2) 和 (2, 2, 1) 。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：n = 3, limit = 3
 * //输出：10
 * //解释：总共有 10 种方法分配 3 颗糖果，且每位小朋友的糖果数不超过 3 ：(0, 0, 3) ，(0, 1, 2) ，(0, 2, 1) ，(0, 3,
 * // 0) ，(1, 0, 2) ，(1, 1, 1) ，(1, 2, 0) ，(2, 0, 1) ，(2, 1, 0) 和 (3, 0, 0) 。
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= n <= 50
 * // 1 <= limit <= 50
 * //
 * //
 * // Related Topics 数学 组合数学 枚举 👍 53 👎 0
 * @author xianxing
 * @since 2024/6/1
 **/

public class LC_2928 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.distributeCandies(3, 3);
        System.out.println(i);
    }
}

class Solution {
    public int distributeCandies(int n, int limit) {
        return cal(n + 2) - 3 * cal(n - limit + 1) + 3 * cal(n - (limit + 1) * 2 + 2) - cal(n - 3 * (limit + 1) + 2);
    }

    public int cal(int x) {
        if (x < 0) {
            return 0;
        }
        return x * (x - 1) / 2;
    }
}

class Solution2 {
    public int distributeCandies(int n, int limit) {
        int ans = 0;
        for (int i = 0; i <= Math.min(limit, n); i++) {
            if (n - i > 2 * limit) {
                continue;
            }
            ans += Math.min(n - i, limit) - Math.max(0, n - i - limit) + 1;
        }
        return ans;
    }
}

class Solution1 {
    public int distributeCandies(int n, int limit) {
        int res = 0;

        for (int i = 0; i <= Math.min(n, limit); i++) {
            if (n - i > 2 * limit) {
                continue;
            }
            if (n <= limit) {
                res += n - i + 1;
            } else {
                if (n - i < 2 * limit && n - i > limit) {
                    res += 2 * limit - n + i + 1;
                } else if (n - i <= limit) {
                    res += n - i + 1;
                } else {
                    res += 1;
                }
            }
        }
        return res;
    }
}
