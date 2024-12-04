package lc_120;

import java.util.List;

/**
 * @author 黄豪
 *120. 三角形最小路径和
给定一个三角形 triangle ，找出自顶向下的最小路径和。

每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。
 */
public class LC_120 {

}
//递归 超出时间限制
class Solution {
	List<List<Integer>> triangle;
    public int minimumTotal(List<List<Integer>> triangle) {
    	this.triangle = triangle;
    	return dfs(0, 0 , 0);
    }
    public int dfs(int i, int t, int total) {
    	if (t == triangle.size()) return total;
        int sum = triangle.get(t++).get(i) + total;
    	if (i + 1 > t) return dfs(i, t, sum);
    	return Math.min(dfs(i, t, sum), dfs(i + 1, t, sum));
    }
}
//由底向上 动态规划
class Solution5{
	public static int minimumTotal(List<List<Integer>> triangle) {
	    int n = triangle.size();
	    int[] dp = new int[n];
	    for (int i = 0; i < n; i++) {
	        dp[i] = triangle.get(n-1).get(i);
	    }
	    for (int i = n-2; i >= 0; i--) {
	        for (int j = 0; j <= i; j++) {
	            dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
	        }
	    }
	    return dp[0];
	}
}
//动态规划
class Solution1 {
	public int minimumTotal(List<List<Integer>> triangle) {
		int min = Integer.MAX_VALUE;
		int n = triangle.size();
		int[] array = new int[n];
		array[0] = triangle.get(0).get(0);
		for (int i = 0; i < n - 1; i++) {
			for (int j = i; j > 0; j--) {
				array[j] = Math.min(array[j], array[j - 1]) + triangle.get(i).get(j);
			}
		}
		for (int j = n - 1; j >0; j--) {
			array[j] = Math.min(array[j], array[j - 1]) + triangle.get(n - 1).get(j);
			min = Math.min(min, array[j]);
		}
		return min;
	}
}
//官方动态规划

class Solution2 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] f = new int[n][n];
        f[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
            for (int j = 1; j < i; ++j) {
                f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
            }
            f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        }
        int minTotal = f[n - 1][0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[n - 1][i]);
        }
        return minTotal;
    }
}
//动态规划+空间优化
class Solution3 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).get(0);
        }
        int minTotal = f[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }
}
