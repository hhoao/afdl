package lc_718;

/*
 *@author: 黄豪
 *@date : 2021年9月19日
 *@todo:718. 最长重复子数组
给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
*/
public class LC_718 {

}
//我的动态规划
class Solution {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n + 1][m + 1];
        int ans = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= m; j++){
                if (nums1[i - 1] == nums2[j - 1])
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                ans = Math.max(dp[i][j], ans);
            }
        }
        return ans;
    }
}