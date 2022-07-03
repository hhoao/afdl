package lc_1220;

/*
 *@author: 黄豪
 *@date : 2022年1月17日
 *@todo:1220. 统计元音字母序列的数目
给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串：

字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
每个元音 'a' 后面都只能跟着 'e'
每个元音 'e' 后面只能跟着 'a' 或者是 'i'
每个元音 'i' 后面 不能 再跟着另一个 'i'
每个元音 'o' 后面只能跟着 'i' 或者是 'u'
每个元音 'u' 后面只能跟着 'a'
由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。

 

示例 1：

输入：n = 1
输出：5
解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
示例 2：

输入：n = 2
输出：10
解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。
示例 3：

输入：n = 5
输出：68
*/
public class LC_1220 {

}
//模拟
class Solution {
    static final int remainder = 1000000000 + 7;
    public int countVowelPermutation(int n) {
        long pac = 1, pec = 1, pic = 1, poc = 1, puc = 1;
        long a_c = 1, e_c = 1, i_c = 1, o_c = 1, u_c = 1;
        for (int i = 1; i < n; i++){
            a_c = pec + pic + puc;
            e_c = pac + pic;
            i_c = pec + poc;
            o_c = pic;
            u_c = pic + poc;

            pac = a_c % remainder;
            pec = e_c % remainder;
            pic = i_c % remainder;
            poc = o_c % remainder;
            puc = u_c % remainder;
        }
        return (int)((a_c + e_c +i_c+ o_c + u_c) % remainder);
    }
}