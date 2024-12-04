package lc_1027;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LC_1027
 * 给你一个整数数组 nums，返回 nums 中最长等差子序列的长度。
 *
 * 回想一下，nums 的子序列是一个列表 nums[i1], nums[i2], ..., nums[ik] ，且 0 <= i1 < i2 < ... < ik <= nums.length - 1。并且如果 seq[i+1] - seq[i]( 0 <= i < seq.length - 1) 的值都相同，那么序列 seq 是等差的。
 *
 * 示例 1：
 *
 * 输入：nums = [3,6,9,12]
 * 输出：4
 * 解释：
 * 整个数组是公差为 3 的等差数列。
 * 示例 2：
 *
 * 输入：nums = [9,4,7,2,10]
 * 输出：3
 * 解释：
 * 最长的等差子序列是 [4,7,10]。
 * 示例 3：
 *
 * 输入：nums = [20,1,15,3,10,5,8]
 * 输出：4
 * 解释：
 * 最长的等差子序列是 [20,15,10,5]。
 * 提示：
 *
 * 2 <= nums.length <= 1000
 * 0 <= nums[i] <= 500
 * 👍 374
 * 👎 0
 *
 * @author xianxing
 * @since 2024/9/7
 **/

public class LC_1027 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.longestArithSeqLength(new int[]{83, 20, 17, 43, 52, 78, 68, 45});
        System.out.println(i);
    }
}

class Solution {
    public int longestArithSeqLength(int[] nums) {
        Map<Integer, Integer>[] numDifferenceMaps = new Map[nums.length];
        int ans = 0;
        numDifferenceMaps[0] = new HashMap<>();
        for (int i = 1; i < nums.length; i++) {
            Map<Integer, Integer> numDifferenceMapI = new HashMap<>();
            numDifferenceMaps[i] = numDifferenceMapI;
            int num = nums[i];
            for (int j = i - 1; j >= 0; j--) {
                Map<Integer, Integer> numDifferenceMapJ = numDifferenceMaps[j];
                Integer orDefault = numDifferenceMapJ.getOrDefault(num - nums[j], 1);
                ans = Math.max(
                    numDifferenceMapI.compute(
                        num - nums[j],
                        (k, l) -> l == null ? orDefault + 1 : Math.max(l, orDefault + 1)),
                    ans);
            }
        }
        return ans;
    }
}

// 官方
class Solution1 {
    public int longestArithSeqLength(int[] nums) {
        int minv = Arrays.stream(nums).min().getAsInt();
        int maxv = Arrays.stream(nums).max().getAsInt();
        int diff = maxv - minv;
        int ans = 1;
        for (int d = -diff; d <= diff; ++d) {
            int[] f = new int[maxv + 1];
            Arrays.fill(f, -1);
            for (int num : nums) {
                int prev = num - d;
                if (prev >= minv && prev <= maxv && f[prev] != -1) {
                    f[num] = Math.max(f[num], f[prev] + 1);
                    ans = Math.max(ans, f[num]);
                }
                f[num] = Math.max(f[num], 1);
            }
        }
        return ans;
    }
}
