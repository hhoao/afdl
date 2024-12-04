package lc_2817;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

/**
 * LC_2817
 * //给你一个下标从 0 开始的整数数组 nums 和一个整数 x 。
 * //
 * // 请你找到数组中下标距离至少为 x 的两个元素的 差值绝对值 的 最小值 。
 * //
 * // 换言之，请你找到两个下标 i 和 j ，满足 abs(i - j) >= x 且 abs(nums[i] - nums[j]) 的值最小。
 * //
 * // 请你返回一个整数，表示下标距离至少为 x 的两个元素之间的差值绝对值的 最小值 。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [4,3,2,4], x = 2
 * //输出：0
 * //解释：我们选择 nums[0] = 4 和 nums[3] = 4 。
 * //它们下标距离满足至少为 2 ，差值绝对值为最小值 0 。
 * //0 是最优解。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [5,3,2,10,15], x = 1
 * //输出：1
 * //解释：我们选择 nums[1] = 3 和 nums[2] = 2 。
 * //它们下标距离满足至少为 1 ，差值绝对值为最小值 1 。
 * //1 是最优解。
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：nums = [1,2,3,4], x = 3
 * //输出：3
 * //解释：我们选择 nums[0] = 1 和 nums[3] = 4 。
 * //它们下标距离满足至少为 3 ，差值绝对值为最小值 3 。
 * //3 是最优解。
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= nums.length <= 10⁵
 * // 1 <= nums[i] <= 10⁹
 * // 0 <= x < nums.length
 * //
 * //
 * // Related Topics 数组 二分查找 有序集合 👍 26 👎 0
 * @author xianxing
 * @since 2024/5/18
 **/

public class LC_2817 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minAbsoluteDifference(List.of(4, 3, 2, 4), 2));
    }
}

class Solution {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        TreeSet<Integer> set = new TreeSet<>();
        int res = 0;
        for (int i = x; i < nums.size(); i++) {
            Integer num  = nums.get(i);
            set.add(nums.get(i - x));
            Integer floor = set.floor(num);
            Integer ceiling = set.ceiling(num);
            if (floor != null) {
                res = Math.min(Math.abs(floor - num), res);
            }
            if (ceiling != null) {
                res = Math.min(Math.abs(ceiling - num), res);
            }
        }
        return res;
    }
}

class Solution1 {
    public int minAbsoluteDifference(List<Integer> nums, int x) {
        if (x == 0) {
            return 0;
        }
        int[][] numWithIndexes = new int[nums.size()][2];
        for (int i = 0; i < numWithIndexes.length; i++) {
            numWithIndexes[i] = new int[] {nums.get(i), i};
        }
        Arrays.sort(numWithIndexes, Comparator.comparingInt(o -> o[0]));

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numWithIndexes.length; i++) {
            for (int j = i + 1; j < numWithIndexes.length; j++) {
                int abs = Math.abs(numWithIndexes[i][0] - numWithIndexes[j][0]);
                if (abs > min) {
                    break;
                }
                if (Math.abs(numWithIndexes[i][1] - numWithIndexes[j][1]) >= x) {
                    min = abs;
                    break;
                }
            }
        }
        return min;
    }
}
