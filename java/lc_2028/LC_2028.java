package lc_2028;

import java.util.Arrays;

/**
 * LC_2028
 *
 * @author xianxing
 * @since 2024/5/27
 **/

public class LC_2028 {
}

class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = Arrays.stream(rolls).sum();
        int i = mean * (m + n);
        int remainder = (i - sum) % n;
        int v = (i - sum) / n;
        if ((v > 6 || v < 1) || (v == 6 && remainder != 0)) {
            return new int[0];
        }
        int[] res = new int[n];
        for (int k = 0; k < n; k++) {
            if (k < remainder) {
                res[k] = v + 1;
            } else {
                res[k] = v;
            }
        }
        return res;
    }
}
