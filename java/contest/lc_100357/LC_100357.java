package contest.lc_100357;

import java.util.Arrays;

/**
 * LC_100357
 *
 * @author xianxing
 * @since 2024/6/30
 **/

public class LC_100357 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumLength(new int[]{1,2, 3, 4}));
        System.out.println(solution.maximumLength(new int[]{1, 2, 1, 1, 2, 1, 2}));
        System.out.println(solution.maximumLength(new int[]{1, 3}));
    }
}


// 全负数，全正数，一负一正
class Solution {
    public int maximumLength(int[] nums) {
        int[] k = new int[]{0, 0, 1};
        k[nums[0] %2]++;
        int lastK= nums[0] % 2;
        for (int i = 1; i < nums.length; i++) {
            int i1 = nums[i] % 2;
            if (i1 != lastK) {
                k[2]++;
                lastK = i1;
            }
            k[i1]++;
        }
        return Arrays.stream(k).max().orElse(0);
    }
}
