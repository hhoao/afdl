package lc_539;

import java.util.Arrays;
import java.util.List;

/*
 *@author: 黄豪
 *@date : 2022年1月18日
 *@todo:539. 最小时间差
给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。

 

示例 1：

输入：timePoints = ["23:59","00:00"]
输出：1
示例 2：

输入：timePoints = ["00:00","23:59","00:00"]
输出：0
*/
public class LC_539 {

}
class Solution {
    public int findMinDifference(List<String> timePoints) {
        int n = timePoints.size();
        int[] f = new int[2 * n];
        for (int i = 0; i < n; i++){
            String[] tis = timePoints.get(i).split(":");
            f[i] = Integer.valueOf(tis[0]) * 60 + Integer.valueOf(tis[1]);
            f[n + i] = 24 * 60 + f[i];
        }
        Arrays.sort(f);
        int ans = 2147483647;
        for (int i = 1; i < 2 * n; i++){
            ans = Math.min(ans, f[i] - f[i - 1]);
        }
        return ans;
    }
}