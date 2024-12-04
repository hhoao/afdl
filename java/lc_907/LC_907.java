package lc_907;

import java.util.ArrayDeque;
import java.util.Deque;

/*
 *@author: 黄豪
 *@date : 2022年1月25日
 *@todo:907. 子数组的最小值之和
给定一个整数数组 arr，找到 min(b) 的总和，其中 b 的范围为 arr 的每个（连续）子数组。

由于答案可能很大，因此 返回答案模 10^9 + 7 。

 

示例 1：

输入：arr = [3,1,2,4]
输出：17
解释：
子数组为 [3]，[1]，[2]，[4]，[3,1]，[1,2]，[2,4]，[3,1,2]，[1,2,4]，[3,1,2,4]。 
最小值为 3，1，2，4，1，1，2，1，1，1，和为 17。
示例 2：

输入：arr = [11,81,94,43,3]
输出：444
*/
public class LC_907 {
	public static void main(String[] args) {
		System.out.println(new Solution1().sumSubarrayMins(new int[] {3, 1, 2, 4}));
	}
}
//暴力超时
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long ans = 0;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j <= n - i; j++){
                int min = Integer.MAX_VALUE;
                for (int k = j; k < j + i; k++){	
                    min = Math.min(min, arr[k]);
                }
                ans += min;
                ans %= (1e+9 + 7);
            }
        }
        return (int)ans;
    }
}
//单调栈
class Solution1 {
	static final long MOD = 1000000000 + 7;
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        Deque<Integer> stack = new ArrayDeque<>();
        long ans = 0;
        int[] arr1 = new int[n + 2];
        arr1[0] = -1;
        arr1[n+1] = -1;
        System.arraycopy(arr, 0, arr1, 1, n);
        arr = arr1;
        for (int i = 0; i < n+2; i++){
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]){
                int curMinIndex = stack.pop();
                ans = (ans + (long)(arr[curMinIndex] * (i - curMinIndex)) * (curMinIndex - (stack.isEmpty() ? -1 : stack.peek()))) % MOD;
            }
            stack.push(i);
        }
        return (int)ans;
    }
}
