package lc_241;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 黄豪
 *241. 为运算表达式设计优先级
给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
 */
public class LC_241 {

}
//我的代码
class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        int count = 0;
        for (int i = 0; i < expression.length(); i++){
            if (Character.isDigit(expression.charAt(i))){
                count++;
            }
        }
        if (count == expression.length()){
            return Arrays.asList(Integer.valueOf(expression)); 
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < expression.length(); i++){
            char c = expression.charAt(i);
            if (c == '*' || c == '-' || c == '+'){
                List<Integer> l = diffWaysToCompute(expression.substring(0, i));
                List<Integer> r = diffWaysToCompute(expression.substring(i+1, expression.length()));
                for (Integer n : l){
                    for (Integer m : r){
                        if (c == '*'){
                            list.add(n * m);
                        }else if (c == '-'){
                            list.add(n - m);
                        }else{
                            list.add(n +m);
                        }
                    }
                }
            }
        }
        return list;
    }
}