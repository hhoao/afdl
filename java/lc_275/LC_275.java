package lc_275;

/*
 *@author: 黄豪
 *@date : 2021年5月4日
 *@todo:275. H 指数 II
给定一位研究者论文被引用次数的数组（被引用次数是非负整数），数组已经按照 升序排列 。编写一个方法，计算出研究者的 h 指数。

h 指数的定义: “h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。（其余的 N - h 篇论文每篇被引用次数不多于 h 次。）"
*/
public class LC_275 {

}
//我的代码
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        if (citations[n - 1] == 0) return 0;
        int l = 0, r = n - 1;
        while (l <= r){
            int mid = (l + r + 1) >> 1;
            if (citations[mid] == n - mid){
                return n - mid;
            }
            if (citations[mid] > n - mid){
                r = mid - 1;
            }else{
                l = mid + 1;
            }
        }
        return n - l - 1;
    }
}
