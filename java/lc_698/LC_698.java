package lc_698;

import java.util.Arrays;

/*
 *@author: 黄豪
 *@date : 2021年11月3日
 *@todo:698. 划分为k个相等的子集
给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
*/
public class LC_698 {

}
class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int len = nums.length;
        int total = Arrays.stream(nums).sum();
        if (total % k != 0) return false;
        Arrays.sort(nums);
        int target = total / k;
        int size = 1 << len;
        boolean[] valid = new boolean[size];
        int[] curSum = new int[size];
        valid[0] = true;
        for (int i = 0; i < size; i++){
            if (!valid[i]) continue;
            for (int j = 0; j < len; j++){
                if ((i & 1 << j) != 0) continue;
                int next = i | 1 << j;
                if (valid[next]) continue;
                if ((curSum[i] % target) + nums[j] <= target){
                    valid[next] = true;
                    curSum[next] = curSum[i] + nums[j];
                }else{
                    break;
                }
            }
        }
        return valid[size - 1];
    }
}
