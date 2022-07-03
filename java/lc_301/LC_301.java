package lc_301;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 *@author: 黄豪
 *@date : 2021年9月9日
 *@todo:301. 删除无效的括号
给你一个由若干括号和字母组成的字符串 s ，删除最小数量的无效括号，使得输入的字符串有效。

返回所有可能的结果。答案可以按 任意顺序 返回。
*/
public class LC_301 {

}
//dfs
class Solution {
    Set<String> ans;
    public List<String> removeInvalidParentheses(String s) {
        ans = new HashSet<>();
        int lb = 0, rb = 0;
        for (char c : s.toCharArray()){
            if (c == '('){
                lb++;
            }
            if (c == ')'){
                if (lb == 0){
                    rb++;
                }else{
                    lb--;
                }
            }
        }
        dfs(s, new StringBuilder(""), 0, 0, 0, lb, rb);
        List<String> res = new ArrayList<>();
        res.addAll(ans);
        return res;
    }
    public void dfs(String s, StringBuilder sb, int index, int leftCount, int rightCount, int lBracket, int rBracket){
        if (index == s.length()){
            if (lBracket == 0 && rBracket == 0){
                ans.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(index);
        if (c == '(' && lBracket > 0){
            dfs(s, sb, index+1, leftCount, rightCount, lBracket-1, rBracket);
        }
        if (c == ')' && rBracket > 0){
            dfs(s, sb, index+1, leftCount, rightCount, lBracket, rBracket - 1);
        }
        sb.append(c);
        if (c != '(' && c != ')'){
            dfs(s, sb, index+1, leftCount, rightCount, lBracket, rBracket);
        }else if (c == '('){
            dfs(s, sb, index+1, leftCount + 1, rightCount, lBracket, rBracket);
        }else if (rightCount < leftCount){
            dfs(s, sb, index+1, leftCount, rightCount + 1, lBracket, rBracket);
        }
        sb.deleteCharAt(sb.length() - 1);
    }
    
}