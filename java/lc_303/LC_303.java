package lc_303;

/*
 *@author: 黄豪
 *@date : 2021年7月30日
 *@todo:303. 区域和检索 - 数组不可变
给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。

实现 NumArray 类：

NumArray(int[] nums) 使用数组 nums 初始化对象
int sumRange(int i, int j) 返回数组 nums 从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
*/
public class LC_303 {
	public static void main(String[] args) {
	}
}
class NumArray {
    int[] sums;
    public NumArray(int[] nums) {
        sums = new int[nums.length];
        sums[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            sums[i] = sums[i - 1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
    	if (left == 0) {
    		return sums[right];
    	}
    	return sums[right] - sums[left - 1];
    }
}