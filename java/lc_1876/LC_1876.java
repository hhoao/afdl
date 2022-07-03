package lc_1876;

import java.util.Arrays;

/*
 *@author: 黄豪
 *@date : 2021年10月2日
 *@todo:
 *1876. 长度为三且各字符不同的子字符串
如果一个字符串不含有任何重复字符，我们称这个字符串为 好 字符串。

给你一个字符串 s ，请你返回 s 中长度为 3 的 好子字符串 的数量。

注意，如果相同的好子字符串出现多次，每一次都应该被记入答案之中。

子字符串 是一个字符串中连续的字符序列。
*/
public class LC_1876 {

}
//我的代码
class Solution {
    public int countGoodSubstrings(String s) {
        int k = 3;
        int[] charSets = new int[27];
        Arrays.fill(charSets, -10);
        int l = 0, n = s.length();
        int ans = 0;
        charSets[s.charAt(0) - 97] = 0;
        for (int i = 1; i < n; i++){
            int dis = i - charSets[s.charAt(i) - 97];
            if (dis < k) l = charSets[s.charAt(i) - 97] + 1;
            if (i - l == k) l++;
            if (i - l + 1 == k) ans++;
            charSets[s.charAt(i) - 97] = i;
        }
        return ans;
    }
}