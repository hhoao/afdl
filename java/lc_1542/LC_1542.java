package lc_1542;

import java.util.Arrays;
import java.util.HashMap;

/*
 *@author: 黄豪
 *@date : 2021年12月19日
 *@todo:1542. 找出最长的超赞子字符串
给你一个字符串 s 。请返回 s 中最长的 超赞子字符串 的长度。

「超赞子字符串」需满足满足下述两个条件：

该字符串是 s 的一个非空子字符串
进行任意次数的字符交换后，该字符串可以变成一个回文字符串
*/
public class LC_1542 {

}
//暴力(超时)
class Solution {
    private boolean isPalindromic(String str, int l, int r){
        int[] cs = new int[10];
        for (int i = l; i <= r; i++){
            cs[str.charAt(i) - '0']++;
        }
        boolean vis = false;
        for (int j = 0; j < 10; j++){
            if (cs[j] % 2 == 1){
                if (!vis){
                    vis = true;
                }else{
                    return false;
                }
            }
        }
        return true;
    }
    public int longestAwesome(String s) {
        int n = s.length();
        for (int i = n - 1; i > 0; i--){
            for (int j = 0; j+i < n; j++){
                if (isPalindromic(s, j, j+i)){
                    return i+1;
                }
            }
        }
        return s == "" ? 0 : 1;
    }
}
//前缀和+状态压缩
class Solution1 {
    public int longestAwesome(String s) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int cur=0;  //状态
        int ans=1;  //记录答案
        map.put(cur,-1); 
        for(int c=0;c<s.length();c++){
            int ch=s.charAt(c)-'0';
            //计数
            cur=cur^(1<<ch);
            //一个数字出现奇数次，其余出现偶数次
            for(int i=0;i<10;i++){
                int next=cur^(1<<i);
                if(map.containsKey(next)){
                    ans=Math.max(ans,c-map.get(next));
                }
            }
            //所有都出现了偶数次
            if(!map.containsKey(cur)){
                map.put(cur,c);
            }else{
                ans=Math.max(ans,c-map.get(cur));
            }
        }
        return ans;
    }
}
//动态规划
class Solution2 {
    public int longestAwesome(String s) {
        int[] dp = new int[1 << 10];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = -1;
        int pre = 0, res = 0;
        for (int i = 0; i < s.length(); i++) {
            pre = pre ^ (1 << (s.charAt(i) - '0'));
            dp[pre] = Math.min(dp[pre], i);
            for (int j = 0; j < 10; j++) {
                int target = 1 << j;
                res = Math.max(res, i - dp[pre ^ target]);
            }
            res = Math.max(res, i - dp[pre]);
        }
        return res;
    }
}