package lc_1124;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
 *@author: 黄豪
 *@date : 2022年1月12日
 *@todo:1124. 表现良好的最长时间段
给你一份工作时间表 hours，上面记录着某一位员工每天的工作小时数。

我们认为当员工一天中的工作小时数大于 8 小时的时候，那么这一天就是「劳累的一天」。

所谓「表现良好的时间段」，意味在这段时间内，「劳累的天数」是严格 大于「不劳累的天数」。

请你返回「表现良好时间段」的最大长度。

 

示例 1：

输入：hours = [9,9,6,0,6,6,9]
输出：3
解释：最长的表现良好时间段是 [9,9,6]。
示例 2：

输入：hours = [6,6,6]
输出：0
*/
public class LC_1124 {
	public static void main(String[] args) {
		System.out.println(new Solution().longestWPI(new int[] {8,7,7,8,6,11,12}));
	} 
}
//我的题解+前缀和
class Solution {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> map1  = new HashMap<>();
        int[] preSum = new int[n];
        preSum[0] = hours[0] > 8 ? 1 : -1; 
        for (int i = 1; i < n; i++) {
        	preSum[i] += preSum[i - 1] + (hours[i] > 8 ? 1 : -1);
        }
        int ans = 0;
        for (int i = 0; i < n; i++){
            if (hours[i] > 8){
                ans = Math.max(ans, Math.max(i - map.getOrDefault(preSum[i], i) + 1, 
                i - map1.getOrDefault(preSum[i], i) - 1));
                if (!map.containsKey(preSum[i]))
                    map.put(preSum[i], i);
            }else{
                if (i < n - 1 && preSum[i] > preSum[i + 1]){
                    if (!map1.containsKey(preSum[i]))
                        map1.put(preSum[i], i);
                }
            }
            if (preSum[i] > 0){
                ans = i + 1;
            }
        }
        return ans;
    }
}
//单调栈
class Solution1 {
    public int longestWPI(int[] hours) {
        int n = hours.length;
        int[] preSum = new int[n+1];
        int ans = 0;
        for (int i = 0; i < n; i++){
            preSum[i + 1] = preSum[i] + (hours[i] > 8 ? 1 : -1);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(0);
        for (int i = 0; i <= n; i++){
            if (preSum[stack.peek()] > preSum[i]){
                stack.push(i);
            }
        }
        int k = n;
        while (k > ans){
            while (!stack.isEmpty() && preSum[k] > preSum[stack.peek()]){
                ans = Math.max(ans, k - stack.pop());
            }
            k--;
        }
        return ans;
    }
}
