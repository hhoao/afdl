//package lc_2970;
//
///**
// * LC_2970
// *
// * @author xianxing
// * @since 2024/7/10
// **/
//
//public class LC_2970 {
//}
//
//class Solution {
//    public int incremovableSubarrayCount(int[] nums) {
//        int res = 0;
//        int lastMin = nums[0];
//        int count = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] > nums[i - 1]) {
//                lastMin = nums[i];
//                count++;
//                res += count;
//            } else {
//            }
//        }
//    }
//}
//
//class Solution1 {
//    public int incremovableSubarrayCount(int[] nums) {
//        int n = nums.length;
//        int res = 0;
//        int l = 1;
//        while (l < n && nums[l - 1] < nums[l]) {
//            l++;
//        }
//        res += l + (l < n ? 1 : 0);
//        for (int r = n - 2; r >= 0; r--) {
//            while (l > 0 && nums[l - 1] >= nums[r + 1]) {
//                l--;
//            }
//            res += l + (l <= r ? 1 : 0);
//            if (nums[r] >= nums[r + 1]) {
//                break;
//            }
//        }
//        return res;
//    }
//}
