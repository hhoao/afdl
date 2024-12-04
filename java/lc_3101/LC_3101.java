package lc_3101;

/**
 * LC_3101
 *
 * @author xianxing
 * @since 2024/7/6
 **/

public class LC_3101 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        long l = solution.countAlternatingSubarrays(new int[]{0, 1, 1, 1});
        System.out.println(l);
    }
}

class Solution {
    public long countAlternatingSubarrays(int[] nums) {
        long count = 1;
        long res = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                res += (long) ((count + 1) * (0.5 * count));
                count = 1;
            } else {
                count++;
            }
        }
        res += (int) ((count + 1) * (0.5* count));
        return res;
    }
}
