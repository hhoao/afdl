package lc_2029;

/*
 *@author: 黄豪
 *@date : 2022年1月20日
 *@todo:2029. 石子游戏 IX
Alice 和 Bob 再次设计了一款新的石子游戏。现有一行 n 个石子，每个石子都有一个关联的数字表示它的价值。给你一个整数数组 stones ，其中 stones[i] 是第 i 个石子的价值。

Alice 和 Bob 轮流进行自己的回合，Alice 先手。每一回合，玩家需要从 stones 中移除任一石子。

如果玩家移除石子后，导致 所有已移除石子 的价值 总和 可以被 3 整除，那么该玩家就 输掉游戏 。
如果不满足上一条，且移除后没有任何剩余的石子，那么 Bob 将会直接获胜（即便是在 Alice 的回合）。
假设两位玩家均采用 最佳 决策。如果 Alice 获胜，返回 true ；如果 Bob 获胜，返回 false 。

 

示例 1：

输入：stones = [2,1]
输出：true
解释：游戏进行如下：
- 回合 1：Alice 可以移除任意一个石子。
- 回合 2：Bob 移除剩下的石子。 
已移除的石子的值总和为 1 + 2 = 3 且可以被 3 整除。因此，Bob 输，Alice 获胜。
示例 2：

输入：stones = [2]
输出：false
解释：Alice 会移除唯一一个石子，已移除石子的值总和为 2 。 
由于所有石子都已移除，且值总和无法被 3 整除，Bob 获胜。
*/
public class LC_2029 {
	public static void main(String[] args) {
		System.out.println(new Solution().stoneGameIX(new int[] {15,20,10,13,14,15,5,2,3}));
	}
}
//暴力深搜博弈(超时)
class Solution {
    private boolean dfs(int sum, int[] stones, int k, boolean[] vis){
        int n = stones.length;
        for (int i = 0; i < n; i++){
            if (!vis[i]){
                if ((sum+stones[i]) % 3 == 0) continue;
                if (k+1 == n) return n % 2 == 0 ? true : false;
                vis[i] = true;
                if (!dfs(sum+stones[i], stones, k+1, vis)){
                    vis[i] = false;
                    return true;
                }
                vis[i] = false;
            }
        }
        return false;
    }
    public boolean stoneGameIX(int[] stones) {
        int n = stones.length;
        boolean[] vis = new boolean[n];
         
        return dfs(0, stones, 0, vis);
    }
}
//构造
class Solution1 {
    public boolean stoneGameIX(int[] stones) {
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;
        for (int val : stones) {
            int type = val % 3;
            if (type == 0) {
                ++cnt0;
            } else if (type == 1) {
                ++cnt1;
            } else {
                ++cnt2;
            }
        }
        if (cnt0 % 2 == 0) {
            return cnt1 >= 1 && cnt2 >= 1;
        }
        return cnt1 - cnt2 > 2 || cnt2 - cnt1 > 2;
    }
}
