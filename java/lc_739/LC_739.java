package lc_739;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 *@author: 黄豪
 *@date : 2022年1月23日
 *@todo:739. 每日温度
请根据每日 气温 列表 temperatures ，请计算在每一天需要等几天才会有更高的温度。如果气温在这之后都不会升高，请在该位置用 0 来代替。

示例 1:

输入: temperatures = [73,74,75,71,69,72,76,73]
输出: [1,1,4,2,1,1,0,0]
示例 2:

输入: temperatures = [30,40,50,60]
输出: [1,1,1,0]
示例 3:

输入: temperatures = [30,60,90]
输出: [1,1,0]
*/
public class LC_739 {

}
//单调栈
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Deque<Integer> monoStack = new ArrayDeque<>();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            while (!monoStack.isEmpty() && temperatures[i] > temperatures[monoStack.peek()]){
                int popIndex = monoStack.pop();
                ans[popIndex] = i - popIndex;
            }
            monoStack.push(i);
        }
        return ans;
    }
}
