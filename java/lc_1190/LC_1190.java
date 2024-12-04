package lc_1190;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/*
 *@author: 黄豪
 *@date : 2021年12月18日
 *@todo:1190. 反转每对括号间的子串
给出一个字符串 s（仅含有小写英文字母和括号）。

请你按照从括号内到外的顺序，逐层反转每对匹配括号中的字符串，并返回最终的结果。

注意，您的结果中 不应 包含任何括号。
*/
public class LC_1190 {
	public static void main(String[] args) {
		System.out.println(new Solution2().reverseParentheses("(ed(et(oc))el)"));
	}
}
//迭代
class Solution {
    public String reverseParentheses(String s) {
        Map<Integer, StringBuilder> tierMap = new HashMap<>();
        int n = s.length();
        int curTier = 0;
        StringBuilder sb = new StringBuilder("");
        for (int i = 0; i < n; i++){
            char c = s.charAt(i);
            if (c == '('){
                tierMap.put(curTier, sb);
                sb = new StringBuilder("");
                curTier++;
            }else if (c == ')'){
                if (curTier % 2 == 0){
                    tierMap.get(curTier - 1).insert(0, sb);
                }else{
                    tierMap.get(curTier - 1).append(sb);
                }
                curTier--;
                sb = tierMap.get(curTier);
            }else{
            	if (curTier % 2 == 0){
            		sb.append(c);
            	}else{
            		sb.insert(0, c);
            	}
            }
        }
        return tierMap.get(0).toString();
    }
}
//栈
class Solution1 {
    public String reverseParentheses(String s) {
        int n = s.length();
        int curTier = 0;
        StringBuffer sb = new StringBuffer("");
        Deque<String> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            char c = s.charAt(i);
            if (c == '('){
                stack.push(sb.toString());
                sb.setLength(0);
            }else if (c == ')'){
                sb.reverse();
                sb.insert(0, stack.pop());
            }else{
                sb.append(c);
            }
        }
        
        return sb.toString();
    }
}
//预处理括号
class Solution2 {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        StringBuffer sb = new StringBuffer();
        int index = 0, step = 1;
        while (index < n) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                index = pair[index];
                step = -step;
            } else {
                sb.append(s.charAt(index));
            }
            index += step;
        }
        return sb.toString();
    }
}
