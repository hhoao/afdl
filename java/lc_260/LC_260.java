package lc_260;

/*
 *@author: 黄豪
 *@date : 2021年5月2日
 *260. 只出现一次的数字 III
给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。你可以按 任意顺序 返回答案。

 

进阶：你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？
*/
public class LC_260 {

}
class Solution {
    public int[] singleNumber(int[] nums) {
        int k = 0;
        for (int num : nums){
            k = k ^ num;
        }
        int n = 1;
        while ((k & n) == 0){
            n <<= 1;
        }
        int a = 0, b = 0;
        for (int num : nums){
            if ((num & n) == 0){
                a = a ^ num;
            }else{
                b = b ^ num;
            }
        }
        return new int[]{a, b};
    }
}