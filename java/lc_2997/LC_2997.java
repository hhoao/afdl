package lc_2997;

/**
 * LC_2997
 *
 * @author xianxing
 * @since 2024/6/16
 **/

//
//
// 示例 1：
//
//
//输入：nums = [2,1,3,4], k = 1
//输出：2
//解释：我们可以执行以下操作：
//- 选择下标为 2 的元素，也就是 3 == (011)2 ，我们翻转第一个数位得到 (010)2 == 2 。数组变为 [2,1,2,4] 。
//- 选择下标为 0 的元素，也就是 2 == (010)2 ，我们翻转第三个数位得到 (110)2 == 6 。数组变为 [6,1,2,4] 。
//最终数组的所有元素异或和为 (6 XOR 1 XOR 2 XOR 4) == 1 == k 。
//无法用少于 2 次操作得到异或和等于 k 。
//
//
// 示例 2：
//
//
//输入：nums = [2,0,2,0], k = 0
//输出：0
//解释：数组所有元素的异或和为 (2 XOR 0 XOR 2 XOR 0) == 0 == k 。所以不需要进行任何操作。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁵
// 0 <= nums[i] <= 10⁶
// 0 <= k <= 10⁶
//
//
// 👍 5 👎 0
public class LC_2997 {
}

class Solution {
    public int minOperations(int[] nums, int k) {
        int total = 0, res = 0;
        for (int num : nums) {
            total ^= num;
        }
        int max = 1;
        while (max <= Math.max(total, k)) {
            if ((total & max) !=  (k & max)) {
                res++;
            }
            max *= 2;
        }
        return res;
    }
}
