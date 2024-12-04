package lc_995;

/*
 *@author: 黄豪
 *@date : 2022年1月2日
 *@todo:995. K 连续位的最小翻转次数
在仅包含 0 和 1 的数组 A 中，一次 K 位翻转包括选择一个长度为 K 的（连续）子数组，同时将子数组中的每个 0 更改为 1，而每个 1 更改为 0。

返回所需的 K 位翻转的最小次数，以便数组没有值为 0 的元素。如果不可能，返回 -1。

 

示例 1：

输入：A = [0,1,0], K = 1
输出：2
解释：先翻转 A[0]，然后翻转 A[2]。
示例 2：

输入：A = [1,1,0], K = 2
输出：-1
解释：无论我们怎样翻转大小为 2 的子数组，我们都不能使数组变为 [1,1,1]。
*/
public class LC_995 {
	public static void main(String[] args) {
		new Solution().minKBitFlips(new int[] {0,0,0,1,0,1,1,0},3);
	}
}
//差分数组
class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
        	revCnt += diff[i];
            if ((nums[i] + revCnt) % 2 == 0) {
                if (i + k > n) {
                    return -1;
                }
                ++ans;
                ++revCnt;
                --diff[i + k];
            }
        }
        return ans;
    }
}
//滑动窗口
class Solution1 {
    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int ans = 0, revCnt = 0;
        for (int i = 0; i < n; ++i) {
            if (i >= k && nums[i - k] > 1) {
                revCnt ^= 1;
                nums[i - k] -= 2; // 复原数组元素，若允许修改数组 nums，则可以省略
            }
            if (nums[i] == revCnt) {
                if (i + k > n) {
                    return -1;
                }
                ++ans;
                revCnt ^= 1;
                nums[i] += 2;
            }
        }
        return ans;
    }
}
