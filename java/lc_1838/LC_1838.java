package lc_1838;

import java.util.Arrays;

/*
 *@author: 黄豪
 *@date : 2021年12月28日
 *@todo:1838. 最高频元素的频数
元素的 频数 是该元素在一个数组中出现的次数。

给你一个整数数组 nums 和一个整数 k 。在一步操作中，你可以选择 nums 的一个下标，并将该下标对应元素的值增加 1 。

执行最多 k 次操作后，返回数组中最高频元素的 最大可能频数 。
*/
public class LC_1838 {
	public static void main(String[] args) {
		new Solution().maxFrequency(new int[]{3,9,6,7,1,5,2} ,2);
	}
}
//我的题解(倒序滑动)
class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return 1;
        int res = 0;
        int r = n - 1;
        int total = 0;
        Arrays.sort(nums);
        for (int l = n - 2; l >= 0; l--){
        	total += (long)(nums[r] - nums[l]);
            while (total > k) {
            	total -= ((nums[r] - nums[r - 1]) * (r - l));
            	r--;
            }
            res = Math.max(r - l + 1, res);
        }
        return res;
    }
}
//官方滑动窗口
class Solution1 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        long total = 0;
        int l = 0, res = 1;
        for (int r = 1; r < n; ++r) {
            total += (long) (nums[r] - nums[r - 1]) * (r - l);
            while (total > k) {
                total -= nums[r] - nums[l];
                ++l;
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}
