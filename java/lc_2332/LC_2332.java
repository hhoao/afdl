package lc_2332;


import java.util.ArrayDeque;
import java.util.Arrays;

/**
 * LC_2332
 *
 * @author w
 * @since 2024/9/18
 **/

//题目: [2332] 坐上公交的最晚时间
//时间: 2024-09-18 21:42:44
//
//给你一个下标从 0 开始长度为 n 的整数数组 buses ，其中 buses[i] 表示第 i 辆公交车的出发时间。同时给你一个下标从 0 开始长度为
//m 的整数数组 passengers ，其中 passengers[j] 表示第 j 位乘客的到达时间。所有公交车出发的时间互不相同，所有乘客到达的时间也互不相同
//。
//
// 给你一个整数 capacity ，表示每辆公交车 最多 能容纳的乘客数目。
//
// 每位乘客都会搭乘下一辆有座位的公交车。如果你在 y 时刻到达，公交在 x 时刻出发，满足 y <= x 且公交没有满，那么你可以搭乘这一辆公交。最早 到达
//的乘客优先上车。
//
// 返回你可以搭乘公交车的最晚到达公交站时间。你 不能 跟别的乘客同时刻到达。
//
// 注意：数组 buses 和 passengers 不一定是有序的。
//
//
//
// 示例 1：
//
// 输入：buses = [10,20], passengers = [2,17,18,19], capacity = 2
//输出：16
//解释：
//第 1 辆公交车载着第 1 位乘客。
//第 2 辆公交车载着你和第 2 位乘客。
//注意你不能跟其他乘客同一时间到达，所以你必须在第二位乘客之前到达。
//
// 示例 2：
//
// 输入：buses = [20,30,10], passengers = [19,13,26,4,25,11,21], capacity = 2
//输出：20
//解释：
//第 1 辆公交车载着第 4 位乘客。
//第 2 辆公交车载着第 6 位和第 2 位乘客。
//第 3 辆公交车载着第 1 位乘客和你。
//
//
//
//
// 提示：
//
//
// n == buses.length
// m == passengers.length
// 1 <= n, m, capacity <= 10⁵
// 2 <= buses[i], passengers[i] <= 10⁹
// buses 中的元素 互不相同 。
// passengers 中的元素 互不相同 。
//
//
// 👍 77 👎 0
public class LC_2332 {
}

// 最晚的意思也就是比最后一位前一位
// 我们可以每放上一位乘客就将最晚时间设置它的前一位，如果前一位有人，那就设置为前前一位
// 如果最后一个公交车没有坐满人，那么可以设置为最后一辆公交车的时间
// 是否可以使用栈记录 passengers, 可以的
// 但是如果公交车没有满怎么办，分两种情况:
// 第一种情况：如果是最后一辆公交车没有满，那我们查看栈顶的乘客到达时间是否为 最后一辆公交车的到达时间
//           如果是，那么正常 pop 栈，如果不是，则将答案设置为最后一辆公交车的到达时间
// 第二种情况： 如果不是最后一辆公交车没有满，那么我们正常 pop 栈
// 所以我们只需要记录最后一辆公交车有没有满
class Solution {
    public int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(passengers);
        Arrays.sort(buses);
        int i = 0;
        ArrayDeque<Integer> passengersDeque  = new ArrayDeque<>();

        for (int j = 0; j < buses.length; j++) {
            int bus = buses[j];
            int curBusCapacity = capacity;
            while (i < passengers.length && passengers[i] <= bus && curBusCapacity > 0) {
                passengersDeque.push(passengers[i]);
                curBusCapacity--;
                i++;
            }
            if (curBusCapacity > 0 && j == buses.length - 1) {
                if (passengersDeque.isEmpty() || passengersDeque.peek() != bus) {
                    return bus;
                }
            }
        }
        int lastPassenger = passengersDeque.pop();
        while (!passengersDeque.isEmpty() && lastPassenger - 1 == passengersDeque.peek()) {
            lastPassenger = passengersDeque.pop();
        }
        return lastPassenger - 1;
    }
}
