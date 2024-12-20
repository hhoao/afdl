package lc_70;

/**
 * @author 黄豪
 *70. 爬楼梯
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。
 */
public class LC_70 {
	
}
class Solution{
	public int climbStairs(int x) {
		int p = 0, q = 0, r = 1;
		for (int i = 1; i <= x; i++) {
			p = q;
			q = r;
			r = p + q;
		}
		return r;
	}
}
