package lc_152;

public class LC_152 {

}
//¶¯Ì¬¹æ»®
class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] maxs = new int[n + 1];
        int[] mins = new int[n + 1];
        maxs[0] = nums[0];
        mins[0] = nums[0];
        int ans = nums[0];
        for (int i =1; i<n; i++){
            maxs[i] = Math.max(Math.max(nums[i] * nums[i - 1], nums[i]), Math.max(nums[i] * maxs[i - 1], nums[i] * mins[i - 1]));
            mins[i] = Math.min(Math.min(nums[i], maxs[i - 1] * nums[i]),  mins[i - 1] * nums[i]);
            ans = Math.max(ans, maxs[i]);
        }
        return ans;
    }
}