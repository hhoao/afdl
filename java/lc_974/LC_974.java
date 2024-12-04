package lc_974;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: 黄豪
 *@date : 2022年1月1日
 *@todo:974. 和可被 K 整除的子数组
给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
*/
public class LC_974 {

}
//哈希表+前缀和
class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0, ans = 0;
        for (int i = 0; i < n; i++){
            map.put(sum, map.getOrDefault(sum, 0) + 1);
            sum = (sum + nums[i]) % k;
            if (sum < 0){
                ans += map.getOrDefault(sum +k, 0);
            }else{
                ans += map.getOrDefault(sum - k, 0);
            }
            ans += map.getOrDefault(sum, 0);
        }
        return ans;
    }
}
//数组哈希 + 前缀和
class Solution1 {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[2 * k];
        int sum = 0, ans = 0;
        for (int i = 0; i < n; i++){
            f[k+sum]++;
            sum = (sum + nums[i]) % k;
            if (sum < 0){
                ans += f[2 * k+sum];
            }else{
                ans += f[sum];
            }
            ans += f[k + sum];
        }
        return ans;
    }
}
//最优题解
class Solution2 {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
        int[] f = new int[k];
        int sum = 0, ans = 0;
        for (int i = 0; i < n; i++){
            f[sum]++;
            sum = ((sum + nums[i]) % k + k) % k;
            ans += f[sum];
        }
        return ans;
    }
}
