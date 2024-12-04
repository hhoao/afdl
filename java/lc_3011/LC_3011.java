package lc_3011;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

/**
 * LC_3011
 *
 * @author xianxing
 * @since 2024/7/13
 **/

public class LC_3011 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        boolean b = solution.canSortArray(new int[]{3, 16, 8, 4, 2});
        boolean b = solution.canSortArray(new int[]{20, 16});
        System.out.println(b);
    }
}

class Solution {
    public boolean canSortArray(int[] nums) {
        PriorityQueue<Integer> bitCountNums = new PriorityQueue<>();
        int lastBitCount = Integer.bitCount(nums[0]);
        int lastMaNum = -1;
        bitCountNums.offer(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            int bitCount = Integer.bitCount(nums[i]);
            if (bitCount != lastBitCount) {
                while (!bitCountNums.isEmpty()) {
                    Integer poll = bitCountNums.poll();
                    if (poll < lastMaNum) {
                        return false;
                    }
                    lastMaNum = poll;
                }
                lastBitCount = bitCount;
            }
            bitCountNums.offer(nums[i]);
        }
        if (!bitCountNums.isEmpty()) {
            Integer poll = bitCountNums.poll();
            if (poll < lastMaNum) {
                return false;
            }
        }
        return true;
    }
}

class Solution1 {
    public boolean canSortArray(int[] nums) {
        int lastCnt = 0;
        int lastGroupMax = 0;
        int curGroupMax = 0;
        for (int num : nums) {
            int curCnt = Integer.bitCount(num);
            if (curCnt == lastCnt) {
                curGroupMax = Math.max(curGroupMax, num);
            } else {
                lastCnt = curCnt;
                lastGroupMax = curGroupMax;
                curGroupMax = num;
            }
            if (num < lastGroupMax) {
                return false;
            }
        }
        return true;
    }
}

