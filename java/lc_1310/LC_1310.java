package lc_1310;

/*
 *@author: 黄豪
 *@date : 2022年1月17日
 *@todo:1310. 子数组异或查询
有一个正整数数组 arr，现给你一个对应的查询数组 queries，其中 queries[i] = [Li, Ri]。

对于每个查询 i，请你计算从 Li 到 Ri 的 XOR 值（即 arr[Li] xor arr[Li+1] xor ... xor arr[Ri]）作为本次查询的结果。

并返回一个包含给定查询 queries 所有结果的数组。
示例 1：

输入：arr = [1,3,4,8], queries = [[0,1],[1,2],[0,3],[3,3]]
输出：[2,7,14,8] 
解释：
数组中元素的二进制表示形式是：
1 = 0001 
3 = 0011 
4 = 0100 
8 = 1000 
查询的 XOR 值为：
[0,1] = 1 xor 3 = 2 
[1,2] = 3 xor 4 = 7 
[0,3] = 1 xor 3 xor 4 xor 8 = 14 
[3,3] = 8
*/
public class LC_1310 {

}
//前缀和
class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        int n = arr.length, m = queries.length;
        int[] xorA = new int[n+1];
        xorA[0] = arr[0];
        for (int i = 1; i < n; i++){
            xorA[i] = xorA[i - 1] ^ arr[i];
        }
        int[] ans = new int[m];
        for (int i = 0; i < m; i++){
            ans[i] = queries[i][0] > 0 ? xorA[queries[i][0] - 1] ^ xorA[queries[i][1]] : xorA[queries[i][1]];
        }
        return ans;
    }
}