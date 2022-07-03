package lc_347;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 *@author: 黄豪
 *@date : 2021年12月17日
 *@todo:347. 前 K 个高频元素
给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
*/
public class LC_347 {

}

//哈希表
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b)->b[1]-a[1]);
        int[] ret = new int[k];
        List<Map.Entry<Integer, Integer>> entrys = new ArrayList<>(map.entrySet());
        entrys.sort((a, b)->b.getValue() - a.getValue());
        for (int i = 0; i < k; i++){
            ret[i] = entrys.get(i).getKey();
        }
        return ret;
    }
}
//排序+优先队列(最快)
class Solution1 {
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b)-> b[1]-a[1]);
        Integer[] numf = new Integer[]{nums[0], 1};
        for (int i = 1; i < n; i++){
            if (nums[i] != nums[i - 1]){
                pq.offer(numf);
                numf = new Integer[]{nums[i], 1};
            }else{
                numf[1]++;
            }
        }
        pq.offer(numf);
        int[] ret = new int[k];
        for (int i = 0; i < k; i++){
            ret[i] = pq.poll()[0];
        }
        return ret;
    }
}
//哈希表和最小堆(优先队列)
class Solution2 {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b)-> b[1]-a[1]);
        for (Map.Entry<Integer, Integer> entrys : map.entrySet()){
            pq.offer(new Integer[]{entrys.getKey(), entrys.getValue()});
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; i++){
            ret[i] = pq.poll()[0];
        }
        return ret;
    }
}