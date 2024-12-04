package lc_765;

/*
 *@author: 黄豪
 *@date : 2021年12月18日
 *@todo:765. 情侣牵手
N 对情侣坐在连续排列的 2N 个座位上，想要牵到对方的手。 计算最少交换座位的次数，以便每对情侣可以并肩坐在一起。 一次交换可选择任意两人，让他们站起来交换座位。

人和座位用 0 到 2N-1 的整数表示，情侣们按顺序编号，第一对是 (0, 1)，第二对是 (2, 3)，以此类推，最后一对是 (2N-2, 2N-1)。

这些情侣的初始座位  row[i] 是由最初始坐在第 i 个座位上的人决定的。
*/
public class LC_765 {

}
class Solution {
    public int minSwapsCouples(int[] row) {
        int res=0;
        for(int i = 0; i < row.length; i+=2){
            int a = row[i];
            int b = a^1;
            if(row[i+1] == b)
                continue;
            for(int j = i + 1; j < row.length; ++j){
                if(row[j] == b){
                    int tmp = row[j];
                    row[j] = row[i + 1];
                    row[i + 1] = tmp;
                    ++res;
                    break;
                }
            }
        }
        return res;
    }
}
