package lc_3096;

/**
 * LC_3096
 *
 * @author xianxing
 * @since 2024/7/19
 **/

public class LC_3096 {
}

class Solution {
    public int minimumLevels(int[] possible) {
        int totalScore =  0;
        for (int i : possible) {
            totalScore += i == 0 ? -1 : 1;
        }
        int curScore = possible[0] == 0 ? -1 : 1;
        for (int i = 0; i < possible.length - 1; i++) {
            curScore += possible[i] == 0 ? -1 : 1;
            int abs = curScore - totalScore;
            if (abs > 0) {
                return i+1;
            }
        }
        return -1;
    }
}
