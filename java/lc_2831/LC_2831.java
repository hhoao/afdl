package lc_2831;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC_2831
 * //给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * //
 * // 如果子数组中所有元素都相等，则认为子数组是一个 等值子数组 。注意，空数组是 等值子数组 。
 * //
 * // 从 nums 中删除最多 k 个元素后，返回可能的最长等值子数组的长度。
 * //
 * // 子数组 是数组中一个连续且可能为空的元素序列。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [1,3,2,3,1,3], k = 3
 * //输出：3
 * //解释：最优的方案是删除下标 2 和下标 4 的元素。
 * //删除后，nums 等于 [1, 3, 3, 3] 。
 * //最长等值子数组从 i = 1 开始到 j = 3 结束，长度等于 3 。
 * //可以证明无法创建更长的等值子数组。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [1,1,2,2,1,1], k = 2
 * //输出：4
 * //解释：最优的方案是删除下标 2 和下标 3 的元素。
 * //删除后，nums 等于 [1, 1, 1, 1] 。
 * //数组自身就是等值子数组，长度等于 4 。
 * //可以证明无法创建更长的等值子数组。
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= nums.length <= 10⁵
 * // 1 <= nums[i] <= nums.length
 * // 0 <= k <= nums.length
 * //
 * //
 * // Related Topics 数组 哈希表 二分查找 滑动窗口 👍 92 👎 0
 *
 * @author xianxing
 * @since 2024/5/23
 **/

public class LC_2831 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.longestEqualSubarray(Arrays.asList(1, 2, 1), 0);
//        int i = solution.longestEqualSubarray(Arrays.asList(1,3,2,3,1,3), 3);
        System.out.println(i);
    }
}

class Solution {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        int n = nums.size();
        int ans = 0;
        Map<Integer, Integer> cnt = new HashMap<>();
        for (int i = 0, j = 0; j < n; j++) {
            cnt.put(nums.get(j), cnt.getOrDefault(nums.get(j), 0) + 1);
            /*当前区间中，无法以 nums[i] 为等值元素构成合法等值数组*/
            while (j - i + 1 - cnt.get(nums.get(i)) > k) {
                cnt.put(nums.get(i), cnt.get(nums.get(i)) - 1);
                i++;
            }
            ans = Math.max(ans, cnt.get(nums.get(j)));
        }
        return ans;
    }
}



class Solution1 {
    public int longestEqualSubarray(List<Integer> nums, int k) {
        HashMap<Integer, Deque<Integer>> numWithIndexes = new HashMap<>();
        HashMap<Integer, Integer> numCount = new HashMap<>();
        int res = 0;
        for (int i = 0; i < nums.size(); i++) {
            Integer num  = nums.get(i);
            Deque<Integer> indexes = numWithIndexes.computeIfAbsent(num, (p) -> new ArrayDeque<>());
            indexes.offer(i);
            Integer count = numCount.getOrDefault(num, 0) + 1;
            if (i - indexes.peek() + 1 - count > k) {
                indexes.poll();
            } else {
                res = Math.max(count, res);
                numCount.put(num, count);
            }
        }
        return res;
    }
}
