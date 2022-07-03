package lc_1705;

import java.util.PriorityQueue;

/*
 *@author: 黄豪
 *@date : 2021年12月24日
 *@todo:
*/
public class LC_1705 {
	public static void main(String[] args) {
		System.out.println(new Solution().eatenApples(new int[]{3,0,0,0,0,2}, new int[]{3,0,0,0,0,2}));
		
	}
}
//最小堆
class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        int ret = 0;
        PriorityQueue<Integer[]> queue = new PriorityQueue<>((a, b)->a[0] - b[0]);
        for (int i = 0; i < n || !queue.isEmpty(); i++){
            while (!queue.isEmpty() && queue.peek()[0] == i){
                queue.poll();
            }
            if  (i <n && apples[i] != 0){
                queue.offer(new Integer[]{days[i]+i, apples[i]});
            }
            if (!queue.isEmpty()){
                queue.peek()[1]--;
                ret++;
                if (queue.peek()[1] == 0){
                    queue.poll();
                }
            }
            
        }
        return ret;
    }
}