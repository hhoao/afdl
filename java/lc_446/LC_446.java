package lc_446;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: 黄豪
 *@date : 2021年12月2日
 *@todo:446. 等差数列划分 II - 子序列
给你一个整数数组 nums ，返回 nums 中所有 等差子序列 的数目。

如果一个序列中 至少有三个元素 ，并且任意两个相邻元素之差相同，则称该序列为等差序列。

例如，[1, 3, 5, 7, 9]、[7, 7, 7, 7] 和 [3, -1, -5, -9] 都是等差序列。
再例如，[1, 1, 2, 5, 7] 不是等差序列。
数组中的子序列是从数组中删除一些元素（也可能不删除）得到的一个序列。

例如，[2,5,10] 是 [1,2,1,2,4,1,5,10] 的一个子序列。
题目数据保证答案是一个 32-bit 整数。
*/
public class LC_446 {

}
//动态规划+哈希表
class Solution{
	public int numberOfArithmeticSlices(int[] nums) {
		int n = nums.length;
		int ans = 0;
		Map<Long, Integer>[] f = new Map[n];
		for (int i = 0; i < n; i++) {
			f[i] = new HashMap<>();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				Long d = 1L * nums[i] - nums[j];
				int cnt = f[j].getOrDefault(d, 0);
				ans += cnt;
				f[i].put(d, f[i].getOrDefault(d, 0) + cnt + 1);
			}
		}
		return ans;
	}
}
