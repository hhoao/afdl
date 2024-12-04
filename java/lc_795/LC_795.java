package lc_795;

/**
 * LC_795
 *
 * @author xianxing
 * @since 2024/6/12
 **/

public class LC_795 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.numSubarrayBoundedMax(new int[]{73, 55, 36, 5, 55, 14, 9, 7, 72, 52}, 32, 69);
        System.out.println(i);
    }
}

class Solution3 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int res = 0, last2 = -1, last1 = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= left && nums[i] <= right) {
                last1 = i;
            } else if (nums[i] > right) {
                last2 = i;
                last1 = -1;
            }
            if (last1 != -1) {
                res += last1 - last2;
            }
        }
        return res;
    }
}

class Solution {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        return count(nums, right) - count(nums, left - 1);
    }

    public int count(int[] nums, int lower) {
        int res = 0, cur = 0;
        for (int x : nums) {
            cur = x <= lower ? cur + 1 : 0;
            res += cur;
        }
        return res;
    }
}

class Solution2 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0, res = 0, max = 0, lowerCount = 0;
        for (int num : nums) {
            if (num >= left && num <= right) {
                max = Math.max(num, max);
                res -= caculateCount(lowerCount);
                count++;
                lowerCount = 0;
            } else if (num > right) {
                if (max != -1) {
                    max = -1;
                    res -= caculateCount(lowerCount);
                    res += caculateCount(count);
                }
                count = 0;
                lowerCount = 0;
            } else {
                lowerCount++;
                count++;
            }
        }
        if (max >= left && max <= right) {
            res += caculateCount(count);
            res -= caculateCount(lowerCount);
        }
        return res;
    }

    private int caculateCount(int count) {
        return (int) ((1.0 + count) / 2.0 * count);
    }
}


class Solution1 {
    public int numSubarrayBoundedMax(int[] nums, int left, int right) {
        int count = 0, res = 0, max = 0, lowerCount = 0;
        for (int num : nums) {
            if (num >= left && num <= right) {
                max = Math.max(num, max);
                res -= caculateCount(lowerCount);
                count++;
                lowerCount = 0;
            } else if (num > right) {
                if (max != -1) {
                    max = -1;
                    res -= caculateCount(lowerCount);
                    res += caculateCount(count);
                }
                count = 0;
                lowerCount = 0;
            } else {
                lowerCount++;
                count++;
            }
        }
        if (max >= left && max <= right) {
            res += caculateCount(count);
            res -= caculateCount(lowerCount);
        }
        return res;
    }

    private int caculateCount(int count) {
        return (int) ((1.0 + count) / 2.0 * count);
    }
}
