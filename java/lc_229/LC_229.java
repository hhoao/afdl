package lc_229;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author 黄豪
 *229. 求众数 II
给定一个大小为 n 的整数数组，找出其中所有出现超过 ⌊ n/3 ⌋ 次的元素。

进阶：尝试设计时间复杂度为 O(n)、空间复杂度为 O(1)的算法解决此问题。
 */
public class LC_229 {

}
//我的代码
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        int target = n/3;
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int k = 1;
        int pre = nums[0];
        for (int i = 1; i < n; i++){
            if (nums[i] == nums[i - 1]){
                k++;
            }else{
                if (k > target){
                    ans.add(pre);
                }
                k = 1;
                pre = nums[i];
            }
        }
        if (k > target){
            ans.add(pre);
        }
        return ans;
    }
}
//摩尔候选
class Solution1 {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int[] candidate = new int[2];
        int candidate1 = 0;
        int candidate2 = 0;
        for (int num : nums){
            if (candidate1 == num){
                candidate[0]++;
                continue;
            }
            if (num == candidate2){
                candidate[1]++;
                continue;
            }
            if (candidate[0] == 0){
                candidate1 = num;
                candidate[0] = 1;
                continue;
            }
            if (candidate[1] == 0){
                candidate2 = num;
                candidate[1] = 1;
                continue;
            }
            candidate[0]--;
            candidate[1]--;
        }
        int count1 = 0, count2 = 0;
        for (int i = 0; i < n; i++){
            if (candidate1 == nums[i]){
                count1++;
            }else if (candidate2 ==nums[i]){
                count2++;
            }
        }
        if (count1 > n/3)
        ans.add(candidate1);
        if (candidate1 != candidate2 && count2 > n/3){
            ans.add(candidate2);
        }
        return ans;
    }
}
