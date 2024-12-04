package lc_300;

/*
 *@author: 黄豪
 *@date : 2021年6月26日
 *@todo:300. 最长递增子序列
给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。

子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

 
*/
public class LC_300 {
}

//动态规划
class Solution{
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return -1;
        int n = nums.length;
        int dp[] = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < n; i++){
            dp[i] = 1;
            for (int j = 0; j <i; j++){
                if (nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
//贪心+二分
class Solution1 {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return -1;
        if (n == 1) return 1;
        int len = 1;
        int di[] = new int[n+1];
        di[1] = nums[0];
        for (int i = 1; i < n; i++){
            if (nums[i] > di[len]){
                di[++len] = nums[i];
            }else{
                int l = 1, r = len, pos = 0;
                while (l <= r){
                    int mid = l + (r - l)/ 2;
                    if (di[mid] < nums[i]){
                        pos = mid;
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                }
                di[pos+1] = nums[i];
            }
        }
        return len;
    }
}
