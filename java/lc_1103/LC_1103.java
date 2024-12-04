package lc_1103;

import java.util.Arrays;

/**
 * LC_1103
 *
 * @author xianxing
 * @since 2024/6/3
 **/

public class LC_1103 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ints = solution.distributeCandies(60, 4);
        System.out.println(Arrays.toString(ints));
    }
}

class Solution {
    public int[] distributeCandies(int candies, int num_people) {
        int sum = (int) (((float) num_people + 1) / 2 * num_people);
        int k = getK(sum, num_people, candies);
        int[] ans = new int[num_people];
        int remainder = candies - getTotal(k - 1, sum, num_people);
        for (int i = 0; i < num_people; i++) {
            int fixCandy = getKICandyTotal(k - 1, i + 1, num_people);
            int nextCandy = getKICandy(k, i + 1, num_people);
            ans[i] = fixCandy + Math.max(Math.min(remainder, nextCandy), 0);
            remainder -= nextCandy;
        }
        return ans;
    }

    private int getKICandyTotal(int k, int i, int n) {
        return (i + (k - 1) * n + i) * k / 2;
    }

    private int getKICandy(int k, int i, int n) {
        return i + (k - 1) * n;
    }

    private int getK(int sum, int n, int candies) {
        int k = 1;
        while (candies > getTotal(k, sum, n)) {
            k++;
        }
        return k;
    }

    private int getTotal(int k, int sum, int n) {
        if (k == 0) {
            return 0;
        }
        return (2 * sum + (k - 1) * n * n) * k / 2;
    }
}
