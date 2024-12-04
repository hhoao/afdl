package lc_264;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author 黄豪
 *264. 丑数 II
给你一个整数 n ，请你找出并返回第 n 个 丑数 。

丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 */
public class LC_264 {

}
//我的代码 动态规划
class Solution {
    public int nthUglyNumber(int n) {
        int i = 1, j = 1, k = 1, sum = 1, min = 1;
        int dp[] = new int[n+1];
        dp[1] = 1;
        while (sum < n){
            int u = dp[i] * 2;
            int o = dp[j] * 3;
            int m = dp[k] * 5;
            
            min = Math.min(u, Math.min(o, m));
            if (min == u) i++;
            if (min == o) j++;
            if (min == m) k++;
            dp[++sum] = min;
        }
        return min;
    }
}
//官方 最小堆
class Solution1 {
    public int nthUglyNumber(int n) {
        int[] factors = {2, 3, 5};
        Set<Long> seen = new HashSet<Long>();
        PriorityQueue<Long> heap = new PriorityQueue<Long>();
        seen.add(1L);
        heap.offer(1L);
        int ugly = 0;
        for (int i = 0; i < n; i++) {
            long curr = heap.poll();
            ugly = (int) curr;
            for (int factor : factors) {
                long next = curr * factor;
                if (seen.add(next)) {
                    heap.offer(next);
                }
            }
        }
        return ugly;
    }
}
