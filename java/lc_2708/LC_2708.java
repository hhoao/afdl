package lc_2708;


/**
 * LC_2708
 * 给你一个下标从 0 开始的整数数组 nums ，它表示一个班级中所有学生在一次考试中的成绩。老师想选出一部分同学组成一个 非空 小组，且这个小组的 实力值 最大，如果这个小组里的学生下标为 i0, i1, i2, ... , ik ，那么这个小组的实力值定义为 nums[i0] * nums[i1] * nums[i2] * ... * nums[ik​] 。
 *
 * 请你返回老师创建的小组能得到的最大实力值为多少。
 *
 * 示例 1：
 *
 * 输入：nums = [3,-1,-5,2,5,-9]
 * 输出：1350
 * 解释：一种构成最大实力值小组的方案是选择下标为 [0,2,3,4,5] 的学生。实力值为 3 * (-5) * 2 * 5 * (-9) = 1350 ，这是可以得到的最大实力值。
 * 示例 2：
 *
 * 输入：nums = [-4,-5,-4]
 * 输出：20
 * 解释：选择下标为 [0, 1] 的学生。得到的实力值为 20 。我们没法得到更大的实力值。
 * 提示：
 *
 * 1 <= nums.length <= 13
 * -9 <= nums[i] <= 9
 * 👍 54
 * 👎 0
 * @author xianxing
 * @since 2024/9/3
 **/

public class LC_2708 {
}

// 假设全部为负数
// 如果数组的长度为偶数，那么可以全部选
// 如果数组的长度为奇数，那么需要抛弃一个数，抛弃绝对值最小的
//
// 假设全部为正数
// 那就全部选
//
// 假设既有负数也有正数
// 如果负数为偶数个，那就全部选
// 如果负数为奇数个，那就抛弃一个奇数, 抛弃奇数中绝对值最小的
//
// 合在一起为
// 如果负数为奇数个，那就抛弃一个奇数, 抛弃奇数中绝对值最的

class Solution {
    public long maxStrength(int[] nums) {
        int index = -1, max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                count++;
                if (nums[i] > max) {
                    max = nums[i];
                    index = i;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0 && (count % 2 == 0 || i != index)) {
                ans = ans == 0 ? nums[i] : nums[i] * ans;
            }
        }
        return ans;
    }
}


// 简洁写法
class Solution1 {
    public long maxStrength(int[] nums) {
        int negativeCount = 0, zeroCount = 0, positiveCount = 0;
        long prod = 1;
        int maxNegative = -9;
        for (int num : nums) {
            if (num < 0) {
                negativeCount++;
                prod *= num;
                maxNegative = Math.max(maxNegative, num);
            } else if (num == 0) {
                zeroCount++;
            } else {
                prod *= num;
                positiveCount++;
            }
        }
        if (negativeCount == 1 && zeroCount == 0 && positiveCount == 0) {
            return nums[0];
        }
        if (negativeCount <= 1 && positiveCount == 0) {
            return 0;
        }
        if (prod < 0) {
            return prod / maxNegative;
        } else {
            return prod;
        }
    }
}
