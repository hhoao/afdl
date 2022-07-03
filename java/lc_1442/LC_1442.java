package lc_1442;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: 黄豪
 *@date : 2022年1月18日
 *@todo:	1442. 形成两个异或相等数组的三元组数目
给你一个整数数组 arr 。

现需要从数组中取三个下标 i、j 和 k ，其中 (0 <= i < j <= k < arr.length) 。

a 和 b 定义如下：

a = arr[i] ^ arr[i + 1] ^ ... ^ arr[j - 1]
b = arr[j] ^ arr[j + 1] ^ ... ^ arr[k]
注意：^ 表示 按位异或 操作。

请返回能够令 a == b 成立的三元组 (i, j , k) 的数目。

 

示例 1：

输入：arr = [2,3,1,6,7]
输出：4
解释：满足题意的三元组分别是 (0,1,2), (0,2,2), (2,3,4) 以及 (2,4,4)
示例 2：

输入：arr = [1,1,1,1,1]
输出：10
*/
public class LC_1442 {

}
//三重循环
class Solution {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++){
            pre[i] = pre[i - 1] ^ arr[i - 1];
        }
        for (int i = 1; i <= n; i++){
            for (int k = i + 1; k <= n; k++){
                for (int j = i + 1; j <= k; j++){
                    if ((pre[j - 1] ^ pre[i - 1]) == (pre[k] ^ pre[j-1])){
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
}
//二重循环
class Solution1 {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        int ans = 0;
        int[] pre = new int[n + 1];
        for (int i = 1; i <= n; i++){
            pre[i] = pre[i - 1] ^ arr[i - 1];
        }
        for (int i = 0; i < n; i++){    
            for (int k = i+1; k < n; k++){
                if (pre[i] == pre[k+1]){
                    ans += k - i;
                }
            }
        }
        return ans;
    }
}
//哈希表
class Solution2 {
    public int countTriplets(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> cnt = new HashMap<Integer, Integer>();
        Map<Integer, Integer> total = new HashMap<Integer, Integer>();
        int ans = 0, s = 0;
        for (int k = 0; k < n; ++k) {
            int val = arr[k];
            if (cnt.containsKey(s ^ val)) {
                ans += cnt.get(s ^ val) * k - total.get(s ^ val);
            }
            cnt.put(s, cnt.getOrDefault(s, 0) + 1);
            total.put(s, total.getOrDefault(s, 0) + k);
            s ^= val;
        }
        return ans;
    }
}