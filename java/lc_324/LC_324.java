package lc_324;

/*
 *@author: 黄豪
 *@date : 2021年12月23日
 *@todo:324. 摆动排序 II
给你一个整数数组 nums，将它重新排列成 nums[0] < nums[1] > nums[2] < nums[3]... 的顺序。

你可以假设所有输入数组都可以得到满足题目要求的结果。
*/
public class LC_324 {

}
class Solution {
    public  void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] buckets = new int[5001];
        for (int num : nums){
            buckets[num]++;
        }
        int j = 5000;
        for (int i = 1; i < n; i += 2){
            while (buckets[j] == 0) j--;
            nums[i] = j;
            buckets[j]--;
        }
        for (int i = 0; i < n; i += 2){
            while (buckets[j] == 0) j--;
            nums[i] = j;
            buckets[j]--;
        }
    }
}