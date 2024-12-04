package lc_1673;

import java.util.Arrays;

/**
 * LC_1673
 * //给你一个整数数组 nums 和一个正整数 k ，返回长度为 k 且最具 竞争力 的 nums 子序列。
 * //
 * // 数组的子序列是从数组中删除一些元素（可能不删除元素）得到的序列。
 * //
 * // 在子序列 a 和子序列 b 第一个不相同的位置上，如果 a 中的数字小于 b 中对应的数字，那么我们称子序列 a 比子序列 b（相同长度下）更具 竞争力
 * //。 例如，[1,3,4] 比 [1,3,5] 更具竞争力，在第一个不相同的位置，也就是最后一个位置上， 4 小于 5 。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [3,5,2,6], k = 2
 * //输出：[2,6]
 * //解释：在所有可能的子序列集合 {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]} 中，[2,6] 最具竞争力。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [2,4,3,3,5,4,9,6], k = 4
 * //输出：[2,3,3,4]
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 1 <= nums.length <= 10⁵
 * // 0 <= nums[i] <= 10⁹
 * // 1 <= k <= nums.length
 * //
 * //
 * // Related Topics 栈 贪心 数组 单调栈 👍 167 👎 0
 *
 * @author xianxing
 * @since 2024/5/24
 **/

public class LC_1673 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.mostCompetitive(new int[]{71, 18, 52, 29, 55, 73, 24, 42, 66, 8, 80, 2}, 3);
        System.out.println(Arrays.toString(ints));
    }
}

class Solution {
    public int[] mostCompetitive(int[] nums, int k) {
        int[] rs = new int[k];
        Arrays.fill(rs, -1);
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            while (pos > 0 &&
                pos <= k &&
                nums[i] < rs[pos - 1] &&
                i + k - pos < nums.length) {
                pos--;
                rs[pos] = -1;
            }
            if (pos < k) {
                rs[pos] = nums[i];
                pos++;
            }
        }
        return rs;
    }
}
