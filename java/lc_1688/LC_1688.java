package lc_1688;

/*
 *@author: 黄豪
 *@date : 2022年1月25日
 *@todo:
*/
public class LC_1688 {

}
//模拟
class Solution {
    public int numberOfMatches(int n) {
        int ans = 0;
        while (n > 1){
            ans+= n / 2;
            n = (n+1)/2;
        }
        return ans;
    }
}
//数学
class Solution1 {
    public int numberOfMatches(int n) {
        return n - 1;
    }
}