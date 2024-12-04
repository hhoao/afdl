package lc_1559;

/**
 * LC_1559
 *
 * @author xianxing
 * @since 2024/7/3
 **/
//题目: [1559] 二维网格图中探测环
//时间: 2024-07-03 20:34:57
//
//给你一个二维字符网格数组 grid ，大小为 m x n ，你需要检查 grid 中是否存在 相同值 形成的环。
//
// 一个环是一条开始和结束于同一个格子的长度 大于等于 4 的路径。对于一个给定的格子，你可以移动到它上、下、左、右四个方向相邻的格子之一，可以移动的前提是这
//两个格子有 相同的值 。
//
// 同时，你也不能回到上一次移动时所在的格子。比方说，环 (1, 1) -> (1, 2) -> (1, 1) 是不合法的，因为从 (1, 2) 移动到 (1
//, 1) 回到了上一次移动时的格子。
//
// 如果 grid 中有相同值形成的环，请你返回 true ，否则返回 false 。
//
//
//
// 示例 1：
//
//
//
// 输入：grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a",
//"a","a"]]
//输出：true
//解释：如下图所示，有 2 个用不同颜色标出来的环：
//
//
//
// 示例 2：
//
//
//
// 输入：grid = [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c",
//"c","c"]]
//输出：true
//解释：如下图所示，只有高亮所示的一个合法环：
//
//
//
// 示例 3：
//
//
//
// 输入：grid = [["a","b","b"],["b","z","b"],["b","b","a"]]
//输出：false
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 1 <= m <= 500
// 1 <= n <= 500
// grid 只包含小写英文字母。
//
//
// 👍 73 👎 0

public class LC_1559 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.containsCycle(new char[][]{{'c','c','c','a'},{'c','d','c','c'},{'c','c','e','c'},{'f','c','c','c'}}));
    }
}

class Solution {
    private static final int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public boolean containsCycle(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        boolean[][] track = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j]) {
                    track[i][j] = true;
                    boolean dfs = dfs(visited, grid, i, j, grid[i][j], track, -1, -1);
                    if (dfs) {
                        return true;
                    }
                    track[i][j] = false;
                }
            }
        }
        return false;
    }

    private boolean dfs(boolean[][] visited, char[][] grid, int x, int y, int curValue, boolean[][] track, int lastX, int lastY) {
        visited[x][y] = true;
        for (int[] dir : dirs) {
            int dx = x + dir[0];
            int dy = y + dir[1];
            if (dx >= 0 && dy >= 0 && dx < grid.length && dy < grid[0].length && (dx != lastX || dy != lastY)) {
                if (grid[dx][dy] == curValue) {
                    if (track[dx][dy]) {
                        return true;
                    } else {
                        track[dx][dy] = true;
                        if (!visited[dx][dy] && dfs(visited, grid, dx, dy, curValue, track, x, y)){
                            track[dx][dy] = false;
                            return true;
                        }
                        track[dx][dy] = false;
                    }
                }
            }
        }
        return false;
    }
}

class Solution1 {
    public long countAlternatingSubarrays(int[] nums) {
        long res = 0, cur = 0;
        int pre = -1;
        for (int a : nums) {
            cur = (pre != a) ? cur + 1 : 1;
            pre = a;
            res += cur;
        }
        return res;
    }
}


//class Solution {
//    public boolean containsCycle(char[][] grid) {
//        new UnionFind();
//    }
//
//    class UnionFind {
//        private final int[] nums;
//
//        public UnionFind(int size) {
//            nums = new int[size];
//            for (int i= 0; i < size; i++) {
//                nums[i] = i;
//            }
//        }
//
//        int find(int x) {
//            return nums[x] == x ? x : find(nums[x]);
//        }
//
//        int unionAndFind(int x, int y) {
//
//        }
//    }
//}

