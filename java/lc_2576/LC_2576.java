package lc_2576;

import com.sun.source.tree.Tree;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * LC_2576
 *
 * @author w
 * @since 2024/9/12
 **/

//给你一个下标从 0 开始的整数数组 nums 。
//
//一开始，所有下标都没有被标记。你可以执行以下操作任意次：
//
//选择两个 互不相同且未标记 的下标 i 和 j ，满足 2 * nums[i] <= nums[j] ，标记下标 i 和 j 。
//请你执行上述操作任意次，返回 nums 中最多可以标记的下标数目。
//
//示例 1：
//
//输入：nums = [3,5,2,4]
//输出：2
//解释：第一次操作中，选择 i = 2 和 j = 1 ，操作可以执行的原因是 2 * nums[2] <= nums[1] ，标记下标 2 和 1 。
//没有其他更多可执行的操作，所以答案为 2 。
//示例 2：
//
//输入：nums = [9,2,5,4]
//输出：4
//解释：第一次操作中，选择 i = 3 和 j = 0 ，操作可以执行的原因是 2 * nums[3] <= nums[0] ，标记下标 3 和 0 。
//第二次操作中，选择 i = 1 和 j = 2 ，操作可以执行的原因是 2 * nums[1] <= nums[2] ，标记下标 1 和 2 。
//没有其他更多可执行的操作，所以答案为 4 。
//示例 3：
//
//输入：nums = [7,6,8]
//输出：0
//解释：没有任何可以执行的操作，所以答案为 0 。
//提示：
//
//1 <= nums.length <= 105
//1 <= nums[i] <= 109
//👍 108
//👎 0
public class LC_2576 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int i = solution.maxNumOfMarkedIndices(new int[]{3, 5, 2, 4});
        int i = solution.maxNumOfMarkedIndices(new int[]{9,2,5,4});
        System.out.println(i);
    }
}

class Solution {
    public int maxNumOfMarkedIndices(int[] nums) {
        Arrays.sort(nums);
        TreeMap<Integer, Integer> numIndexMap = new TreeMap<>();
        int ans = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            Map.Entry<Integer, Integer> ceilingEntry = numIndexMap.ceilingEntry(num * 2);
            if (ceilingEntry != null && ceilingEntry.getValue() > 0) {
                ans += 2;
                numIndexMap.put(ceilingEntry.getKey(), ceilingEntry.getValue() - 1);
            } else {
                numIndexMap.compute(num, (k, v) -> {
                    if (v == null) {
                        return 1;
                    } else {
                        return ++v;
                    }
                });
            }
        }
        return ans;
    }
}
