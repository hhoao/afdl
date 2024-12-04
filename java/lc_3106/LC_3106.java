package lc_3106;

/**
 * LC_3106
 *
 * @author xianxing
 * @since 2024/7/27
 **/
//题目: [3106] 满足距离约束且字典序最小的字符串
//时间: 2024-07-27 22:43:53
//
//给你一个字符串 s 和一个整数 k 。
//
// 定义函数 distance(s1, s2) ，用于衡量两个长度为 n 的字符串 s1 和 s2 之间的距离，即：
//
//
// 字符 'a' 到 'z' 按 循环 顺序排列，对于区间 [0, n - 1] 中的 i ，计算所有「 s1[i] 和 s2[i] 之间 最小距离」的 和
//。
//
//
// 例如，distance("ab", "cd") == 4 ，且 distance("a", "z") == 1 。
//
// 你可以对字符串 s 执行 任意次 操作。在每次操作中，可以将 s 中的一个字母 改变 为 任意 其他小写英文字母。
//
// 返回一个字符串，表示在执行一些操作后你可以得到的 字典序最小 的字符串 t ，且满足 distance(s, t) <= k 。
//
//
//
// 示例 1：
//
//
//输入：s = "zbbz", k = 3
//输出："aaaz"
//解释：在这个例子中，可以执行以下操作：
//将 s[0] 改为 'a' ，s 变为 "abbz" 。
//将 s[1] 改为 'a' ，s 变为 "aabz" 。
//将 s[2] 改为 'a' ，s 变为 "aaaz" 。
//"zbbz" 和 "aaaz" 之间的距离等于 k = 3 。
//可以证明 "aaaz" 是在任意次操作后能够得到的字典序最小的字符串。
//因此，答案是 "aaaz" 。
//
//
// 示例 2：
//
//
//输入：s = "xaxcd", k = 4
//输出："aawcd"
//解释：在这个例子中，可以执行以下操作：
//将 s[0] 改为 'a' ，s 变为 "aaxcd" 。
//将 s[2] 改为 'w' ，s 变为 "aawcd" 。
//"xaxcd" 和 "aawcd" 之间的距离等于 k = 4 。
//可以证明 "aawcd" 是在任意次操作后能够得到的字典序最小的字符串。
//因此，答案是 "aawcd" 。
//
//
// 示例 3：
//
//
//输入：s = "lol", k = 0
//输出："lol"
//解释：在这个例子中，k = 0，更改任何字符都会使得距离大于 0 。
//因此，答案是 "lol" 。
//
//
//
// 提示：
//
//
// 1 <= s.length <= 100
// 0 <= k <= 2000
// s 只包含小写英文字母。
//
//
// 👍 28 👎 0

public class LC_3106 {
}

// 直接从前往后遍历字符串，计算与 a 相差的距离, 判断每个字
// 符变成 a 后的距离是否超过 k，如果超过，则直接获取距离 k
// 最小的字符，然后变成这个字符如果没有超过，则直接变成 a，
// 然后加上与该字符相差的距离, 直到遍历完字符串或者距离差变
// 成 k 为止
class Solution {
    public String getSmallestString(String s, int k) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0 ;i < s.length(); i++) {
            char c = s.charAt(i);
            if (k == 0) {
                ans.append(c);
            }
            int dis = Math.min(c - 'a', 'z' - c + 1);
            if (k >= dis) {
                k -= dis;
                ans.append('a');
            } else {
                ans.append((char)(c -  k));
                k = 0;
            }
        }
        return ans.toString();
    }
}
