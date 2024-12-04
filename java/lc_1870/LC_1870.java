package lc_1870;


import java.math.BigDecimal;
import java.util.Arrays;

/**
 * LC_1870
 *
 * @author w
 * @since 2024/10/2
 **/

public class LC_1870 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int i1 = solution.minSpeedOnTime(new int[]{1, 1, 100000}, 2.01);
//        int i1 = solution.minSpeedOnTime(new int[]{69}, 4.6);
        int i1 = solution.minSpeedOnTime(new int[]{8,4,1,2}, 3.9);
        System.out.println(i1);
    }
}


//题目: [1870] 准时到达的列车最小时速
//时间: 2024-10-02 09:41:04
//
//给你一个浮点数 hour ，表示你到达办公室可用的总通勤时间。要到达办公室，你必须按给定次序乘坐 n 趟列车。另给你一个长度为 n 的整数数组 dist ，
//其中 dist[i] 表示第 i 趟列车的行驶距离（单位是千米）。
//
// 每趟列车均只能在整点发车，所以你可能需要在两趟列车之间等待一段时间。
//
//
// 例如，第 1 趟列车需要 1.5 小时，那你必须再等待 0.5 小时，搭乘在第 2 小时发车的第 2 趟列车。
//
//
// 返回能满足你准时到达办公室所要求全部列车的 最小正整数 时速（单位：千米每小时），如果无法准时到达，则返回 -1 。
//
// 生成的测试用例保证答案不超过 10⁷ ，且 hour 的 小数点后最多存在两位数字 。
//
//
//
// 示例 1：
//
//
//输入：dist = [1,3,2], hour = 6
//输出：1
//解释：速度为 1 时：
//- 第 1 趟列车运行需要 1/1 = 1 小时。
//- 由于是在整数时间到达，可以立即换乘在第 1 小时发车的列车。第 2 趟列车运行需要 3/1 = 3 小时。
//- 由于是在整数时间到达，可以立即换乘在第 4 小时发车的列车。第 3 趟列车运行需要 2/1 = 2 小时。
//- 你将会恰好在第 6 小时到达。
//
//
// 示例 2：
//
//
//输入：dist = [1,3,2], hour = 2.7
//输出：3
//解释：速度为 3 时：
//- 第 1 趟列车运行需要 1/3 = 0.33333 小时。
//- 由于不是在整数时间到达，故需要等待至第 1 小时才能搭乘列车。第 2 趟列车运行需要 3/3 = 1 小时。
//- 由于是在整数时间到达，可以立即换乘在第 2 小时发车的列车。第 3 趟列车运行需要 2/3 = 0.66667 小时。
//- 你将会在第 2.66667 小时到达。
//
// 示例 3：
//
//
//输入：dist = [1,3,2], hour = 1.9
//输出：-1
//解释：不可能准时到达，因为第 3 趟列车最早是在第 2 小时发车。
//
//
//
// 提示：
//
//
// n == dist.length
// 1 <= n <= 10⁵
// 1 <= dist[i] <= 10⁵
// 1 <= hour <= 10⁹
// hours 中，小数点后最多存在两位数字
//
//
// 👍 78 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int sum = dist[0], max = dist[0];
        for (int i = 1; i < dist.length; i++) {
            sum += dist[i];
            max = Math.max(dist[i], max);
        }
        max = Math.max((int) Math.ceil(dist[dist.length - 1] / (hour - Math.floor(hour))), max);
        int l = (int) Math.ceil((double) sum * 100 / Math.round(hour * 100));
        int r = max;
        while (l < r) {
            int midV = l + (r - l) / 2;
            if (calSpendTime(midV, dist) > hour) {
                l = midV + 1;
            } else {
                r = midV;
            }
        }
        if (l == max) {
            double time = calSpendTime(l, dist);
            return time <= hour ? l : -1;
        } else if (l > max){
            return -1;
        } else {
            return l;
        }
    }
    public double calSpendTime(int v, int[] dist) {
        double time = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            int j = dist[i];
            time += Math.ceil((double) j / v);
        }
        time += (double) dist[dist.length - 1] / v;
        return time;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
