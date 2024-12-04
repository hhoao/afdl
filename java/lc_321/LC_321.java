package lc_321;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 *@author: 黄豪
 *@date : 2022年1月23日
 *@todo:
*/
public class LC_321 {
	public static void main(String[] args) {
		for (int i : new Solution().maxNumber(new int[] {3,4,8,9,3,0}, new int[]{6,1,9,1,1,2}, 6)){
			System.out.println(i);
		}
	}
}
//单调栈
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length, m = nums2.length;
        int[] maxSubsequence = new int[k];
        //只能有[start, end]位数
        int start = Math.max(0, k - m), end = Math.min(n, k);
        for (int i = start; i <= end; i++){
        	//丢弃n-i后nums1最大
            int[] subSequence1 = getMaxSubSequence(nums1, n - i);
            //丢弃m-k+i后num2最大
            int[] subSequence2 = getMaxSubSequence(nums2, m - k + i);
            int[] mergeArr = merge(subSequence1, subSequence2);
            if (compare(mergeArr, 0, maxSubsequence, 0) > 0){
                maxSubsequence = mergeArr;
            }
        }
        return maxSubsequence;
    }
    private int[] getMaxSubSequence(int[] nums, int k){
        int n = nums.length;
        Deque<Integer> stack = new ArrayDeque<>();
        int size = n - k;
        int[] subSequence = new int[n - k];
        for (int i = 0; i < n; i++){
            while (!stack.isEmpty() && nums[i] > stack.peek() && k > 0){
                stack.pop();
                k--;
            }
            stack.push(nums[i]);
        }
        while (k > 0){
            stack.pop();
            k--;
        }
        for (int i = size - 1; i >= 0; i--){
            subSequence[i] = stack.pop();
        }
        return subSequence;
    }
    private int[] merge(int[] subsequence1, int[] subsequence2){
    	int x = subsequence1.length, y = subsequence2.length;
        if (x == 0) {
            return subsequence2;
        }
        if (y == 0) {
            return subsequence1;
        }
        int mergeLength = x + y;
        int[] merged = new int[mergeLength];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < mergeLength; i++) {
            if (compare(subsequence1, index1, subsequence2, index2) > 0) {
                merged[i] = subsequence1[index1++];
            } else {
                merged[i] = subsequence2[index2++];
            }
        }
        return merged;
    }
    private int compare(int[] mergeArr, int index1, int[] maxSubsequence, int index2){
        int x = mergeArr.length, y = maxSubsequence.length;
        while (index1 < x && index2 < y) {
        	int difference = mergeArr[index1++] - maxSubsequence[index2++];
            if (difference != 0) {
            	return difference;
            }
        }
        return (x - index1) - (y - index2);
    }
}
//官方
class Solution1 {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] maxSubsequence = new int[k];
        int start = Math.max(0, k - n), end = Math.min(k, m);
        for (int i = start; i <= end; i++) {
            int[] subsequence1 = maxSubsequence(nums1, i);
            int[] subsequence2 = maxSubsequence(nums2, k - i);
            int[] curMaxSubsequence = merge(subsequence1, subsequence2);
            if (compare(curMaxSubsequence, 0, maxSubsequence, 0) > 0) {
                System.arraycopy(curMaxSubsequence, 0, maxSubsequence, 0, k);
            }
        }
        return maxSubsequence;
    }

    public int[] maxSubsequence(int[] nums, int k) {
        int length = nums.length;
        int[] stack = new int[k];
        int top = -1;
        int remain = length - k;
        for (int i = 0; i < length; i++) {
            int num = nums[i];
            while (top >= 0 && stack[top] < num && remain > 0) {
                top--;
                remain--;
            }
            if (top < k - 1) {
                stack[++top] = num;
            } else {
                remain--;
            }
        }
        return stack;
    }

    public int[] merge(int[] subsequence1, int[] subsequence2) {
        int x = subsequence1.length, y = subsequence2.length;
        if (x == 0) {
            return subsequence2;
        }
        if (y == 0) {
            return subsequence1;
        }
        int mergeLength = x + y;
        int[] merged = new int[mergeLength];
        int index1 = 0, index2 = 0;
        for (int i = 0; i < mergeLength; i++) {
            if (compare(subsequence1, index1, subsequence2, index2) > 0) {
                merged[i] = subsequence1[index1++];
            } else {
                merged[i] = subsequence2[index2++];
            }
        }
        return merged;
    }

    public int compare(int[] subsequence1, int index1, int[] subsequence2, int index2) {
        int x = subsequence1.length, y = subsequence2.length;
        while (index1 < x && index2 < y) {
            int difference = subsequence1[index1] - subsequence2[index2];
            if (difference != 0) {
                return difference;
            }
            index1++;
            index2++;
        }
        return (x - index1) - (y - index2);
    }
}
