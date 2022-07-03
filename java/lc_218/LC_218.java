package lc_218;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class LC_218 {

}
//…®√Ëœﬂ∑®
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        for (int[] building : buildings){
            queue.offer(new int[]{building[0], -building[2]});
            queue.offer(new int[]{building[1], building[2]});
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>((a, b) -> b - a);
        List<List<Integer>> ans = new ArrayList<>();
        treeMap.put(0, 1);
        int height = 0;
        while (!queue.isEmpty()){
            int[] h = queue.poll();
            if (h[1] < 0){
                treeMap.put(-h[1], treeMap.getOrDefault(-h[1], 0) + 1);
            }else{
                treeMap.put(h[1], treeMap.get(h[1]) - 1);
                if (treeMap.get(h[1]) == 0){
                    treeMap.remove(h[1]);
                }
            }
            int maxheight = treeMap.keySet().iterator().next();
            if (maxheight != height){
                int left = h[0];
                height = maxheight;
                ans.add(Arrays.asList(left, height));
            }
        }
        return ans;
    }
}