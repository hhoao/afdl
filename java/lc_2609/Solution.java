package lc_2609;

/**
 * 给你一个仅由 0 和 1 组成的二进制字符串 s 。
 *
 * 如果子字符串中 所有的 0 都在 1 之前 且其中 0 的数量等于 1 的数量，则认为 s 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字符串。
 *
 * 返回 s 中最长的平衡子字符串长度。
 *
 * 子字符串是字符串中的一个连续字符序列。
 *
 * 示例 1：
 *
 * 输入：s = "01000111"
 * 输出：6
 * 解释：最长的平衡子字符串是 "000111" ，长度为 6 。
 * 示例 2：
 *
 * 输入：s = "00111"
 * 输出：4
 * 解释：最长的平衡子字符串是 "0011" ，长度为  4 。
 * 示例 3：
 *
 * 输入：s = "111"
 * 输出：0
 * 解释：除了空子字符串之外不存在其他平衡子字符串，所以答案为 0 。
 */
class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int ans = 0, cur_len = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                int one_len = 0;
                while (i < s.length() && s.charAt(i) == '1') {
                    one_len++;
                    i++;
                }
                if (one_len >= cur_len) {
                    ans = Math.max(ans, cur_len * 2);
                } else {
                    ans = Math.max(ans, one_len * 2);
                }
                cur_len = 0;
            }
            cur_len++;
        }
        return ans;
    }
}


class Solution1 {
    public int findTheLongestBalancedSubstring(String s) {
        int res = 0;
        int n = s.length();
        int[] count = new int[2];
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                count[1]++;
                res = Math.max(res, 2 * Math.min(count[0], count[1]));
            } else if (i == 0 || s.charAt(i - 1) == '1') {
                count[0] = 1;
                count[1] = 0;
            } else {
                count[0]++;
            }
        }
        return res;
    }
}
