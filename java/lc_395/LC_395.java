package lc_395;

import java.util.Arrays;

/*
 *@author: 黄豪
 *@date : 2022年1月1日
 *@todo:395. 至少有 K 个重复字符的最长子串
给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
*/
public class LC_395 {

}
//滑动窗口(根据字符类型数滑动)
class Solution {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        char[] str = s.toCharArray();
        int[] cnt = new int[26];
        int ans = 0;
        for (int p = 1; p <= 26; p++){
            Arrays.fill(cnt, 0);
            for (int l = 0, r = 0, total = 0, com = 0; r < n; r++){
                char c = str[r];
                cnt[c - 'a']++;
                if (cnt[c - 'a'] == 1) total++;
                if (cnt[c - 'a'] == k) com++;
                while (total > p){
                    int c2 = str[l++] - 'a';
                    cnt[c2]--;
                    if (cnt[c2] == 0) total--;
                    if (cnt[c2] == k - 1) com--;
                }
                if (total == com) ans = Math.max(ans, r - l+1);
            }
        }
        return ans;
    }
}
//分治
class Solution1 {
    public int longestSubstring(String s, int k) {
        int n = s.length();
        return dfs(s, 0, n - 1, k);
    }

    public int dfs(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {
            return r - l + 1;
        }

        int i = l;
        int ret = 0;
        while (i <= r) {
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            if (i > r) {
                break;
            }
            int start = i;
            while (i <= r && s.charAt(i) != split) {
                i++;
            }

            int length = dfs(s, start, i - 1, k);
            ret = Math.max(ret, length);
        }
        return ret;
    }
}