package lc_1614;

/*
 *@author: 黄豪
 *@date : 2022年1月8日
 *@todo:1614. 括号的最大嵌套深度
如果字符串满足以下条件之一，则可以称之为 有效括号字符串（valid parentheses string，可以简写为 VPS）：

字符串是一个空字符串 ""，或者是一个不为 "(" 或 ")" 的单字符。
字符串可以写为 AB（A 与 B 字符串连接），其中 A 和 B 都是 有效括号字符串 。
字符串可以写为 (A)，其中 A 是一个 有效括号字符串 。
类似地，可以定义任何有效括号字符串 S 的 嵌套深度 depth(S)：

depth("") = 0
depth(C) = 0，其中 C 是单个字符的字符串，且该字符不是 "(" 或者 ")"
depth(A + B) = max(depth(A), depth(B))，其中 A 和 B 都是 有效括号字符串
depth("(" + A + ")") = 1 + depth(A)，其中 A 是一个 有效括号字符串
例如：""、"()()"、"()(()())" 都是 有效括号字符串（嵌套深度分别为 0、1、2），而 ")(" 、"(()" 都不是 有效括号字符串 。

给你一个 有效括号字符串 s，返回该字符串的 s 嵌套深度 。
*/
public class LC_1614 {

}
//我的代码
class Solution {
    public int maxDepth(String s) {
        int curK = 0, ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++){
            if (s.charAt(i) == '('){
                curK++;
                ans = Math.max(curK, ans);
            }else if (s.charAt(i) == ')'){
                curK--;
            }
        }
        return ans;
    }
}
