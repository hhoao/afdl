package lc_318;

/*
 *@author: 黄豪
 *@date : 2021年12月14日
 *@todo:318. 最大单词长度乘积
给你一个字符串数组 words ，找出并返回 length(words[i]) * length(words[j]) 的最大值，并且这两个单词不含有公共字母。如果不存在这样的两个单词，返回 0 。
*/
public class LC_318 {

}
//位运算
class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] bitMap = new int[n];
        for (int i = 0; i < n; i++){
            int b = 0;
            char[] s = words[i].toCharArray();
            for (char ch : s){
                b |= 1 << (ch - 'a'); 
            }
            bitMap[i] = b;
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = i+1; j < n; j++){
                if ((bitMap[i] & bitMap[j]) == 0){
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }
        }
        return ans;
    }
}
