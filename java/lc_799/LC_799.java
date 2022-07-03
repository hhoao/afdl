package lc_799;

/*
 *@author: 黄豪
 *@date : 2021年9月30日
 *@todo:799. 香槟塔
我们把玻璃杯摆成金字塔的形状，其中第一层有1个玻璃杯，第二层有2个，依次类推到第100层，每个玻璃杯(250ml)将盛有香槟。

从顶层的第一个玻璃杯开始倾倒一些香槟，当顶层的杯子满了，任何溢出的香槟都会立刻等流量的流向左右两侧的玻璃杯。当左右两边的杯子也满了，就会等流量的流向它们左右两边的杯子，依次类推。（当最底层的玻璃杯满了，香槟会流到地板上）

例如，在倾倒一杯香槟后，最顶层的玻璃杯满了。倾倒了两杯香槟后，第二层的两个玻璃杯各自盛放一半的香槟。在倒三杯香槟后，第二层的香槟满了 - 此时总共有三个满的玻璃杯。在倒第四杯后，第三层中间的玻璃杯盛放了一半的香槟，他两边的玻璃杯各自盛放了四分之一的香槟，如下图所示。



现在当倾倒了非负整数杯香槟后，返回第 i 行 j 个玻璃杯所盛放的香槟占玻璃杯容积的比例（i 和 j都从0开始）。
*/
public class LC_799 {

}
class Solution {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[][] champagnes = new double[102][102];
        champagnes[0][0] = poured;
        for (int i = 0; i <= query_row; i++){
            for (int j = 0; j <= i; j++){
                double extra = (champagnes[i][j] - 1.0 )/ 2.0;
                if (extra > 0){
                    champagnes[i+1][j] += extra;
                    champagnes[i+1][j+1] += extra;
                }
            }
        }
        return Math.min(1.0, champagnes[query_row][query_glass]);
    }
}