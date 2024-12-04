package lc_1525;


import java.util.HashSet;

/**
 * LC_1525
 *
 * @author w
 * @since 2024/9/22
 **/

public class LC_1525 {
}

//题目: [1525] 字符串的好分割数目
//时间: 2024-09-22 09:19:25
//
//给你一个字符串 s ，一个分割被称为 「好分割」 当它满足：将 s 分割成 2 个字符串 p 和 q ，它们连接起来等于 s 且 p 和 q 中不同字符的数
//目相同。
//
// 请你返回 s 中好分割的数目。
//
//
//
// 示例 1：
//
// 输入：s = "aacaba"
//输出：2
//解释：总共有 5 种分割字符串 "aacaba" 的方法，其中 2 种是好分割。
//("a", "acaba") 左边字符串和右边字符串分别包含 1 个和 3 个不同的字符。
//("aa", "caba") 左边字符串和右边字符串分别包含 1 个和 3 个不同的字符。
//("aac", "aba") 左边字符串和右边字符串分别包含 2 个和 2 个不同的字符。这是一个好分割。
//("aaca", "ba") 左边字符串和右边字符串分别包含 2 个和 2 个不同的字符。这是一个好分割。
//("aacab", "a") 左边字符串和右边字符串分别包含 3 个和 1 个不同的字符。
//
//
// 示例 2：
//
// 输入：s = "abcd"
//输出：1
//解释：好分割为将字符串分割成 ("ab", "cd") 。
//
//
// 示例 3：
//
// 输入：s = "aaaaa"
//输出：4
//解释：所有分割都是好分割。
//
// 示例 4：
//
// 输入：s = "acbadbaada"
//输出：2
//
//
//
//
// 提示：
//
//
// s 只包含小写英文字母。
// 1 <= s.length <= 10^5
//
//
// 👍 56 👎 0


class Solution {
    public int numSplits(String s) {
        int[] preDiffs = new int[s.length()], postDiff = new int[s.length()];
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(s.charAt(i));
            preDiffs[i]=  set.size();
        }
        set = new HashSet<>();
        for (int i = s.length() - 1; i >= 0; i--) {
            set.add(s.charAt(i));
            postDiff[i]=  set.size();
        }
        int ans = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            if (preDiffs[i] == postDiff[i+1]) {
                ans++;
            }
        }
        return ans;
    }
}

// 动态规划
class Solution1 {
    public int numSplits(String s) {
        int n = s.length();
        int[] left = new int[n + 2];
        int[] right = new int[n + 2];
        boolean[] recLeft = new boolean[26];
        boolean[] recRight = new boolean[26];
        for (int i = 1; i <= n; i++) {
            int c = s.charAt(i - 1) - 'a';
            if (recLeft[c]) {
                left[i] = left[i - 1];
            } else {
                recLeft[c] = true;;
                left[i] = left[i - 1] + 1;
            }
        }
        for (int i = n; i > 0; i--) {
            int c = s.charAt(i - 1) - 'a';
            if (recRight[c]) {
                right[i] = right[i + 1];
            } else {
                recRight[c] = true;
                right[i] = right[i + 1] + 1;
            }
        }
        int ret = 0;
        for (int i = 1; i < n; i++) {
            if (left[i] == right[i + 1]) {
                ret++;
            }
        }
        return ret;
    }
}

