package lc_238;

/**
 * @author 黄豪
 *238. 除自身以外数组的乘积
给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积。
 */
public class LC_238 {

}
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1; i < n; i++){
            ans[i] = ans[i - 1] * nums[i-1];
        }
        int R = 1;
        for (int i = n - 1; i >= 1; i--){
            ans[i] = ans[i] * R;
            R *= nums[i];
        }
        ans[0] = R;
        return ans;
    }
}
