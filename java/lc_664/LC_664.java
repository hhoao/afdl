package lc_664;

import java.util.Arrays;

/**
 * LC_664
 *
 * @author xianxing
 * @since 2024/6/9
 **/
//有台奇怪的打印机有以下两个特殊要求：
//
//
// 打印机每次只能打印由 同一个字符 组成的序列。
// 每次可以在从起始到结束的任意位置打印新字符，并且会覆盖掉原来已有的字符。
//
//
// 给你一个字符串 s ，你的任务是计算这个打印机打印它需要的最少打印次数。
//
// 示例 1：
//
//
//输入：s = "aaabbb"
//输出：2
//解释：首先打印 "aaa" 然后打印 "bbb"。
//
//
// 示例 2：
//
//
//输入：s = "aba"
//输出：2
//解释：首先打印 "aaa" 然后在第二个位置打印 "b" 覆盖掉原来的字符 'a'。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 100
// s 由小写英文字母组成
//
//
public class LC_664 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int aaabbb = solution.strangePrinter("aaabbb");
        System.out.println(aaabbb);
    }
}

// 如果两段字符串a, b, 如果a字符串字符串开头字符等于b字符串开头字符
//       [i, j] = [i, j-1]
// 如果两段字符串a, b, 如果a字符串字符串开头字符不等于b字符串开头字符
//    [i, j] = [i, i+k], [i+k+1, j], i+k+1 <= j
// [i, i] = 1

class Solution {
    public int strangePrinter(String s) {
        char[] charArray = s.toCharArray();
        int[][] f = new int[charArray.length][charArray.length];
        for (int i = charArray.length - 1; i >= 0; i--) {
            f[i][i] = 1;
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] == charArray[j]) {
                    f[i][j] = f[i][j - 1];
                } else {
                    int v = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        v = Math.min(v, f[i][k] + f[k+1][j]);
                    }
                    f[i][j] = v;
                }
            }
        }
        return f[0][s.length() - 1];
    }
}
