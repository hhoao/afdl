package lc_1926;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * LC_1926
 * //给你一个 m x n 的迷宫矩阵 maze （下标从 0 开始），矩阵中有空格子（用 '.' 表示）和墙（用 '+' 表示）。同时给你迷宫的入口
 * //entrance ，用 entrance = [entrancerow, entrancecol] 表示你一开始所在格子的行和列。
 * //
 * // 每一步操作，你可以往 上，下，左 或者 右 移动一个格子。你不能进入墙所在的格子，你也不能离开迷宫。你的目标是找到离 entrance 最近 的出口。出口
 * // 的含义是 maze 边界 上的 空格子。entrance 格子 不算 出口。
 * //
 * // 请你返回从 entrance 到最近出口的最短路径的 步数 ，如果不存在这样的路径，请你返回 -1 。
 * //
 * //
 * //
 * // 示例 1：
 * // 输入：maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance =
 * // [1,2]
 * //输出：1
 * //解释：总共有 3 个出口，分别位于 (1,0)，(0,2) 和 (2,3) 。
 * //一开始，你在入口格子 (1,2) 处。
 * //- 你可以往左移动 2 步到达 (1,0) 。
 * //- 你可以往上移动 1 步到达 (0,2) 。
 * //从入口处没法到达 (2,3) 。
 * //所以，最近的出口是 (0,2) ，距离为 1 步。
 * //
 * //
 * // 示例 2：
 * // 输入：maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
 * //输出：2
 * //解释：迷宫中只有 1 个出口，在 (1,2) 处。
 * //(1,0) 不算出口，因为它是入口格子。
 * //初始时，你在入口与格子 (1,0) 处。
 * //- 你可以往右移动 2 步到达 (1,2) 处。
 * //所以，最近的出口为 (1,2) ，距离为 2 步。
 * //
 * //
 * // 示例 3：
 * // 输入：maze = [[".","+"]], entrance = [0,0]
 * //输出：-1
 * //解释：这个迷宫中没有出口。
 * //
 * //
 * //
 * //
 * // 提示：
 * //
 * //
 * // maze.length == m
 * // maze[i].length == n
 * // 1 <= m, n <= 100
 * // maze[i][j] 要么是 '.' ，要么是 '+' 。
 * // entrance.length == 2
 * // 0 <= entrancerow < m
 * // 0 <= entrancecol < n
 * // entrance 一定是空格子。
 * //
 * //
 * // Related Topics 广度优先搜索 数组 矩阵 👍 92 👎 0
 * @author xianxing
 * @since 2024/5/25
 **/

public class LC_1926 {
}

class Solution {
    static int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length, n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        visited[entrance[0]][entrance[1]] = true;
        Queue<int[]> queue = new ArrayDeque<int[]>();
        queue.offer(entrance);
        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int row = cell[0], col = cell[1];
                for (int[] dir : dirs) {
                    int newRow = row + dir[0], newCol = col + dir[1];
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol] && maze[newRow][newCol] == '.') {
                        if (newRow == 0 || newRow == m - 1 || newCol == 0 || newCol == n - 1) {
                            return steps;
                        }
                        visited[newRow][newCol] = true;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }
        return -1;
    }
}

class Solution1 {
    private final int[][] positions = new int[][] {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length, m = maze[0].length;
        boolean[][] visited = new boolean[n][m];
        visited[entrance[0]][entrance[1]] = true;
        int position = findPosition(visited, maze, entrance, entrance[0], entrance[1]);
        return position == 10000 ? -1 : position - 1;
    }
    private int findPosition(boolean[][] visited, char[][] maze, int[] entrance, int x, int y) {
        int n = maze.length, m = maze[0].length;
        if ((x == n - 1 || x == 0 || y == m - 1 || y == 0) && (x != entrance[0] || y != entrance[1])) {
            return 1;
        }
        int min =10000;
        for (int[] position : positions) {
            int dx = x + position[0];
            int dy = y + position[1];
            if (dx == -1 || dx >= n || dy == -1 || dy >= m) {
                continue;
            }
            if (visited[dx][dy]) {
                continue;
            }
            if (maze[dx][dy] == '.') {
                visited[dx][dy] = true;
                min = Math.min(findPosition(visited, maze, entrance, dx, dy) + 1, min);
                visited[dx][dy] = false;
            }
        }
        return min;
    }
}
