package lc_416;

import java.util.Arrays;

/*
 *@author: 黄豪
 *@date : 2021年10月29日
 *@todo:416. 分割等和子集
给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
*/
public class LC_416 {
	public static void main(String[] args) {
		System.out.println(new Solution2().canPartition(new int[] {14, 9, 8, 4, 3, 2}));
	}
}
//动态规划
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) return false;
        int target = total/2;
        boolean[][] dp = new boolean[n+1][total+1];
        boolean ans = false;
        for (int i = 1; i <= n; i++){
            for (int j = 1; j <= target; j++){
                dp[i][j] = dp[i - 1][j];
                if (nums[i - 1] <= j){
                    dp[i][j] = dp[i][j] || nums[i - 1] == j || dp[i-1][j - nums[i - 1]];
                }
            }
            ans = ans || dp[i][target];
        }
        return ans;
    }
}
class Solution2 {
    public boolean canPartition(int[] nums) {
    	int n = nums.length;
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) return false;
        int target = total/2;
        boolean[] dp = new boolean[total+1];
        for (int i = 1; i <= n; i++){
            for (int j = target; j >= nums[i - 1]; j--){
                if (nums[i - 1] <= j){
                    dp[j] = dp[j] || nums[i - 1] == j || dp[j - nums[i - 1]];
                }
            }
            if (dp[target]) return true;
        }
        return false;
    }
}
//对于n < 31可以这样
class Solution1 {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        for (int i = 0; i < (1 << n) - 1; i++){
            int k = 0;
            for (int j = 0; j < n; j++){
                if ((i & 1<<j) != 0){
                    k += nums[n - j - 1];
                }
            }
            if (sum - k == k) return true;
        }
        return false;
    }
}