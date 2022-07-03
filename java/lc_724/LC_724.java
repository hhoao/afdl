package lc_724;

import java.util.Arrays;

/*
 *@author: 黄豪
 *@date : 2021年12月31日
 *@todo:724. 寻找数组的中心下标
给你一个整数数组 nums ，请计算数组的 中心下标 。

数组 中心下标 是数组的一个下标，其左侧所有元素相加的和等于右侧所有元素相加的和。

如果中心下标位于数组最左端，那么左侧数之和视为 0 ，因为在下标的左侧不存在元素。这一点对于中心下标位于数组最右端同样适用。

如果数组有多个中心下标，应该返回 最靠近左边 的那一个。如果数组不存在中心下标，返回 -1 。
输入：nums = [1, 7, 3, 6, 5, 6]
输出：3
解释：
中心下标是 3 。
左侧数之和 sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11 ，
右侧数之和 sum = nums[4] + nums[5] = 5 + 6 = 11 ，二者相等。
*/
public class LC_724 {

}
//前缀和
class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int tol = 0;
        for (int i = 0; i < n; i++){   
            if (tol == (sum - nums[i]) - tol){	
                return i;
            }
            tol += nums[i];
        }
        return -1;
    }
}