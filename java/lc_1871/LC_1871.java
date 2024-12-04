package lc_1871;


/**
 * LC_1871
 *
 * @author w
 * @since 2024/9/15
 **/

public class LC_1871 {
}
//题目: [1871] 跳跃游戏 VII
//时间: 2024-09-15 17:15:34
//
//给你一个下标从 0 开始的二进制字符串 s 和两个整数 minJump 和 maxJump 。一开始，你在下标 0 处，且该位置的值一定为 '0' 。当同时
//满足如下条件时，你可以从下标 i 移动到下标 j 处：
//
//
// i + minJump <= j <= min(i + maxJump, s.length - 1) 且
// s[j] == '0'.
//
//
// 如果你可以到达 s 的下标 s.length - 1 处，请你返回 true ，否则返回 false 。
//
//
//
// 示例 1：
//
//
//输入：s = "011010", minJump = 2, maxJump = 3
//输出：true
//解释：
//第一步，从下标 0 移动到下标 3 。
//第二步，从下标 3 移动到下标 5 。
//
//
// 示例 2：
//
//
//输入：s = "01101110", minJump = 2, maxJump = 3
//输出：false
//
//
//
//
// 提示：
//
//
// 2 <= s.length <= 10⁵
// s[i] 要么是 '0' ，要么是 '1'
// s[0] == '0'
// 1 <= minJump <= maxJump < s.length
//
//
// 👍 98 👎 0

// 动态规划
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        for (int i = minJump; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                for (int j = minJump; j <= maxJump && i - j >= 0; j++) {
                    if (dp[i - j]) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}

// 滑动窗口 + 动态规划
// 优化， 我们只需要知道 minJum - maxJum 这个下标范围内是否有可以跳过来的下标, 那么除了遍历之外如何知道呢
// 维护一个滑动窗口, 这个窗口维护一个 num， num 的值为里面为可以跳过来下标的数量, 那么如何滑动呢？
// 因为滑动窗口的长度是固定的，滑动时判断是否失去了一个可以跳的下标， 所以需要维护之前是否可以跳跃的下标，这就需要动态规划了。
class Solution1 {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] dp = new boolean[n];
        dp[0] = true;
        int pre = 1;
        for (int i = minJump; i < s.length(); i++) {
            if (s.charAt(i) == '0' && pre > 0) {
                dp[i] = true;
            }
            pre += dp[i - minJump + 1] ? 1 : 0;
            if (i >= maxJump && dp[i - maxJump]) {
                pre--;
            }
        }
        return dp[s.length() - 1];
    }
}
