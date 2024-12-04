package lc_3115;

import java.util.Arrays;

/**
 * LC_3115
 *
 * @author xianxing
 * @since 2024/7/2
 **/

public class LC_3115 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.maximumPrimeDifference(new int[]{4,2,9,5,3}));
//        System.out.println(solution.maximumPrimeDifference(new int[]{4,8,2,8}));
        System.out.println(solution.maximumPrimeDifference(new int[]{2, 2}));
    }
}

class Solution {
    public int maximumPrimeDifference(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }

        int[] dp = new int[max+1];
        for (int i = 1; i <= Math.sqrt(max); i++) {
            for (int j = i; j <= max / i; j++) {
                dp[j * i]++;
            }
        }
        boolean[] prime = new boolean[max+1];
        for (int  i = 1 ;i <= max; i++) {
            prime[i] = dp[i] == 1;
        }
        int lastDist = Integer.MAX_VALUE;
        boolean set = false;
        int ret = 0;
        for (int i = 0; i < nums.length; i++) {
            if (prime[nums[i]]) {
                ret = Math.max(i - lastDist, ret);
                if (!set) {
                    lastDist = i;
                    set  = true;
                }
            }
        }
        return ret;
    }
}
