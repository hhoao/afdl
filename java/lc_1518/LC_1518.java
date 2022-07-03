package lc_1518;

/*
 *@author: 黄豪
 *@date : 2021年12月17日
 *@todo:1518. 换酒问题
小区便利店正在促销，用 numExchange 个空酒瓶可以兑换一瓶新酒。你购入了 numBottles 瓶酒。

如果喝掉了酒瓶中的酒，那么酒瓶就会变成空的。

请你计算 最多 能喝到多少瓶酒。
*/
public class LC_1518 {

}
//模拟
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        while (numBottles >= numExchange){
            ans += numBottles / numExchange;
            numBottles = numBottles / numExchange + numBottles % numExchange;
        }
        return ans;
    }
}
//数学
class Solution1 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int cnt = numBottles / (numExchange - 1);
        return (numBottles % (numExchange - 1) == 0) ? numBottles +  cnt - 1 : numBottles + cnt;
    }
}