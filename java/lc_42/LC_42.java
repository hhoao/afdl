package lc_42;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 黄豪
 *42. 接雨水
给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

 

示例 1：



输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
示例 2：

输入：height = [4,2,0,3,2,5]
输出：9
 

提示：

n == height.length
0 <= n <= 3 * 104
0 <= height[i] <= 105
 */
public class LC_42 {

}
//暴力法
class Solution{
	public int trap(int[] height) {
	    int ans = 0;
	    int size = height.length;
	    for (int i = 1; i < size - 1; i++) {
	        int max_left = 0, max_right = 0;
	        for (int j = i; j >= 0; j--) { //Search the left part for max bar size
	            max_left = Math.max(max_left, height[j]);
	        }
	        for (int j = i; j < size; j++) { //Search the right part for max bar size
	            max_right = Math.max(max_right, height[j]);
	        }
	        ans += Math.min(max_left, max_right) - height[i];
	    }
	    return ans;
	}
}

//动态规划
class Solution2{
	public int trap(int[] height) {
	    if (height == null || height.length == 0)
	        return 0;
	    int ans = 0;
	    int size = height.length;
	    int[] left_max = new int[size];
	    int[] right_max = new int[size];
	    left_max[0] = height[0];
	    for (int i = 1; i < size; i++) {
	        left_max[i] = Math.max(height[i], left_max[i - 1]);
	    }
	    right_max[size - 1] = height[size - 1];
	    for (int i = size - 2; i >= 0; i--) {
	        right_max[i] = Math.max(height[i], right_max[i + 1]);
	    }
	    for (int i = 1; i < size - 1; i++) {
	        ans += Math.min(left_max[i], right_max[i]) - height[i];
	    }
	    return ans;
	}
}

//栈的应用
class Solution3{
	public int trap(int[] height) {
	    int ans = 0, current = 0; 
	    Deque<Integer> stack = new LinkedList<Integer>();
	    while (current < height.length) {
	        while (!stack.isEmpty() && height[current] > height[stack.peek()]) {
	            int top = stack.pop();
	            if (stack.isEmpty())
	                break;
	            int distance = current - stack.peek() - 1;
	            int bounded_height = Math.min(height[current], height[stack.peek()]) - height[top];
	            ans += distance * bounded_height;
	        }
	        stack.push(current++);
	    }
	    return ans;
	}
}
//双指针
class Solution4{
	public int trap(int[] height) {
	    int left = 0, right = height.length - 1;
	    int ans = 0;
	    int left_max = 0, right_max = 0;
	    while (left < right) {
	        if (height[left] < height[right]) {
	            if (height[left] >= left_max) {
	                left_max = height[left];
	            } else {
	                ans += (left_max - height[left]);
	            }
	            ++left;
	        } else {
	            if (height[right] >= right_max) {
	                right_max = height[right];
	            } else {
	                ans += (right_max - height[right]);
	            }
	            --right;
	        }
	    }
	    return ans;
	}
}
