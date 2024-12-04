package lc_219;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 黄豪
 *219. 存在重复元素 II
给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。
 */
public class LC_219 {

}


//我的代码
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        int len  = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++){
            int num = nums[i];
            if (indexMap.containsKey(nums[i])){
                int index = indexMap.get(num);
                len = i - index;
                if (len <= k) return true;
            }
            indexMap.put(num, i);
        }
        return false;
    }
}
