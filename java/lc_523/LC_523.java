package lc_523;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: 黄豪
 *@date : 2021年12月28日
 *@todo:523. 连续的子数组和
给你一个整数数组 nums 和一个整数 k ，编写一个函数来判断该数组是否含有同时满足下述条件的连续子数组：

子数组大小 至少为 2 ，且
子数组元素总和为 k 的倍数。
如果存在，返回 true ；否则，返回 false 。

如果存在一个整数 n ，令整数 x 符合 x = n * k ，则称 x 是 k 的一个倍数。0 始终视为 k 的一个倍数。
*/
public class LC_523 {

}
//暴力
class Solution1 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[n+1];
        f[1] = nums[0];
        for (int i = 2; i <= n; i++){
            f[i] = f[i - 1] + nums[i - 1];
            for (int j = 0; j < i - 1; j++){
                if ((f[i] - f[j]) %k == 0){
                    return true;
                }
            }
        }
        return false;
    }
}
//前缀和+哈希表
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int remainder = 0;
        map.put(0, -1);
        for (int i = 0; i < n; i++){
            remainder = (remainder + nums[i]) % k;
            if (map.containsKey(remainder)){
                if (i - map.get(remainder) >= 2){
                    return true;
                }
            }else{
                map.put(remainder, i);
            }
        }
        return false;
    }
}