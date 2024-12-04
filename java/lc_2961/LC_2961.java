package lc_2961;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * LC_2961
 *
 * @author xianxing
 * @since 2024/7/30
 **/

public class LC_2961 {
}


// ((aibi % 10)ci) % mi == target
class Solution {
    public List<Integer> getGoodIndices(int[][] variables, int target) {
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < variables.length; i++) {
            int[] v = variables[i];
            if (powMod(powMod(v[0], v[1], 10), v[2], v[3]) == target) {
                ans.add(i);
            }
        }
        return ans;
    }

    private int powMod(int x, int y, int mod) {
        int res = 1;
        while (y > 0) {
            if ((y & 1) == 1) {
                res = res * x % mod;
            }
            x = x * x % mod;
            y >>= 1;
        }
        return res;
    }
}

