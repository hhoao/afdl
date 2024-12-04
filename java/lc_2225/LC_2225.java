package lc_2225;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * LC_2225
 * //给你一个整数数组 matches 其中 matches[i] = [winneri, loseri] 表示在一场比赛中 winneri 击败了
 * //loseri 。
 * //
 * // 返回一个长度为 2 的列表 answer ：
 * //
 * //
 * // answer[0] 是所有 没有 输掉任何比赛的玩家列表。
 * // answer[1] 是所有恰好输掉 一场 比赛的玩家列表。
 * //
 * //
 * // 两个列表中的值都应该按 递增 顺序返回。
 * //
 * // 注意：
 * //
 * //
 * // 只考虑那些参与 至少一场 比赛的玩家。
 * // 生成的测试用例保证 不存在 两场比赛结果 相同 。
 * //
 * //
 * //
 * //
 * // 示例 1：
 * //
 * //
 * //输入：matches = [[1,3],[2,3],[3,6],[5,6],[5,7],[4,5],[4,8],[4,9],[10,4],[10,9]]
 * //输出：[[1,2,10],[4,5,7,8]]
 * //解释：
 * //玩家 1、2 和 10 都没有输掉任何比赛。
 * //玩家 4、5、7 和 8 每个都输掉一场比赛。
 * //玩家 3、6 和 9 每个都输掉两场比赛。
 * //因此，answer[0] = [1,2,10] 和 answer[1] = [4,5,7,8] 。
 * //
 * //
 * // 示例 2：
 * //
 * //
 * //输入：matches = [[2,3],[1,3],[5,4],[6,4]]
 * //输出：[[1,2,5,6],[]]
 * //解释：
 * //玩家 1、2、5 和 6 都没有输掉任何比赛。
 * //玩家 3 和 4 每个都输掉两场比赛。
 * //因此，answer[0] = [1,2,5,6] 和 answer[1] = [] 。
 * @author xianxing
 * @since 2024/5/22
 **/

public class LC_2225 {

}
class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> racerState = new HashMap<>();

        for (int[] match : matches) {
            racerState.putIfAbsent(match[0], 0);
            Integer loser = racerState.computeIfAbsent(match[1], (k)-> 0);
            loser++;
            racerState.put(match[1], loser);
        }

        List<Map.Entry<Integer, Integer>> list = new java.util.ArrayList<>(racerState.entrySet().stream().toList());
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : list) {
            if (integerIntegerEntry.getValue() == 0) {
                list1.add(integerIntegerEntry.getKey());
            } else if (integerIntegerEntry.getValue() == 1) {
                list2.add(integerIntegerEntry.getKey());
            }
        }
        list1.sort(Comparator.comparingInt(i -> i));
        list2.sort(Comparator.comparingInt(i -> i));
        res.add(list1);
        res.add(list2);
        return res;
    }
}

class Solution1 {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer, Integer> racerState = new HashMap<>();

        for (int[] match : matches) {
            racerState.putIfAbsent(match[0], 0);
            Integer loser = racerState.computeIfAbsent(match[1], (k)-> 0);
            loser++;
            racerState.put(match[1], loser);
        }

        List<Map.Entry<Integer, Integer>> list = new java.util.ArrayList<>(racerState.entrySet().stream().toList());
        list.sort((e1, e2) -> e1.getValue() - e2.getValue() == 0 ? e1.getKey() - e2.getKey() : e1.getValue() - e2.getValue());
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (Map.Entry<Integer, Integer> integerIntegerEntry : list) {
            if (integerIntegerEntry.getValue() == 0) {
                list1.add(integerIntegerEntry.getKey());
            } else if (integerIntegerEntry.getValue() == 1) {
                list2.add(integerIntegerEntry.getKey());
            }
        }
        res.add(list1);
        res.add(list2);
        return res;
    }
}
