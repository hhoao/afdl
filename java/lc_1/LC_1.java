package lc_1;
/*
时间：2020年10月8日12:07:01
题目：两数相加——1
给定一个整数数组 nums?和一个目标值 target，请你在该数组中找出和为目标值的那?两个?整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

?
*/

public class LC_1 {
	public static void main(String[] args) {
		int[] i1 = new int[] {1, 2, 3, 4, 5, 6, 8};
		for (int i : Solution.twoSum(i1, 10)) {
			System.out.println(i);
		}
	}
}

class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }
}

