package lc_313;

import java.util.Arrays;

/*
 *@author: 黄豪
 *@date : 2021年9月28日
 *@todo:313. 超级丑数
超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。

给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。

题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。

 
*/
public class LC_313 {

}
class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        int m = primes.length;
        int[] points = new int[m];
        Arrays.fill(points, 1);
        for (int i = 2; i <= n; i++){
            int[] nums = new int[m];
            int minValue = 2147483647;
            for (int j = 0; j < m; j++){
                nums[j] = dp[points[j]] * primes[j];
                minValue = Math.min(minValue, nums[j]);
                dp[i] = minValue;
            }
            for (int j = 0; j < m; j++){
                if (nums[j] == minValue){
                    points[j]++;
                }
            }
        }
        return dp[n];
    }
}