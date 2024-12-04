package lc_544;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/*
 *@author: 黄豪
 *@date : 2021年5月2日
 *@todo:554. 砖墙
你的面前有一堵矩形的、由 n 行砖块组成的砖墙。这些砖块高度相同（也就是一个单位高）但是宽度不同。每一行砖块的宽度之和应该相等。

你现在要画一条 自顶向下 的、穿过 最少 砖块的垂线。如果你画的线只是从砖块的边缘经过，就不算穿过这块砖。你不能沿着墙的两个垂直边缘之一画线，这样显然是没有穿过一块砖的。

给你一个二维数组 wall ，该数组包含这堵墙的相关信息。其中，wall[i] 是一个代表从左至右每块砖的宽度的数组。你需要找出怎样画才能使这条线 穿过的砖块数量最少 ，并且返回 穿过的砖块数量 。
*/
public class LC_544 {

}
//我的代码
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        TreeMap<Integer, Integer> brickMap = new TreeMap<>((a, b) -> a - b);
        for (int i = 0; i < n; i++){
            List<Integer> subWall = wall.get(i);
            int sum = 0;
            for (int j = 0; j < subWall.size() - 1; j++){
                int size = subWall.get(j);
                sum += size;
                int col = brickMap.getOrDefault(sum, 0);
                brickMap.put(sum, col+1);
            }
        }
        if (brickMap.isEmpty()) return n;
        List<Map.Entry<Integer, Integer>> enL = new ArrayList<>(brickMap.entrySet());
        Collections.sort(enL, new Comparator<Map.Entry<Integer, Integer>>(){
            public int compare(Map.Entry<Integer, Integer> m1, Map.Entry<Integer, Integer> m2){
                return m2.getValue() - m1.getValue();
            }
        });
        return n - enL.get(0).getValue();
    }
}
//官方
class Solution1 {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> cnt = new HashMap <Integer, Integer>();
        for (List<Integer> widths : wall) {
            int n = widths.size();
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += widths.get(i);
                cnt.put(sum, cnt.getOrDefault(sum, 0) + 1);
            }
        }
        int maxCnt = 0;
        for (Map.Entry<Integer, Integer> entry : cnt.entrySet()) {
            maxCnt = Math.max(maxCnt, entry.getValue());
        }
        return wall.size() - maxCnt;
    }
}
