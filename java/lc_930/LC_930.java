package lc_930;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: 黄豪
 *@date : 2022年1月1日
 *@todo:930. 和相同的二元子数组
给你一个二元数组 nums ，和一个整数 goal ，请你统计并返回有多少个和为 goal 的 非空 子数组。

子数组 是数组的一段连续部分。
*/
public class LC_930 {

}
//前缀和+哈希表
class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, ans = 0;
        map.put(0, 1);
        for (int i = 0; i < n; i++){
            sum += nums[i];
            if (map.containsKey(sum -goal)){
                ans += map.get(sum - goal);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return ans;
    }
}
//滑动窗口
class Solution1 {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length, ans = 0;
        int l1 = 0, l2 = 0;
        int sum1 = 0, sum2 = 0;
        for (int i  = 0; i < n; i++){
            sum1 += nums[i];
            while (l1 <= i && sum1 > goal){
                sum1 -= nums[l1];
                l1++;
            }
            sum2 += nums[i];
            while (l2 <= i && sum2 >= goal){
                sum2 -= nums[l2];
                l2++;
            }
            ans += l2 - l1;
        }
        return ans;
    }
}