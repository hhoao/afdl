package lc_3072;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC_3072
 * //给你一个下标从 1 开始、长度为 n 的整数数组 nums 。
 * //
 * // 现定义函数 greaterCount ，使得 greaterCount(arr, val) 返回数组 arr 中 严格大于 val 的元素数量。
 * //
 * // 你需要使用 n 次操作，将 nums 的所有元素分配到两个数组 arr1 和 arr2 中。在第一次操作中，将 nums[1] 追加到 arr1 。在第二
 * //次操作中，将 nums[2] 追加到 arr2 。之后，在第 i 次操作中：
 * //
 * //
 * // 如果 greaterCount(arr1, nums[i]) > greaterCount(arr2, nums[i]) ，将 nums[i] 追加到
 * //arr1 。
 * // 如果 greaterCount(arr1, nums[i]) < greaterCount(arr2, nums[i]) ，将 nums[i] 追加到
 * //arr2 。
 * // 如果 greaterCount(arr1, nums[i]) == greaterCount(arr2, nums[i]) ，将 nums[i] 追加到元
 * //素数量较少的数组中。
 * // 如果仍然相等，那么将 nums[i] 追加到 arr1 。
 * //
 * //
 * // 连接数组 arr1 和 arr2 形成数组 result 。例如，如果 arr1 == [1,2,3] 且 arr2 == [4,5,6] ，那么
 * //result = [1,2,3,4,5,6] 。
 * //
 * // 返回整数数组 result 。
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：nums = [2,1,3,3]
 * //输出：[2,3,1,3]
 * //解释：在前两次操作后，arr1 = [2] ，arr2 = [1] 。
 * //在第 3 次操作中，两个数组中大于 3 的元素数量都是零，并且长度相等，因此，将 nums[3] 追加到 arr1 。
 * //在第 4 次操作中，两个数组中大于 3 的元素数量都是零，但 arr2 的长度较小，因此，将 nums[4] 追加到 arr2 。
 * //在 4 次操作后，arr1 = [2,3] ，arr2 = [1,3] 。
 * //因此，连接形成的数组 result 是 [2,3,1,3] 。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：nums = [5,14,3,1,2]
 * //输出：[5,3,1,2,14]
 * //解释：在前两次操作后，arr1 = [5] ，arr2 = [14] 。
 * //在第 3 次操作中，两个数组中大于 3 的元素数量都是一，并且长度相等，因此，将 nums[3] 追加到 arr1 。
 * //在第 4 次操作中，arr1 中大于 1 的元素数量大于 arr2 中的数量（2 > 1），因此，将 nums[4] 追加到 arr1 。
 * //在第 5 次操作中，arr1 中大于 2 的元素数量大于 arr2 中的数量（2 > 1），因此，将 nums[5] 追加到 arr1 。
 * //在 5 次操作后，arr1 = [5,3,1,2] ，arr2 = [14] 。
 * //因此，连接形成的数组 result 是 [5,3,1,2,14] 。
 * //
 * //
 * // 示例 3：
 * //
 * //
 * //输入：nums = [3,3,3,3]
 * //输出：[3,3,3,3]
 * //解释：在 4 次操作后，arr1 = [3,3] ，arr2 = [3,3] 。
 * //因此，连接形成的数组 result 是 [3,3,3,3] 。
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // 3 <= n <= 10⁵
 * // 1 <= nums[i] <= 10⁹
 * //
 * //
 * // Related Topics 树状数组 线段树 数组 模拟 👍 39 👎 0
 * @author xianxing
 * @since 2024/6/5
 **/

public class LC_3072 {
}

class BinaryIndexedTree {
    private int[] tree;

    public BinaryIndexedTree(int n) {
        tree = new int[n + 1];
    }

    public void add(int i) {
        while (i < tree.length) {
            tree[i]++;
            i += i & -i;
        }
    }

    public int get(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & -i;
        }
        return sum;
    }
}

class Solution {
    public int[] resultArray(int[] nums) {
        int n = nums.length;
        int[] sortedNums = Arrays.copyOf(nums, n);
        Arrays.sort(sortedNums);

        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < n; i++) {
            index.put(sortedNums[i], i + 1);
        }

        List<Integer> arr1 = new ArrayList<>(List.of(nums[0]));
        List<Integer> arr2 = new ArrayList<>(List.of(nums[1]));
        BinaryIndexedTree tree1 = new BinaryIndexedTree(n);
        BinaryIndexedTree tree2 = new BinaryIndexedTree(n);
        tree1.add(index.get(nums[0]));
        tree2.add(index.get(nums[1]));

        for (int i = 2; i < n; i++) {
            int count1 = arr1.size() - tree1.get(index.get(nums[i]));
            int count2 = arr2.size() - tree2.get(index.get(nums[i]));
            if (count1 > count2 || (count1 == count2 && arr1.size() <= arr2.size())) {
                arr1.add(nums[i]);
                tree1.add(index.get(nums[i]));
            } else {
                arr2.add(nums[i]);
                tree2.add(index.get(nums[i]));
            }
        }

        int i = 0;
        for (int a: arr1) {
            nums[i++] = a;
        }
        for (int a: arr2) {
            nums[i++] = a;
        }
        return nums;
    }
}
