package lc_2186;

/**
 * LC_2186
 *
 * @author xianxing
 * @since 2024/6/16
 **/

public class LC_2186 {
}

//题目: [2186] 制造字母异位词的最小步骤数 II
//时间: 2024-06-16 10:00:11
//
//给你两个字符串 s 和 t 。在一步操作中，你可以给 s 或者 t 追加 任一字符 。
//
// 返回使 s 和 t 互为 字母异位词 所需的最少步骤数。
//
// 字母异位词 指字母相同但是顺序不同（或者相同）的字符串。
//
//
//
// 示例 1：
//
// 输入：s = "leetcode", t = "coats"
//输出：7
//解释：
//- 执行 2 步操作，将 "as" 追加到 s = "leetcode" 中，得到 s = "leetcodeas" 。
//- 执行 5 步操作，将 "leede" 追加到 t = "coats" 中，得到 t = "coatsleede" 。
//"leetcodeas" 和 "coatsleede" 互为字母异位词。
//总共用去 2 + 5 = 7 步。
//可以证明，无法用少于 7 步操作使这两个字符串互为字母异位词。
//
// 示例 2：
//
// 输入：s = "night", t = "thing"
//输出：0
//解释：给出的字符串已经互为字母异位词。因此，不需要任何进一步操作。
//
//
//
//
// 提示：
//
//
// 1 <= s.length, t.length <= 2 * 10⁵
// s 和 t 由小写英文字符组成
//
//
// 👍 23 👎 0

class Solution {
    public int minSteps(String s, String t) {
        char[][] map = {new char[26], new char[26]};
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            map[0][s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            map[1][t.charAt(i) - 'a']++;
        }
        for (int i = 0;i < 26; i++) {
            res += Math.abs(map[0][i] - map[1][i]);
        }
        return res;
    }
}
