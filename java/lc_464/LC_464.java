package lc_464;

/*
 *@author: 黄豪
 *@date : 2021年11月12日
 *@todo:464. 我能赢吗
在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到或超过 100 的玩家，即为胜者。

如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？

例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。

给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），判断先出手的玩家是否能稳赢（假设两位玩家游戏时都表现最佳）？

你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。
*/
public class LC_464 {

}
//记忆化搜索(动态规划)
class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if(maxChoosableInteger >= desiredTotal) return true;
        if((1 + maxChoosableInteger) * maxChoosableInteger / 2 < desiredTotal) return false;
        return dfs(maxChoosableInteger, 0, desiredTotal, new Boolean[1 << maxChoosableInteger]);
    }
    public boolean dfs(int maxChoosableInteger, int n, int desiredTotal, Boolean[] dp){
        if (dp[n] != null) return dp[n];
        for (int i = 0; i < maxChoosableInteger; i++){
            if ((n & 1 << i) != 0) continue;
            if (i + 1 >= desiredTotal || !dfs(maxChoosableInteger, n | 1 << i, desiredTotal - i - 1, dp)){
                return dp[n] = true;
            }
        }
        return dp[n] = false;
    }
}
