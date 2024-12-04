package lc_368;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author 黄豪
 *368. 最大整除子集
给你一个由 无重复 正整数组成的集合 nums ，请你找出并返回其中最大的整除子集 answer ，子集中每一元素对 (answer[i], answer[j]) 都应当满足：
answer[i] % answer[j] == 0 ，或
answer[j] % answer[i] == 0
如果存在多个有效解子集，返回其中任何一个均可。
 */
public class LC_368 {

}
class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int n = nums.length;
        if (n == 1) {
            res.add(nums[0]);
            return res;
        }
        Arrays.sort(nums);
        int[] dp = new int[n];
        int maxLength = 0, maxNum = 0;
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                if (nums[i] % nums[j] == 0){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    if (dp[i] > maxLength){
                        maxLength = Math.max(maxLength, dp[i]);
                        maxNum = nums[i];
                    }
                }
            }
        }
        maxLength++;
        
        for (int i = n -1; i >= 0 && maxLength > 0; i--){
            if (dp[i] == maxLength - 1 && maxNum % nums[i] == 0){
                maxNum = nums[i];
                maxLength--;
                res.add(nums[i]);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
