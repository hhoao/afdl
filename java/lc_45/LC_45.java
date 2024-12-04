package lc_45;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author 黄豪
 *45. 跳跃游戏 II
给定一个非负整数数组，你最初位于数组的第一个位置。

数组中的每个元素代表你在该位置可以跳跃的最大长度。

你的目标是使用最少的跳跃次数到达数组的最后一个位置。

示例:

输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
说明:

假设你总是可以到达数组的最后一个位置。
 */
public class LC_45 {

}
//反向查找出发位置
class Solution {
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
}
//正向查找可到达的最大位置
class Solution1 {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0; 
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]); 
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
//贪心算法
class Solution2 {

    //贪心算法：
    //若当前处于位置i上，则其下一步跳跃的可选择范围为区间[i+1, i+nums[i]]，
    //遍历区间[i+1, i+nums[i]]中的每个点，并计算每个点的新覆盖范围，
    //最终在位置i上的下一步跳跃将从区间[i+1, i+nums[i]]中选择新覆盖范围最大的位置。

    public int jump(int[] nums) {
        return bfs(nums);
        
    }

    private int bfs(int[] nums) {
        int n = nums.length;
        Deque<Integer> queue = new LinkedList<>();
        queue.add(0);
        int step = 0;

        while(!queue.isEmpty()) {
            int queueSize = queue.size();
            while(queueSize-- > 0) {
                int curr = queue.poll();

                //当前点即是目标位置，直接返回step
                if(curr == n-1) {
                    return step;
                }

                //当前点的覆盖范围包括目标位置，直接返回step+1
                if(curr + nums[curr] >= n-1) {
                    return 1 + step;
                }

                //贪心：每次跳跃选择能够使新的覆盖范围最大的位置
                int maxCover = 0;
                int nextPosition = -1;
                for(int i = 1; i <= nums[curr]; i++) {
                    int tmp = curr + i;
                    if(tmp < n && maxCover < tmp + nums[tmp]) {
                        maxCover = tmp + nums[tmp];
                        nextPosition = tmp;
                    }
                }
                //将新的最优跳跃点放入队列并使步数加1
                if(nextPosition != -1) {
                    queue.offer(nextPosition);
                    step++;
                }
                   
            }
            
        }
        return step;
    }
    
    
   
}
