package lc_807;

import java.util.Arrays;

/**
 * LC_807
 *
 * @author xianxing
 * @since 2024/7/14
 **/

/*
给你一座由 n x n 个街区组成的城市，每个街区都包含一座立方体建筑。给你一个下标从 0 开始的 n x n 整数矩阵 grid ，其中 grid[r][c] 表示坐落于 r 行 c 列的建筑物的 高度 。

城市的 天际线 是从远处观察城市时，所有建筑物形成的外部轮廓。从东、南、西、北四个主要方向观测到的 天际线 可能不同。

我们被允许为 任意数量的建筑物 的高度增加 任意增量（不同建筑物的增量可能不同） 。 高度为 0 的建筑物的高度也可以增加。然而，增加的建筑物高度 不能影响 从任何主要方向观察城市得到的 天际线 。

在 不改变 从任何主要方向观测到的城市 天际线 的前提下，返回建筑物可以增加的 最大高度增量总和 。
 */
public class LC_807 {
}


// 如果需要从四个面看过去都一样，也就是四个面中每一列的最高高度一样
// 其中北和南、西和东可以归为一面，因为对应两面如果每列最大高度改变
// 都会影响另外一面
// 我们可以尝试记录西和北两面的各个列的最大高度，
// 遍历所有建筑，开始添加高度，先获取该建筑西北两面的最大高度中的最小高度，
// 再将当前高度添加到该最小高度
class Solution {
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        int[] westMaxHeight = new int[grid.length];
        int[] northMaxHeight = new int[grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                northMaxHeight[j] = Math.max(northMaxHeight[j], grid[i][j]);
                westMaxHeight[i] = Math.max(westMaxHeight[i], grid[i][j]);
            }
        }

        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                int maxHeight = Math.min(northMaxHeight[j], westMaxHeight[i]);
                ans += maxHeight - grid[i][j];
            }
        }
        return ans;
    }
}


