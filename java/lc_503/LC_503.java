package lc_503;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 *@author: 黄豪
 *@date : 2021年10月28日
 *@todo:503. 下一个更大元素 II
给定一个循环数组（最后一个元素的下一个元素是数组的第一个元素），输出每个元素的下一个更大元素。数字 x 的下一个更大的元素是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1。
*/
public class LC_503 {

}

//单调栈
class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = nums.length;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            if (stack.isEmpty() || nums[i] <= nums[stack.peek()]){
                stack.push(i);
            }else{
                ans[stack.pop()] = nums[i];
                while(!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                    ans[stack.pop()] = nums[i];
                }
                stack.push(i);
            }
        }
        for (int i = 0; i < n; i++){
            if (nums[i] > nums[stack.peek()]){
                ans[stack.pop()] = nums[i];
                
                while(stack.size() != 1 && nums[i] > nums[stack.peek()]){
                    ans[stack.pop()] = nums[i];
                }
            }
        }
        while(!stack.isEmpty()){
            ans[stack.pop()] = -1;
        }
        return ans;
    }
}