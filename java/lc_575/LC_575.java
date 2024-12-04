package lc_575;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * LC_575
 *
 * @author xianxing
 * @since 2024/6/2
 **/

public class LC_575 {
}

class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> candySet = new HashSet<>();
        for (int i : candyType) {
            candySet.add(i);
        }
        return Math.min(candyType.length / 2, candySet.size());
    }
}
