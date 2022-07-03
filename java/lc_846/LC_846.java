package lc_846;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
 *@author: 黄豪
 *@date : 2021年12月30日
 *@todo:846. 一手顺子
Alice 手中有一把牌，她想要重新排列这些牌，分成若干组，使每一组的牌数都是 groupSize ，并且由 groupSize 张连续的牌组成。

给你一个整数数组 hand 其中 hand[i] 是写在第 i 张牌，和一个整数 groupSize 。如果她可能重新排列这些牌，返回 true ；否则，返回 false 。
*/
public class LC_846 {

}
class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        int n = hand.length;
        if (n % groupSize != 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(hand);
        for (int i = 0; i < n; i++){
            map.put(hand[i], map.getOrDefault(hand[i], 0) + 1);
        }
        
        for (int i = 0; i < n; i++){
            if (map.containsKey(hand[i])){
                for (int j = 0; j < groupSize; j++){
                    if (map.containsKey(hand[i]+j)){
                        int count = map.get(hand[i] + j);
                        if (count - 1 != 0){
                            map.put(hand[i] + j, map.get(hand[i] + j) - 1);
                        }else{
                            map.remove(hand[i] +j);
                        }
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}