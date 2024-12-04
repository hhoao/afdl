package lc_442;

import java.util.ArrayList;
import java.util.List;

/**
 * LC_442
 *
 * @author xianxing
 * @since 2024/6/10
 **/

public class LC_442 {
}

//给你一个长度为 n 的整数数组 nums ，其中 nums 的所有整数都在范围 [1, n] 内，且每个整数出现 一次 或 两次 。请你找出所有出现 两次
//的整数，并以数组形式返回。
//
// 你必须设计并实现一个时间复杂度为 O(n) 且仅使用常量额外空间的算法解决此问题。
//
//
//
// 示例 1：
//
//
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[2,3]
//
//
// 示例 2：
//
//
//输入：nums = [1,1,2]
//输出：[1]
//
//
// 示例 3：
//
//
//输入：nums = [1]
//输出：[]
//
//
//
//
// 提示：
//
//
// n == nums.length
// 1 <= n <= 10⁵
// 1 <= nums[i] <= n
// nums 中的每个元素出现 一次 或 两次
//
//
// Related Topics 数组 哈希表 👍 777 👎 0

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        boolean[] visited = new boolean[nums.length +1];
        ArrayList<Integer> res = new ArrayList<>();
        for (int num : nums) {
            if (visited[num]) {
                res.add(num);
            }
            visited[num] = true;
        }
        return res;
    }
}
