package lc_1567;


/**
 * LC_1567
 *
 * @author w
 * @since 2024/9/22
 **/

public class LC_1567 {
}


class Solution {
    public int getMaxLen(int[] nums) {
        int minPositiveNumberIndex = 0;
        int minNonePositiveNumberIndex = -1;
        int curProduct = 1;
        int ans = 0;
        for (int i =0; i < nums.length; i++) {
            curProduct *= (nums[i] > 0 ? 1 : -1);
            if (nums[i] == 0) {
                curProduct = 1;
                minPositiveNumberIndex = i;
                minNonePositiveNumberIndex = -1;
            } else if (curProduct > 0) {
                ans = Math.max(i - minPositiveNumberIndex + 1, ans);
            } else if (curProduct < 0) {
                if (minNonePositiveNumberIndex == -1) {
                    minNonePositiveNumberIndex = i;
                } else {
                    ans = Math.max(i - minNonePositiveNumberIndex, ans);
                }
            }
        }
        return ans;
    }
}
