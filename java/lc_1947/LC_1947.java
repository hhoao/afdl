package lc_1947;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * LC_1947
 *
 * @author w
 * @since 2024/9/21
 **/

public class LC_1947 {
}

//题目: [1947] 最大兼容性评分和
//时间: 2024-09-21 21:31:26
//
//有一份由 n 个问题组成的调查问卷，每个问题的答案要么是 0（no，否），要么是 1（yes，是）。
//
// 这份调查问卷被分发给 m 名学生和 m 名导师，学生和导师的编号都是从 0 到 m - 1 。学生的答案用一个二维整数数组 students 表示，其中
//students[i] 是一个整数数组，包含第 i 名学生对调查问卷给出的答案（下标从 0 开始）。导师的答案用一个二维整数数组 mentors 表示，其中
//mentors[j] 是一个整数数组，包含第 j 名导师对调查问卷给出的答案（下标从 0 开始）。
//
// 每个学生都会被分配给 一名 导师，而每位导师也会分配到 一名 学生。配对的学生与导师之间的兼容性评分等于学生和导师答案相同的次数。
//
//
// 例如，学生答案为[1, 0, 1] 而导师答案为 [0, 0, 1] ，那么他们的兼容性评分为 2 ，因为只有第二个和第三个答案相同。
//
//
// 请你找出最优的学生与导师的配对方案，以 最大程度上 提高 兼容性评分和 。
//
// 给你 students 和 mentors ，返回可以得到的 最大兼容性评分和 。
//
//
//
// 示例 1：
//
// 输入：students = [[1,1,0],[1,0,1],[0,0,1]], mentors = [[1,0,0],[0,0,1],[1,1,0]]
//输出：8
//解释：按下述方式分配学生和导师：
//- 学生 0 分配给导师 2 ，兼容性评分为 3 。
//- 学生 1 分配给导师 0 ，兼容性评分为 2 。
//- 学生 2 分配给导师 1 ，兼容性评分为 3 。
//最大兼容性评分和为 3 + 2 + 3 = 8 。
//
// 示例 2：
//
// 输入：students = [[0,0],[0,0],[0,0]], mentors = [[1,1],[1,1],[1,1]]
//输出：0
//解释：任意学生与导师配对的兼容性评分都是 0 。
//
//
//
//
// 提示：
//
//
// m == students.length == mentors.length
// n == students[i].length == mentors[j].length
// 1 <= m, n <= 8
// students[i][k] 为 0 或 1
// mentors[j][k] 为 0 或 1
//
//
// 👍 50 👎 0


// 如果使用暴力的话，那就通过 dfs 来获取最大和评分和, 那就有点复杂了。
// 最大兼容评分和等于当前选择导师和学生的兼容评分加上剩下的导师匹配剩下的学生的最大评分。
// 如果遍历学生，学生固定的话，那么我们只需要考虑前面的导师的最大评分。
// 所以我们需要维护所有导师的出现的案例, 可以使用位运算 或者 Map 来维护。
class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int n = students.length;
        HashMap<Integer, Integer> dp = new HashMap<>();
        dp.put(0, 0);

        for (int i = 0; i < n; i++) {
            HashMap<Integer, Integer> copy = new HashMap<>();
            for (int j = 0; j < n; j++) {
                int bit = 1 << j;
                int score = 0;
                for (int k = 0; k < students[i].length; k++) {
                    score += students[i][k] == mentors[j][k] ? 1 : 0;
                }
                for (Map.Entry<Integer, Integer> dpEntry : dp.entrySet()) {
                    if ((bit & dpEntry.getKey()) == 0) {
                        int next = bit | dpEntry.getKey();
                        int finalScore = score + dpEntry.getValue();
                        copy.compute(next, (k, v)-> {
                            if (v == null) {
                                return finalScore;
                            }
                            return Math.max(v, finalScore);
                        });
                    }
                }
            }
            dp = copy;
        }
        int ans = 0;
        for (Map.Entry<Integer, Integer> dpEntry : dp.entrySet()) {
            ans = Math.max(dpEntry.getValue(), ans);
        }
        return ans;
    }
}
