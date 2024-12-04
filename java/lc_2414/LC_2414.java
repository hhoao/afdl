package lc_2414;


/**
 * LC_2414
 *
 * @author w
 * @since 2024/9/19
 **/

public class LC_2414 {
}

class Solution {
    public int longestContinuousSubstring(String s) {
        int ans = 1;
        int currentCount = 1;
        char lastChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c - lastChar == 1) {
                currentCount++;
            } else {
                ans = Math.max(ans, currentCount);
                currentCount = 1;
            }
            lastChar = c;
        }
        ans = Math.max(ans, currentCount);
        return ans;
    }
}
