package lc_581;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 *@author: 黄豪
 *@date : 2022年1月22日
 *@todo:581. 最短无序连续子数组
给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。

请你找出符合题意的 最短 子数组，并输出它的长度。

 

示例 1：

输入：nums = [2,6,4,8,10,9,15]
输出：5
解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
示例 2：

输入：nums = [1,2,3,4]
输出：0
示例 3：

输入：nums = [1]
输出：0
*/
public class LC_581 {

}
//单调栈
class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();
        int minIndex = Integer.MAX_VALUE, maxIndex = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++){
            while(!deque.isEmpty() && nums[i] < nums[deque.peek()]){
                int ind = deque.pop();
                minIndex = Math.min(minIndex, ind);
                maxIndex = Math.max(maxIndex, ind);
            }
            deque.push(i);
        }
        deque.clear();
        for (int i = n - 1; i >= 0; i--){
            while(!deque.isEmpty() && nums[i] > nums[deque.peek()]){
                int ind = deque.pop();
                minIndex = Math.min(minIndex, ind);
                maxIndex = Math.max(maxIndex, ind);
            }
            deque.push(i);
        }
        if (minIndex == Integer.MAX_VALUE) return 0;
        return maxIndex - minIndex + 1;
    }
}
//一次遍历
class Solution1 {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int maxn = Integer.MIN_VALUE, right = -1;
        int minn = Integer.MAX_VALUE, left = -1;
        for (int i = 0; i < n; i++) {
            if (maxn > nums[i]) {
                right = i;
            } else {
                maxn = nums[i];
            }
            if (minn < nums[n - i - 1]) {
                left = n - i - 1;
            } else {
                minn = nums[n - i - 1];
            }
        }
        return right == -1 ? 0 : right - left + 1;
    }
}