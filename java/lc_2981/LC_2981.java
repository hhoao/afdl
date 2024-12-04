package lc_2981;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

/**
 * LC_2981
 * //给你一个仅由小写英文字母组成的字符串 s 。
 * //
 * // 如果一个字符串仅由单一字符组成，那么它被称为 特殊 字符串。例如，字符串 "abc" 不是特殊字符串，而字符串 "ddd"、"zz" 和 "f" 是特殊字
 * //符串。
 * //
 * // 返回在 s 中出现 至少三次 的 最长特殊子字符串 的长度，如果不存在出现至少三次的特殊子字符串，则返回 -1 。
 * //
 * // 子字符串 是字符串中的一个连续 非空 字符序列。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：s = "aaaa"
 * //输出：2
 * //解释：出现三次的最长特殊子字符串是 "aa" ：子字符串 "aaaa"、"aaaa" 和 "aaaa"。
 * //可以证明最大长度是 2 。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：s = "abcdef"
 * //输出：-1
 * //解释：不存在出现至少三次的特殊子字符串。因此返回 -1 。
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：s = "abcaba"
 * //输出：1
 * //解释：出现三次的最长特殊子字符串是 "a" ：子字符串 "abcaba"、"abcaba" 和 "abcaba"。
 * //可以证明最大长度是 1 。
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 3 <= s.length <= 50
 * // s 仅由小写英文字母组成。
 * //
 * //
 * // Related Topics 哈希表 字符串 二分查找 计数 滑动窗口 👍 41 👎 0
 * @author xianxing
 * @since 2024/5/29
 **/

public class LC_2981 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maximumLength("cccerrrecdcdccedecdcccddeeeddcdcddedccdceeedccecde");
        System.out.println(i);
    }
}

class Solution {
    public int maximumLength(String s) {
        int ans = -1;
        int len = s.length();

        List<Integer>[] chs = new List[26];
        for (int i = 0; i < 26; i++) {
            chs[i] = new ArrayList<Integer>();
        }
        int cnt = 0;
        for (int i = 0; i < len; i++) {
            cnt++;
            if (i + 1 == len || s.charAt(i) != s.charAt(i + 1)) {
                int ch = s.charAt(i) - 'a';
                chs[ch].add(cnt);
                cnt = 0;

                for (int j = chs[ch].size() - 1; j > 0; j--) {
                    if (chs[ch].get(j) > chs[ch].get(j - 1)) {
                        Collections.swap(chs[ch], j, j - 1);
                    } else {
                        break;
                    }
                }

                if (chs[ch].size() > 3) {
                    chs[ch].remove(chs[ch].size() - 1);
                }
            }
        }

        for (int i = 0; i < 26; i++) {
            if (chs[i].size() > 0 && chs[i].get(0) > 2) {
                ans = Math.max(ans, chs[i].get(0) - 2);
            }
            if (chs[i].size() > 1 && chs[i].get(0) > 1) {
                ans = Math.max(ans, Math.min(chs[i].get(0) - 1, chs[i].get(1)));
            }
            if (chs[i].size() > 2) {
                ans = Math.max(ans, chs[i].get(2));
            }
        }

        return ans;
    }
}

