package lc_862;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 *@author: 黄豪
 *@date : 2021年12月31日
 *@todo:862. 和至少为 K 的最短子数组
给你一个整数数组 nums 和一个整数 k ，找出 nums 中和至少为 k 的 最短非空子数组 ，并返回该子数组的长度。如果不存在这样的 子数组 ，返回 -1 。

子数组 是数组中 连续 的一部分。
*/
public class LC_862 {

}
//前缀和+单调队列
class Solution {
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] f = new long[n + 1];
        Deque<Integer> monotoQueue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++){
            f[i] = (long)nums[i - 1] + f[i - 1];
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i <= n; i++){
            while (!monotoQueue.isEmpty() && f[i] <= f[monotoQueue.getLast()]){
                monotoQueue.removeLast();
            }
            while (!monotoQueue.isEmpty() && f[i] - k >= f[monotoQueue.getFirst()]){
                ans = Math.min(i - monotoQueue.removeFirst(), ans);
            }
            monotoQueue.offer(i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
