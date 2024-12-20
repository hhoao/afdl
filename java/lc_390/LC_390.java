package lc_390;

/*
 *@author: 黄豪
 *@date : 2022年1月2日
 *@todo:390. 消除游戏
给定一个从1 到 n 排序的整数列表。
首先，从左到右，从第一个数字开始，每隔一个数字进行删除，直到列表的末尾。
第二步，在剩下的数字中，从右到左，从倒数第一个数字开始，每隔一个数字进行删除，直到列表开头。
我们不断重复这两步，从左到右和从右到左交替进行，直到只剩下一个数字。
返回长度为 n 的列表中，最后剩下的数字。
示例：

输入:
n = 9,
1 2 3 4 5 6 7 8 9
2 4 6 8
2 6
6

输出:
6
*/
public class LC_390 {

}
//模拟
class Solution {
    public int lastRemaining(int n) {
        int l = 1, r = n;
        int tier = 1;
        int spite = 1;
        while (l < r){
            l = tier == 1 ? l + spite : (r - spite - (r - l - spite) / (spite * 2) * spite * 2);
            r = tier == 0 ? r - spite : (l + (r - l) / (spite * 2) * spite * 2);
            tier = (tier +1) % 2;
            spite*=2;
        }
        return l;
    }
}
//官方模拟
class Solution1 {
    public int lastRemaining(int n) {
        int a1 = 1;
        int k = 0, cnt = n, step = 1;
        while (cnt > 1) {
            if (k % 2 == 0) { // 正向
                a1 = a1 + step;
            } else { // 反向
                a1 = (cnt % 2 == 0) ? a1 : a1 + step;
            }
            k++;
            cnt = cnt >> 1;
            step = step << 1;
        }
        return a1;
    }
}
