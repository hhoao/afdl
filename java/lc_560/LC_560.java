package lc_560;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: 黄豪
 *@date : 2021年12月30日
 *@todo:560. 和为 K 的子数组
给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为 k 的连续子数组的个数。
*/
public class LC_560 {

}
//前缀和+哈希表
class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < n; i++){
            sum += nums[i];
            if (map.containsKey(sum - k)){
                ans += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0)+1);
        }
        return ans;
    }
}
