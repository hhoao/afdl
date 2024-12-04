package lc_1094;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 *@author: 黄豪
 *@date : 2022年1月9日
 *@todo:1094. 拼车
假设你是一位顺风车司机，车上最初有 capacity 个空座位可以用来载客。由于道路的限制，车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向，你可以将其想象为一个向量）。

这儿有一份乘客行程计划表 trips[][]，其中 trips[i] = [num_passengers, start_location, end_location] 包含了第 i 组乘客的行程信息：

必须接送的乘客数量；
乘客的上车地点；
以及乘客的下车地点。
这些给出的地点位置是从你的 初始 出发位置向前行驶到这些地点所需的距离（它们一定在你的行驶方向上）。

请你根据给出的行程计划表和车子的座位数，来判断你的车是否可以顺利完成接送所有乘客的任务（当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false）。
*/
public class LC_1094 {

}
//我的差分数组
class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int[] s = new int[1001];
        
        Arrays.sort(trips, (a, b) -> a[1] - b[1]);
        int curS = 0;
        for (int i = 0; i < n; i++){
            while (curS < trips[i][1]){
                curS++;
                if (curS > 0) s[curS] += s[curS - 1];
            }
            s[curS] += trips[i][0];
            s[trips[i][2]] -= trips[i][0];
            if (s[curS] > capacity) return false;
        }
        return true;
    }
}
//官方差分
class Solution1 {
    public boolean carPooling(int[][] trips, int capacity) {
        int m = trips.length;
        int max = 0;
        // 找到最远的站点
        for(int[] trip : trips){
            max = Math.max(trip[2], max);
        }
        int[] diff = new int[max + 1];
        for(int i = 0; i < m; i++){
            int np = trips[i][0];
            int sl = trips[i][1];
            int el = trips[i][2];
            // 上车
            diff[sl] += np;
            // 下车
            diff[el] -=  np;
        }
        int start = diff[0];
        if(start > capacity) return false;
        // 判断每一时刻下的乘客数量
        for(int i = 1; i <= max; i++){
            start = start + diff[i];
            if(start > capacity) return false;
        }
        return true;
    }
}
//小顶堆
class Solution2 {
    public boolean carPooling(int[][] trips, int capacity) {
        //创建一个以下车顺序的小根堆
        PriorityQueue<int[]> heap=new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        //对上车顺序排序
        Arrays.sort(trips, Comparator.comparingInt(o -> o[1]));
        for (int[] trip : trips) {
            //先上车
            capacity -= trip[0];
            //车位不够就下车
            if (capacity < 0) {
                while (!heap.isEmpty() && heap.peek()[2] <= trip[1]) capacity += heap.poll()[0];//能下的都下完
                if (capacity < 0) return false;//能下完的 下完还不行就返回
            }
            //加到堆里面
            heap.offer(trip);
        }
        return true;
}
}
