package lc_3175;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC_3175
 *
 * @author xianxing
 * @since 2024/10/24
 **/

public class LC_3175 {
}

//题目: [3175] 找到连续赢 K 场比赛的第一位玩家
//时间: 2024-10-24 09:40:31
//
//有 n 位玩家在进行比赛，玩家编号依次为 0 到 n - 1 。
//
// 给你一个长度为 n 的整数数组 skills 和一个 正 整数 k ，其中 skills[i] 是第 i 位玩家的技能等级。skills 中所有整数 互不
//相同 。
//
// 所有玩家从编号 0 到 n - 1 排成一列。
//
// 比赛进行方式如下：
//
//
// 队列中最前面两名玩家进行一场比赛，技能等级 更高 的玩家胜出。
// 比赛后，获胜者保持在队列的开头，而失败者排到队列的末尾。
//
//
// 这个比赛的赢家是 第一位连续 赢下 k 场比赛的玩家。
//
// 请你返回这个比赛的赢家编号。
//
//
//
// 示例 1：
//
//
// 输入：skills = [4,2,6,3,9], k = 2
//
//
// 输出：2
//
// 解释：
//
// 一开始，队列里的玩家为 [0,1,2,3,4] 。比赛过程如下：
//
//
// 玩家 0 和 1 进行一场比赛，玩家 0 的技能等级高于玩家 1 ，玩家 0 胜出，队列变为 [0,2,3,4,1] 。
// 玩家 0 和 2 进行一场比赛，玩家 2 的技能等级高于玩家 0 ，玩家 2 胜出，队列变为 [2,3,4,1,0] 。
// 玩家 2 和 3 进行一场比赛，玩家 2 的技能等级高于玩家 3 ，玩家 2 胜出，队列变为 [2,4,1,0,3] 。
//
//
// 玩家 2 连续赢了 k = 2 场比赛，所以赢家是玩家 2 。
//
// 示例 2：
//
//
// 输入：skills = [2,5,4], k = 3
//
//
// 输出：1
//
// 解释：
//
// 一开始，队列里的玩家为 [0,1,2] 。比赛过程如下：
//
//
// 玩家 0 和 1 进行一场比赛，玩家 1 的技能等级高于玩家 0 ，玩家 1 胜出，队列变为 [1,2,0] 。
// 玩家 1 和 2 进行一场比赛，玩家 1 的技能等级高于玩家 2 ，玩家 1 胜出，队列变为 [1,0,2] 。
// 玩家 1 和 0 进行一场比赛，玩家 1 的技能等级高于玩家 0 ，玩家 1 胜出，队列变为 [1,2,0] 。
//
//
// 玩家 1 连续赢了 k = 3 场比赛，所以赢家是玩家 1 。
//
//
//
// 提示：
//
//
// n == skills.length
// 2 <= n <= 10⁵
// 1 <= k <= 10⁹
// 1 <= skills[i] <= 10⁶
// skills 中的整数互不相同。
//
//
// 👍 17 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
// 模拟
class Solution {
    public int findWinningPlayer(int[] skills, int k) {
        Deque<int[]> queue = new ArrayDeque<int[]>();
        for (int i = 0; i < skills.length; i++) {
            queue.offer(new int[]{i, skills[i]});
        }
        int winTimes = 0;
        int[] garrison = queue.poll();
        while (true) {
            int[] challenger = queue.poll();
            if (challenger[1] > garrison[1]) {
                garrison = challenger;
                winTimes = 1;
                queue.offer(garrison);
            } else {
                winTimes++;
                if (winTimes >= k) {
                    return garrison[0];
                }
                queue.offer(challenger);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)


class Solution1 {
    public int findWinningPlayer(int[] skills, int k) {
        int[] garrison = new int[]{0, skills[0]};
        int winTimes = 0, maxI = 0;
        for (int i = 1; i < skills.length; i++) {
            int skill = skills[i];
            if (skill > garrison[1]) {
                garrison[0] = i;
                garrison[1] = skill;
                winTimes =  1;
                maxI = i;
            } else {
                winTimes++;
            }
            if (winTimes >= k) {
                return garrison[0];
            }
        }
        return maxI;
    }
}
