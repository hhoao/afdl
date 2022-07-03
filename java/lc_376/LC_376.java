package lc_376;

/*
 *@author: 黄豪
 *@date : 2021年10月29日
 *@todo:376. 摆动序列
如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。

例如， [1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3) 是正负交替出现的。

相反，[1, 4, 7, 2, 5] 和 [1, 7, 4, 5, 5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。

给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
*/
public class LC_376 {
	public static void main(String[] args) {
		System.out.println(new Solution().wiggleMaxLength(new int[] {3,3,3,2,5}));
	}
}
class Solution {
    public int wiggleMaxLength(int[] nums) {
        int ans = 1, n = nums.length;
        int[] seq = new int[n - 1];
        int zeros = 0;
        int k = 0;
        for (int i = 1; i < n; i++){
            seq[i - 1] = nums[i] - nums[i - 1];
            zeros += seq[i - 1] == 0 ? 1 : 0;
            k = (seq[i - 1] != 0 && k == 0) ? seq[i - 1] : k;
        }
        
        if (n == 1 || zeros == n - 1) return 1;
        for (int i = 1; i < n - 1; i++){
            if ((seq[i] > 0 && k < 0) || (seq[i] < 0 && k > 0)){
                ans++;
                k = -k;
            }
        }
        return ans+1;
    }
}
//优化(贪心)
class Solution1 {
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length;
        if (n < 2) {
            return n;
        }
        int prevdiff = nums[1] - nums[0];
        int ret = prevdiff != 0 ? 2 : 1;
        for (int i = 2; i < n; i++) {
            int diff = nums[i] - nums[i - 1];
            if ((diff > 0 && prevdiff <= 0) || (diff < 0 && prevdiff >= 0)) {
                ret++;
                prevdiff = diff;
            }
        }
        return ret;
    }
}