package lc_526;

/*
 *@author: 黄豪
 *@date : 2021年10月28日
 *@todo:526. 优美的排列
假设有从 1 到 n 的 n 个整数。用这些整数构造一个数组 perm（下标从 1 开始），只要满足下述条件 之一 ，该数组就是一个 优美的排列 ：

perm[i] 能够被 i 整除
i 能够被 perm[i] 整除
给你一个整数 n ，返回可以构造的 优美排列 的 数量 。
*/
public class LC_526 {
	

	
}
//动态规划
class Solution {
    public int countArrangement(int n) {
    	int[] dp = new int[1<<n];
    	dp[0] = 1;
    	for (int i = 1; i < (1 << n); i++) {
    		int pos = Integer.bitCount(i);
    		for (int j = 0; j < n; j++) {
    			if ((i & (1 << j)) != 0 && ((j+1) % pos == 0 || pos % (j+1) == 0)) {
    				dp[i] += dp[i ^ (i << j)];
    			}
    		}
    	}
    	return dp[(1<<n) - 1];
    }
}