package lc_826;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 方法一：排序 + 双指针
 * 思路与算法
 * 我们首先对工人按照能力大小排序，对工作按照难度排序。
 * 我们使用「双指针」的方法，一个指针指向工人数组，一个指向任务数组，从低难度的任务开始遍历。对于每个工人，我们继续遍历任务，直到难度大于其能力，并把可以完成任务中的最大利润更新到结果中。
 * 最后返回所有工人能得到的利润总和。
 * LC_826
 *
 * @author xianxing
 * @since 2024/5/17
 **/

public class LC_826 {
    public static void main(String[] args) {
        int[] difficulty = new int[]{5,50,92,21,24,70,17,63,30,53};
        int[] profit = new int[]{68,100,3,99,56,43,26,93,55,25};
        int[] worker = new int[]{96,3,55,30,11,58,68,36,26,1};
        Solution solution = new Solution();
        System.out.println(solution.maxProfitAssignment(difficulty, profit, worker));
    }
}


class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] difficultyWithProfit = new int[difficulty.length][3];
        for (int i = 0; i < difficulty.length; i++) {
            difficultyWithProfit[i][0] = difficulty[i];
            difficultyWithProfit[i][1] = profit[i];
        }
        Arrays.sort(difficultyWithProfit, Comparator.comparingInt(o -> o[0]));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < difficulty.length; i++) {
            max = Math.max(difficultyWithProfit[i][1], max);
            difficultyWithProfit[i][2] = max;
        }
        int res = 0;
        int startWith = 0;
        Arrays.sort(worker);
        for (int j : worker) {
            int mid = getMid(j, difficultyWithProfit, startWith);
            if (difficultyWithProfit[mid][0] <= j) {
                res += difficultyWithProfit[mid][2];
            }
            startWith = mid;
        }
        return res;
    }

    int getMid(int needDifficult, int[][] sorted, int startWith) {
        int l = startWith, r = sorted.length - 1, mid;
        while (l < r) {
            mid = r - (r - l) / 2;
            if (sorted[mid][0] > needDifficult) {
                r = mid - 1;
            } else if (sorted[mid][0] <= needDifficult){
                l = mid;
            }
        }
        return sorted[r][0] > needDifficult ? l : r;
    }
}


class Solution1 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] difficultyWithProfit = new int[difficulty.length][3];
        for (int i = 0; i < difficulty.length; i++) {
            difficultyWithProfit[i][0] = difficulty[i];
            difficultyWithProfit[i][1] = profit[i];
        }
        Arrays.sort(difficultyWithProfit, Comparator.comparingInt(o -> o[0]));
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < difficulty.length; i++) {
            max = Math.max(difficultyWithProfit[i][1], max);
            difficultyWithProfit[i][2] = max;
        }
        int res = 0;
        for (int j : worker) {
            int mid = getMid(j, difficultyWithProfit);
            if (difficultyWithProfit[mid][0] <= j) {
                res += difficultyWithProfit[mid][2];
            }
        }
        return res;
    }

    int getMid(int needDifficult, int[][] sorted) {
        int l = 0, r = sorted.length - 1, mid;
        while (l < r) {
            mid = r - (r - l) / 2;
            if (sorted[mid][0] > needDifficult) {
                r = mid - 1;
            } else if (sorted[mid][0] <= needDifficult){
                l = mid;
            }
        }
        return sorted[r][0] > needDifficult ? l : r;
    }
}
