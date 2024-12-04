package lc_485;

/*
 *@author: 黄豪
 *@date : 2021年12月2日
 *@todo:485. 最大连续 1 的个数
给定一个二进制数组， 计算其中最大连续 1 的个数。
*/
public class LC_485 {

}
//暴力
class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int cur= 0;
        for (int i = 0; i < n; i++){
            if (nums[i] == 1){
                cur++;
                ans = Math.max(cur, ans);
            }else{
                cur = 0;
            }
        }
        return ans;
    }
}
