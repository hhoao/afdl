package lc_334;

/*
 *@author: 黄豪
 *@date : 2022年1月12日
 *@todo:334. 递增的三元子序列
给你一个整数数组 nums ，判断这个数组中是否存在长度为 3 的递增子序列。

如果存在这样的三元组下标 (i, j, k) 且满足 i < j < k ，使得 nums[i] < nums[j] < nums[k] ，返回 true ；否则，返回 false 。

 

示例 1：

输入：nums = [1,2,3,4,5]
输出：true
解释：任何 i < j < k 的三元组都满足题意
示例 2：

输入：nums = [5,4,3,2,1]
输出：false
解释：不存在满足题意的三元组
示例 3：

输入：nums = [2,1,5,0,4,6]
输出：true
解释：三元组 (3, 4, 5) 满足题意，因为 nums[3] == 0 < nums[4] == 4 < nums[5] == 6
*/
public class LC_334 {

}
//我的题解
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n = nums.length;
        if (n < 3) return false;
        int f = nums[0], s = Integer.MAX_VALUE;
        for (int i = 1; i < n; i++){
        	if (nums[i] <= f){
                f = nums[i];
            }else if (nums[i] <= s){
                s = nums[i];
            }else{
                return true;
            }
        }
        return false;
    }
}