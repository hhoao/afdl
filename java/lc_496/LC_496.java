package lc_496;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/*
 *@author: 黄豪
 *@date : 2022年1月22日
 *@todo:496. 下一个更大元素 I
nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。

给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。

对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。

返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。

 

示例 1：

输入：nums1 = [4,1,2], nums2 = [1,3,4,2].
输出：[-1,3,-1]
解释：nums1 中每个值的下一个更大元素如下所述：
- 4 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
- 1 ，用加粗斜体标识，nums2 = [1,3,4,2]。下一个更大元素是 3 。
- 2 ，用加粗斜体标识，nums2 = [1,3,4,2]。不存在下一个更大元素，所以答案是 -1 。
示例 2：

输入：nums1 = [2,4], nums2 = [1,2,3,4].
输出：[3,-1]
解释：nums1 中每个值的下一个更大元素如下所述：
- 2 ，用加粗斜体标识，nums2 = [1,2,3,4]。下一个更大元素是 3 。
- 4 ，用加粗斜体标识，nums2 = [1,2,3,4]。不存在下一个更大元素，所以答案是 -1 。
*/
public class LC_496 {

}
//单调栈+桶
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(nums2[0]);
        int[] f = new int[10001];
        for (int i = 1; i < m; i++){
            while (!deque.isEmpty() && nums2[i] > deque.peek()){
                f[deque.pop()] = nums2[i];
            }
            deque.push(nums2[i]);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            ans[i] = f[nums1[i]] != 0 ? f[nums1[i]] : -1;
        }
        return ans;
    }
}

//单调栈+哈希表
class Solution1 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        Deque<Integer> deque = new ArrayDeque<>();
        deque.offer(nums2[0]);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < m; i++){
            while (!deque.isEmpty() && nums2[i] > deque.peek()){
                map.put(deque.pop(), nums2[i]);
            }
            deque.push(nums2[i]);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++){
            Integer nextEle = map.get(nums1[i]);
            ans[i] = nextEle != null ? nextEle : -1;
        }
        return ans;
    }
}