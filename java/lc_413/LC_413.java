package lc_413;

/*
 *@author: 黄豪
 *@date : 2021年10月29日
 *@todo:413. 等差数列划分
如果一个数列 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该数列为等差数列。

例如，[1,3,5,7,9]、[7,7,7,7] 和 [3,-1,-5,-9] 都是等差数列。
给你一个整数数组 nums ，返回数组 nums 中所有为等差数组的 子数组 个数。

子数组 是数组中的一个连续序列。
*/
public class LC_413 {

}
class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;
        int[][] dp = new int[n][n];
        
        for (int i = 2; i < n; i++){
            boolean b = true;
            for (int j = i - 2; j >= 0; j--){
                dp[j][i] = dp[j+1][i] + dp[j][i - 1] - dp[j+1][i-1];
                if (b && nums[j+2] - nums[j+1] == nums[j+1] - nums[j]){
                    dp[j][i]++;
                }else{
                    b = false;
                }
            }
        }
        return dp[0][n - 1];
    }
}
//优化
class Solution1 {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length;
        if(n <= 2) return 0;
        int dp = 0;
        int ans = 0;
        for(int i=3;i<=n;++i){
            if(nums[i-1]-nums[i-2] == nums[i-2]-nums[i-3]) dp++;
            else dp = 0;
            ans += dp;
        }
        return ans;
    }
}