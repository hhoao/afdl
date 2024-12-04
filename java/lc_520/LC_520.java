package lc_520;

/**
 * LC_520
 *
 * @author xianxing
 * @since 2024/6/23
 **/

//题目: [520] 检测大写字母
//时间: 2024-06-23 19:45:39
//
//我们定义，在以下情况时，单词的大写用法是正确的：
//
//
// 全部字母都是大写，比如 "USA" 。
// 单词中所有字母都不是大写，比如 "leetcode" 。
// 如果单词不只含有一个字母，只有首字母大写， 比如 "Google" 。
//
//
// 给你一个字符串 word 。如果大写用法正确，返回 true ；否则，返回 false 。
//
//
//
// 示例 1：
//
//
//输入：word = "USA"
//输出：true
//
//
// 示例 2：
//
//
//输入：word = "FlaG"
//输出：false
//
//
//
//
// 提示：
//
//
// 1 <= word.length <= 100
// word 由小写和大写英文字母组成
//
//
// 👍 282 👎 0
public class LC_520 {
}

class Solution {
    public boolean detectCapitalUse(String word) {
        if (word.length() > 1 && Character.isLowerCase(word.charAt(0)) &&
            Character.isUpperCase(word.charAt(1))) {
            return false;
        }
        for (int i = 2; i < word.length(); i++) {
            if (Character.isUpperCase(word.charAt(i)) != Character.isUpperCase(word.charAt(i - 1))) {
                return false;
            }
        }
        return true;
    }
}
