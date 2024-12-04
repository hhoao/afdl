package lc_2848;


import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * LC_2848
 *
 * @author w
 * @since 2024/9/15
 **/

//题目: [2848] 与车相交的点
//时间: 2024-09-15 09:42:49
//
//给你一个下标从 0 开始的二维整数数组 nums 表示汽车停放在数轴上的坐标。对于任意下标 i，nums[i] = [starti, endi] ，其中
//starti 是第 i 辆车的起点，endi 是第 i 辆车的终点。
//
// 返回数轴上被车 任意部分 覆盖的整数点的数目。
//
//
//
// 示例 1：
//
//
//输入：nums = [[3,6],[1,5],[4,7]]
//输出：7
//解释：从 1 到 7 的所有点都至少与一辆车相交，因此答案为 7 。
//
//
// 示例 2：
//
//
//输入：nums = [[1,3],[5,8]]
//输出：7
//解释：1、2、3、5、6、7、8 共计 7 个点满足至少与一辆车相交，因此答案为 7 。
//
//
//
//
// 提示：
//
//
// 1 <= nums.length <= 100
// nums[i].length == 2
// 1 <= starti <= endi <= 100
//
//
// 👍 27 👎 0
public class LC_2848 {
}


class Solution {
    public int numberOfPoints(List<List<Integer>> nums) {
        Collections.sort(nums, Comparator.comparingInt(num -> num.get(0)));
        int ans = 0;
        int right = 0;
        for (List<Integer> num : nums) {
            if (num.get(0) > right) {
                ans += num.get(1) - num.get(0) + 1;
                right = num.get(1);
            } else {
                int i = num.get(1) - right;
                if (i > 0) {
                    ans += i;
                    right = num.get(1);
                }
            }
        }
        return ans;
    }
}


class Solution1 {
    public int numberOfPoints(List<List<Integer>> nums) {
        Collections.sort(nums, Comparator.comparingInt(num -> num.get(0)));
        int ans = 0;
        int right = 0;
        for (List<Integer> num : nums) {
            if (num.get(1) > right) {
                ans += Math.min(num.get(1) - right, num.get(1) - num.get(0) + 1);
                right = num.get(1);
            }
        }
        return ans;
    }
}

// 差分数组
class Solution2 {
    public int numberOfPoints(List<List<Integer>> nums) {
        int max = Integer.MIN_VALUE;
        for (List<Integer> num : nums) {
            max = Math.max(num.get(1), max);
        }
        int[] gapArray = new int[max + 1];
        for (List<Integer> num : nums) {
            gapArray[num.get(1) + 1]--;
            gapArray[num.get(0)]++;
        }
        int ans = 0;
        int count = 0;
        for (int i = 1; i <= max; i++) {
            count += gapArray[i];
            if (count > 0) {
                ans++;
            }
        }
        return ans;
    }
}
