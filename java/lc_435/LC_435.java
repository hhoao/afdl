package lc_435;

import java.util.Arrays;

/*
 *@author: 黄豪
 *@date : 2021年10月27日
 *@todo:435. 无重叠区间
给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

注意:

可以认为区间的终点总是大于它的起点。
区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
*/
public class LC_435 {
	public static void main(String[] args) {
		System.out.println(new Solution().eraseOverlapIntervals(new int[][] {{1,2}, {2,3}, {3,4}, {1,3}})); 
	}
}
//动态规划
class Solution{
	public int eraseOverlapIntervals(int[][] intervals) {
		int n = intervals.length;
		int[] f = new int[n];
		Arrays.sort(intervals, (a, b)->a[0] - b[0]);
		Arrays.fill(f, 1);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j < i; j++) {
				if (intervals[j][1] <= intervals[i][0]) {
					f[i] = Math.max(f[i], f[j] + 1);
				}
			}
		}
		return n - f[n - 1];
	}
}
//贪心算法
class Solution1{
	public int eraseOverlapIntervals(int[][] intervals) {
		int n = intervals.length;
		Arrays.sort(intervals, (a, b)->a[1] - b[1]);
		int ans = 1;
		int right = intervals[0][1];
		for (int i = 1; i < n; i++) {
			if (intervals[i][0] > right) {
				ans++;
				right = intervals[i][1];
			}
		}
		return n - ans;
	}
}
