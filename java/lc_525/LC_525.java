package lc_525;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: 黄豪
 *@date : 2021年12月28日
 *@todo:525. 连续数组
给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
*/
public class LC_525 {

}
//前缀和+哈希表
class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int zeros = 0;
        int ones = 0;
        int ans = 0;
        for (int i = 0; i <n; i++){
            if (nums[i] == 0){
                zeros++;
            }else{
                ones++;
            }
            int ext = zeros - ones;
            if (map.containsKey(ext)){
                int ind =  map.get(ext);
                ans = Math.max(ans, i - ind);
            }else{
                map.put(ext, i);
            }
        }
        return ans;
    }
}
//官方
class Solution1 {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int count = 0;
        int ans = 0;
        for (int i = 0; i <n; i++){
            if (nums[i] == 0){
                count++;   
            }else{
                count--;
            }
            if (map.containsKey(count)){
                int ind =  map.get(count);
                ans = Math.max(ans, i - ind);
            }else{
                map.put(count, i);
            }
        }
        return ans;
    }
}