package lc_1995;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: 黄豪
 *@date : 2021年12月29日
 *@todo:
*/
public class LC_1995 {

}
//哈希表存储
class Solution {
    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        for (int b = n - 3; b > 0; b--){
            for (int d = b + 2; d < n; d++){
                map.put(nums[d] - nums[b+1], map.getOrDefault(nums[d] - nums[b+1], 0) + 1);
            }
            for (int a = 0; a < b; a++){
                if (map.containsKey(nums[b]+nums[a])){
                    ans += map.get(nums[b] + nums[a]);
                }
            }
        }
        return ans;
    }
}
