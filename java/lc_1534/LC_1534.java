package lc_1534;

/*
 *@author: 黄豪
 *@date : 2021年12月2日
 *@todo:1534. 统计好三元组
给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。

如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。

0 <= i < j < k < arr.length
|arr[i] - arr[j]| <= a
|arr[j] - arr[k]| <= b
|arr[i] - arr[k]| <= c
其中 |x| 表示 x 的绝对值。

返回 好三元组的数量 。

 
*/
public class LC_1534 {

}
//暴力
class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int n = arr.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++){
            for (int j = i + 1; j < n - 1; j++){
                if (!(Math.abs(arr[i] - arr[j]) <= a)) continue;
                for (int k = j + 1;k < n; k++){
                    if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) ans++;
                }
            }
        }
        return ans;
    }
}
