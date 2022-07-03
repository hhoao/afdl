package lc_1576;

/*
 *@author: 黄豪
 *@date : 2022年1月5日
 *@todo:1576. 替换所有的问号
给你一个仅包含小写英文字母和 '?' 字符的字符串 s，请你将所有的 '?' 转换为若干小写字母，使最终的字符串不包含任何 连续重复 的字符。

注意：你 不能 修改非 '?' 字符。

题目测试用例保证 除 '?' 字符 之外，不存在连续重复的字符。

在完成所有转换（可能无需转换）后返回最终的字符串。如果有多个解决方案，请返回其中任何一个。可以证明，在给定的约束条件下，答案总是存在的。
*/
public class LC_1576 {

}
//我的代码
class Solution {
    public String modifyString(String s) {
        int n = s.length();
        StringBuffer sb = new StringBuffer();
        char preChar = '?';
        for (int  i = 0; i < n; i++){
            if (s.charAt(i) == '?'){
                char postChar = i < n - 1 ? s.charAt(i + 1) : '?';
                for (int j = 0; j < 26; j++){
                    char c = (char)(j + 'a');
                    if (c != preChar && c != postChar){
                        sb.append(c);
                        break;
                    }
                }
            }else{
                sb.append(s.charAt(i));
            }
            preChar = sb.charAt(i);
        }
        return sb.toString();
    }  
}
//官方
class Solution1 {
    public String modifyString(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            if (arr[i] == '?') {
                for (char ch = 'a'; ch <= 'c'; ++ch) {
                    if ((i > 0 && arr[i - 1] == ch) || (i < n - 1 && arr[i + 1] == ch)) {
                        continue;
                    }
                    arr[i] = ch;
                    break;
                }
            }
        }
        return new String(arr);
    }
}