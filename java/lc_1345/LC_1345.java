package lc_1345;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@author: 黄豪
 *@date : 2022年1月21日
 *@todo:1345. 跳跃游戏 IV
给你一个整数数组 arr ，你一开始在数组的第一个元素处（下标为 0）。

每一步，你可以从下标 i 跳到下标：

i + 1 满足：i + 1 < arr.length
i - 1 满足：i - 1 >= 0
j 满足：arr[i] == arr[j] 且 i != j
请你返回到达数组最后一个元素的下标处所需的 最少操作次数 。

注意：任何时候你都不能跳到数组外面。

 

示例 1：

输入：arr = [100,-23,-23,404,100,23,23,23,3,404]
输出：3
解释：那你需要跳跃 3 次，下标依次为 0 --> 4 --> 3 --> 9 。下标 9 为数组的最后一个元素的下标。
示例 2：

输入：arr = [7]
输出：0
解释：一开始就在最后一个元素处，所以你不需要跳跃。
示例 3：

输入：arr = [7,6,9,6,9,6,9,7]
输出：1
解释：你可以直接从下标 0 处跳到下标 7 处，也就是数组的最后一个元素处。
*/
public class LC_1345 {

}
//我的题解(超时)
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        boolean[] visited = new boolean[n];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        visited[0] = true;
        int ans = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++){
                int curIndex = deque.poll();
                if (curIndex == n - 1) return ans;
                List<Integer> canJumpList = map.get(arr[curIndex]);
                for (Integer point : canJumpList){
                    if (visited[point]) continue;
                    deque.offer(point);
                }
                if (curIndex - 1 >= 0 && !visited[curIndex - 1]) deque.offer(curIndex - 1);
                if (curIndex + 1 < arr.length && !visited[curIndex + 1]) deque.offer(curIndex + 1);
            }
            ans++;
        }
        return ans;
    }
}
//优化
class Solution1 {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        boolean[] visited = new boolean[n];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        visited[0] = true;
        int ans = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++){
                int curIndex = deque.poll();
                if (curIndex == n - 1) return ans;
                if (map.containsKey(arr[curIndex])){ //多了一个这个
                    List<Integer> canJumpList = map.get(arr[curIndex]);
                    for (Integer point : canJumpList){
                        if (visited[point]) continue;
                        deque.offer(point);
                        visited[point] = true;
                    }
                    map.remove(arr[curIndex]);
                }
                if (curIndex - 1 >= 0 && !visited[curIndex - 1]) {
                    deque.offer(curIndex - 1);
                    visited[curIndex - 1] = true;
                }
                if (curIndex + 1 < arr.length && !visited[curIndex + 1]) {
                    deque.offer(curIndex + 1);
                    visited[curIndex + 1] = true;
                }
            }
            ans++;
        }
        return ans;
    }
}
//加了二个个if快一点
class Solution2 {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++){
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        boolean[] visited = new boolean[n];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(0);
        visited[0] = true;
        int ans = 0;
        while (!deque.isEmpty()){
            int size = deque.size();
            for (int i = 0; i < size; i++){
                int curIndex = deque.poll();
                if (curIndex == n - 1) return ans;
                if (map.containsKey(arr[curIndex])){
                    List<Integer> canJumpList = map.get(arr[curIndex]);
                    for (Integer point : canJumpList){
                        if (point == arr.length - 1) {
                            return ans + 1;
                        }
                        if (visited[point]) continue;
                        deque.offer(point);
                        visited[point] = true;
                    }
                    map.remove(arr[curIndex]);
                }
                if (curIndex - 1 >= 0 && !visited[curIndex - 1]) {
                    deque.offer(curIndex - 1);
                    visited[curIndex - 1] = true;
                }
                if (curIndex + 1 < arr.length && !visited[curIndex + 1]) {
                    if (curIndex + 1 == arr.length - 1) {
                        return ans + 1;
                    }
                    deque.offer(curIndex + 1);
                    visited[curIndex + 1] = true;
                }
            }
            ans++;
        }
        return ans;
    }
}
