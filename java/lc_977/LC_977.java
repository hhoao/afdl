package lc_977;

/**
 * LC_977
 *
 * @author xianxing
 * @since 2024/6/11
 **/

public class LC_977 {
}

//给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
//
//
//
//
//
//
// 示例 1：
//
//
//输入：nums = [-4,-1,0,3,10]
//输出：[0,1,9,16,100]
//解释：平方后，数组变为 [16,1,0,9,100]
//排序后，数组变为 [0,1,9,16,100]
//
// 示例 2：
//
//
//输入：nums = [-7,-3,2,3,11]
//输出：[4,9,9,49,121]
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 10⁴
// -10⁴ <= nums[i] <= 10⁴
// nums 已按 非递减顺序 排序
//
//
//
//
// 进阶：
//
//
// 请你设计时间复杂度为 O(n) 的算法解决本问题
//
//
// Related Topics 数组 双指针 排序 👍 992 👎
class Solution {
    public int[] sortedSquares(int[] nums) {
        int index = findFirstPositiveIndex(nums);
        int[] res = new int[nums.length];
        int j = index - 1, i = 0;
        for (int k = index; k < nums.length; k++) {
            while (j >= 0 && -nums[j] < nums[k]) {
                res[i++] = nums[j] * nums[j];
                j--;
            }
            res[i++] = nums[k] * nums[k];
        }
        while (j >= 0) {
            res[i++] = nums[j] * nums[j];
            j--;
        }
        return res;
    }

    private int findFirstPositiveIndex(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (r + l) / 2;
            if (nums[mid] >= 0) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}


class Solution1 {
    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int l = 0, r = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (Math.abs(nums[l]) > Math.abs(nums[r])) {
                ans[i] = nums[l] * nums[l];
                l++;
            } else {
                ans[i] = nums[r] * nums[r];
                r--;
            }
        }
        return ans;
    }
}
