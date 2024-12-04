package lc_2850;

import java.util.ArrayList;
import java.util.Collections;

/**
 * LC_2850
 *
 * @author xianxing
 * @since 2024/7/20
 **/

public class LC_2850 {
}

class Solution {
    public int minimumMoves(int[][] grid) {
        ArrayList<Integer[]> zeros = new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    zeros.add(new Integer[]{i, j});
                }
            }
        }

        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > 1) {
                    res += getSteps(zeros, i, j, grid[i][j] - 1);
                }
            }
        }
        return res;
    }

    private int getSteps(ArrayList<Integer[]> zeros, int x, int y, int count) {
        int res = 0;
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < zeros.size(); j++) {
                Integer[] zero = zeros.get(j);
                Integer[] cur = zeros.get(i);
                if ((Math.abs(zero[0] - x) + Math.abs(zero[1] -y)) > (Math.abs(cur[0] - x) + Math.abs(cur[1] - y))) {
                    Collections.swap(zeros, 0, j);
                }
            }
            res += Math.abs(zeros.get(i)[0] - x) + Math.abs(zeros.get(i)[1] - y);
        }
        for (int i = 0; i < count; i++) {
            zeros.remove(0);
        }
        return res;
    }
}
