package lc_316;

/*
 *@author: 黄豪
 *@date : 2021年12月13日
 *@todo:316. 去除重复字母
给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。

注意：该题与 1081 https://leetcode-cn.com/problems/smallest-subsequence-of-distinct-characters 相同
*/
public class LC_316 {

}
//单调栈 + 贪心
class Solution {
    public String removeDuplicateLetters(String s) {
        int n = s.length();
        int[] nums = new int[26];
        boolean[] vis = new boolean[26];
        char[] arr = s.toCharArray();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < n; i++){
            nums[arr[i] - 'a']++;
        }
        for (int i = 0; i < n; i++){
            if (!vis[arr[i] - 'a']){
                if (sb.length() > 0 && arr[i] < sb.charAt(sb.length() - 1)){
                    while (sb.length() > 0 && arr[i] < sb.charAt(sb.length() - 1)
                    && nums[sb.charAt(sb.length() - 1) - 'a'] > 0){
                        vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                        sb.deleteCharAt(sb.length() - 1);
                    }
                }
                sb.append(arr[i]);
                vis[arr[i] - 'a'] = true;
            }
            nums[arr[i] - 'a']--;
        }
        return sb.toString();
    }
}