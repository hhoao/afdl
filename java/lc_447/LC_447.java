package lc_447;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: »ÆºÀ
 *@date : 2021Äê9ÔÂ14ÈÕ
 *@todo:
*/
public class LC_447 {

}
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int n = points.length, m = points[0].length;
        int ans = 0;
        for (int[] p : points){
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] q : points){
                int dis = (p[0] - q[0])*(p[0] - q[0]) + (p[1] - q[1])*(p[1] - q[1]);
                int num =map.getOrDefault(dis, 0);
                map.put(dis, num+1);
            }
            for (Map.Entry<Integer, Integer> me : map.entrySet()){
                int k = me.getValue();
                ans += k * (k - 1);
            }
        }
        return ans;
    }
}