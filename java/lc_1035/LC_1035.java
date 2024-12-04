package lc_1035;


/**
 * LC_1035
 *
 * @author w
 * @since 2024/9/8
 **/

public class LC_1035 {
}

//题目: [1035] 不相交的线
//时间: 2024-09-08 10:28:34
//
//在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
//
// 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足：
//
//
// nums1[i] == nums2[j]
// 且绘制的直线不与任何其他连线（非水平线）相交。
//
//
// 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
//
// 以这种方法绘制线条，并返回可以绘制的最大连线数。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,4,2], nums2 = [1,2,4]
//输出：2
//解释：可以画出两条不交叉的线，如上图所示。
//但无法画出第三条不相交的直线，因为从 nums1[1]=4 到 nums2[2]=4 的直线将与从 nums1[2]=2 到 nums2[1]=2 的直线相
//交。
//
//
//
// 示例 2：
//
//
//
//输入：nums1 = [2,5,1,2,5], nums2 = [10,5,2,1,5,2]
//输出：3
//
//
//
// 示例 3：
//
//
//
//输入：nums1 = [1,3,7,1,7,5], nums2 = [1,9,2,5,1]
//输出：2
//
//
//
// 提示：
//
//
// 1 <= nums1.length, nums2.length <= 500
// 1 <= nums1[i], nums2[j] <= 2000
//
//
//
//
// 👍 592 👎 0


// 使用 dp[i][j] 来表示  以 nums1 中下标 i，num2 中下标 j 为边界的的最大连接数
// 如果 nums[i] == nums[j]，那么 dp[i][j] = Math.max(dp[i - 1], dp[i - 1][j - 1] + 1)
// 如果 nums[i] != nums[j], 那么 dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i][j - 1])
//  因为只和前面的 dp 有关，所以可以优化为一维数组
class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int[] dp = new int[nums2.length + 1];
        for (int num1 : nums1) {
            int[] tmp = new int[nums2.length + 1];
            for (int j = 1; j <= nums2.length; j++) {
                tmp[j] = Math.max(dp[j], num1 == nums2[j - 1] ?
                    dp[j - 1] + 1 :
                    tmp[j - 1]);
            }
            dp = tmp;
        }
        return dp[nums2.length];
    }
}
