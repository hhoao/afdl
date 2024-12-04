package lc_3144;


import java.util.HashMap;
import java.util.Map;

/**
 * LC_3144
 *
 * @author xianxing
 * @since 2024/8/28
 **/

public class LC_3144 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.minimumSubstringsInPartition("fabccddg");
        System.out.println(i);
    }
}


class Solution {
    public int minimumSubstringsInPartition(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        for (int i = 1; i <= s.length(); i++) {
            Map<Character, Integer> characterCount = new HashMap<>();
            int maxCnt = 0;
            dp[i] = Integer.MAX_VALUE;
            for (int j = i; j >= 1; j--) {
                Integer compute = characterCount.compute(s.charAt(j - 1), (c, count) -> count != null ? count + 1 : 1);
                maxCnt = Math.max(compute, maxCnt);
                if (characterCount.size() * maxCnt == i - j + 1) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + 1);
                }
            }
        }
        return dp[s.length()];
    }
}

