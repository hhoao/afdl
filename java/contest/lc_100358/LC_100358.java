package contest.lc_100358;

import java.util.HashMap;

/**
 * LC_100358
 *
 * @author xianxing
 * @since 2024/6/30
 **/

public class LC_100358 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maximumLength(new int[]{1, 2, 3, 4, 5}, 2));
        System.out.println(solution.maximumLength(new int[]{1,4,2,3,1,4}, 3));
    }
}

class Solution {
    public int maximumLength(int[] nums, int k) {
        HashMap<Integer, Integer>[] hashMaps = new HashMap[nums.length];
        for (int i = 0; i < nums.length; i++) {
            hashMaps[i] = new HashMap<>();
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int i1 = (nums[i] + nums[j]) % k;
                int orDefault = hashMaps[j].getOrDefault(i1, 0) + 1;
                Integer orDefault1 = hashMaps[i].getOrDefault(i1, 0);
                if (orDefault > orDefault1) {
                    hashMaps[i].put(i1, orDefault);
                    max = Math.max(max, orDefault);
                }
            }
        }
        return max+1;
    }
}
