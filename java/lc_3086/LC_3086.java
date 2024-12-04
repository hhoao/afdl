//package lc_3086;
//
///**
// * LC_3086
// *
// * @author xianxing
// * @since 2024/7/8
// **/
//
//public class LC_3086 {
//}
//
//// 问题的关键在于 aliceIndex 取何值。
//// aliceIndex 取何值取决于拾取k次的最少行动次数。
//// maxChanges 相当于行动两次换取一次拾取。
//// 只有旁边为 1 才比 maxChanges 更有性价比。
//// 如果选择靠近左边的，那么左边 1 所需要的行动次数将全部减 1。
//// 行动次数 = (选择1 ? 1 ：0) + 使用 maxChanges 次数 * 2
////           + 依次离aliceIndex最近的 1 的下标之和。
//// k = 使用maxChanges次数 + (选择1 ？1 : 0) + 选择的下标数量。
//// 先计算所有1的数量，并计算所有数需要的行动力。
//// 然后从第一个数开始遍历，中间一直维护左边1的个数。
//// 每次往右边移动一点，那么左边的所有1所需要的行动力加一，也就是加上左边数
//// 的个数，同样右边需要的行动力将减去右边所有数的个数，期间计算相应的行动次数
//// 以及是否能达到k。
//// 同时维护一个栈，如果左边的数
//// 答案等于每次计算的行动次数的最小值。
////
//class Solution {
//    public long minimumMoves(int[] nums, int k, int maxChanges) {
//        int n = nums.length;
//        int actions = 0;
//        int left = 0, right = 0;
//        for (int i = 0; i < n; i++) {
//            if (nums[i] == 1) {
//                actions += i;
//                right += 1;
//            }
//        }
//        for (int i = 0;i < n; i++) {
//            if (nums[i] == 1) {
//
//            }
//        }
//    }
//}
