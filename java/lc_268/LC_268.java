package lc_268;

/*
 *@author: 黄豪
 *@date : 2021年5月2日
 *TODO:268. 丢失的数字
给定一个包含 [0, n] 中 n 个数的数组 nums ，找出 [0, n] 这个范围内没有出现在数组中的那个数。

 

进阶：

你能否实现线性时间复杂度、仅使用额外常数空间的算法解决此问题?
*/
public class LC_268 {

}
//我的代码
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int k = 0;
        for (int i = 0; i < n; i++){
            sum += i;
            k += nums[i];
        }
        sum += n;
        return sum - k;
    }
}
//位运算
class Solution1 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans = n;
        for (int i = 0; i < n; i++){
            ans ^= nums[i] ^ i; 
        }
        return ans;
    }
}