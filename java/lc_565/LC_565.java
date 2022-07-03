package lc_565;

/*
 *@author: 黄豪
 *@date : 2021年12月20日
 *@todo:565. 数组嵌套
索引从0开始长度为N的数组A，包含0到N - 1的所有整数。找到最大的集合S并返回其大小，其中 S[i] = {A[i], A[A[i]], A[A[A[i]]], ... }且遵守以下的规则。

假设选择索引为i的元素A[i]为S的第一个元素，S的下一个元素应该是A[A[i]]，之后是A[A[A[i]]]... 以此类推，不断添加直到S出现重复的元素。
*/
public class LC_565 {
}
//快慢指针
class Solution {
    public int arrayNesting(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n];
        int ret = 0;
        for (int i = 0; i < n; i++){
            if (vis[nums[i]]){
                continue;
            }
            vis[i] = true;
            int l = i, q = i;
            int s1 = 1;
            while(true){
                l = nums[l];
                q = nums[q];
                vis[q] = true;
                q = nums[q];
                vis[q] = true;
                if (l == q) {
                    break;
                }
                s1++;
            }
            ret = Math.max(ret, s1);
        }
        return ret;
    }
}
//不使用额外空间
class Solution1 {
    public int arrayNesting(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != Integer.MAX_VALUE) {
                int start = nums[i], count = 0;
                while (nums[start] != Integer.MAX_VALUE) {
                    int temp = start;
                    start = nums[start];
                    count++;
                    nums[temp] = Integer.MAX_VALUE;
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}
//官方
class Solution2 {
    public int arrayNesting(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                int start = nums[i], count = 0;
                do {
                    start = nums[start];
                    count++;
                    visited[start] = true;
                }
                while (start != nums[i]);
                res = Math.max(res, count);
            }
        }
        return res;
    }
}