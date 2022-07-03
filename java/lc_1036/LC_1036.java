package lc_1036;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

/*
 *@author: 黄豪
 *@date : 2022年1月11日
 *@todo:1036. 逃离大迷宫
在一个 106 x 106 的网格中，每个网格上方格的坐标为 (x, y) 。

现在从源方格 source = [sx, sy] 开始出发，意图赶往目标方格 target = [tx, ty] 。数组 blocked 是封锁的方格列表，其中每个 blocked[i] = [xi, yi] 表示坐标为 (xi, yi) 的方格是禁止通行的。

每次移动，都可以走到网格中在四个方向上相邻的方格，只要该方格 不 在给出的封锁列表 blocked 上。同时，不允许走出网格。

只有在可以通过一系列的移动从源方格 source 到达目标方格 target 时才返回 true。否则，返回 false。

 

示例 1：

输入：blocked = [[0,1],[1,0]], source = [0,0], target = [0,2]
输出：false
解释：
从源方格无法到达目标方格，因为我们无法在网格中移动。
无法向北或者向东移动是因为方格禁止通行。
无法向南或者向西移动是因为不能走出网格。
示例 2：

输入：blocked = [], source = [0,0], target = [999999,999999]
输出：true
解释：
因为没有方格被封锁，所以一定可以到达目标方格。
*/
public class LC_1036 {

}class Solution {
    static int SURROUND = -1;
    static int FOUND = 1;
    static int VALID = 0;
    static int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    static int BOUNDRY = 1000000;
    public boolean isEscapePossible(int[][] blocked, int[] source, int[] target) {
        if (blocked.length < 2){
            return true;
        }
        int n = blocked.length * (blocked.length - 1) / 2;
        Set<Block> set = new HashSet<>();
        for (int[] bs : blocked){
            set.add(new Block(bs[0], bs[1]));
        }
        int res = bfs(set, source, target, n);
        if (res == SURROUND){
            return false;
        }else if (res == FOUND){
            return true;
        }else{
            res = bfs(set, target, source, n);
            return res == VALID;
        }
    }
    public int bfs(Set<Block> set, int[] source, int[] target, int n){
        Set<Block> visited = new HashSet<>();
        Queue<Block> queue = new ArrayDeque<>();
        Block sourceBlock = new Block(source[0], source[1]);
        queue.offer(sourceBlock);
        visited.add(sourceBlock);
        int curBlock = 0;
        while (!queue.isEmpty()){
            Block point = queue.poll();
            int x = point.x, y = point.y;
            for (int[] dir : dirs){
                int dx = x +dir[0], dy = y + dir[1];
                Block newBlock = new Block(dx, dy);
                if (dx >= 0 && dy >=0 && dx < BOUNDRY && dy < BOUNDRY && !visited.contains(newBlock) &&
                    !set.contains(newBlock)){
                    curBlock++;
                    if (dx == target[0] && dy == target[1]){
                        return FOUND;
                    }
                    if (curBlock > n){
                        return VALID;
                    }
                    visited.add(newBlock);
                    queue.offer(newBlock);
                }
            }
        }
        return SURROUND;
    }
    class Block{
        int x;
        int y;
        Block(int x, int y){
            this.x = x;
            this.y = y;
        }
        @Override
        public boolean equals(Object obj){
            if (obj instanceof Block){
                Block b = (Block) obj;
                return b.x == this.x && b.y == this.y;
            }
            return false;
        }

        @Override
        public int hashCode(){
            return ((int)(x << 20) | y);
        }
    }
}
