package lc_457;

import java.util.Arrays;
import java.util.TreeSet;

/*
 *@author: 黄豪
 *@date : 2021年12月20日
 *@todo:475. 供暖器
冬季已经来临。 你的任务是设计一个有固定加热半径的供暖器向所有房屋供暖。

在加热器的加热半径范围内的每个房屋都可以获得供暖。

现在，给出位于一条水平线上的房屋 houses 和供暖器 heaters 的位置，请你找出并返回可以覆盖所有房屋的最小加热半径。

说明：所有供暖器都遵循你的半径标准，加热的半径也一样。
*/
public class LC_457 {
	public static void main(String[] args) {
		System.out.println(new Solution2().findRadius(new int[] {1, 2, 3, 80, 100, 4},  new int[] {1, 2, 3, 80, 100, 4}));
	}
}
//暴力
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int n = houses.length, m = heaters.length;
        int res = 0;
        Arrays.sort(heaters);
        for (int i = 0; i <n; i++){
            int tmp = Integer.MAX_VALUE;
            for (int j = 0; j < m; j++){
                
                tmp = Math.min(tmp, Math.abs(houses[i] - heaters[j]));
            }
            res = Math.max(res, tmp);
        }
        return res;
    }
}
//TreeSet
class Solution1 {
    public int findRadius(int[] houses, int[] heaters) {
        int n = houses.length, m = heaters.length;
        int res = 0;
        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < m; i++){
            ts.add(heaters[i]);
        }
        for (int i = 0; i <n; i++){
            Integer c = ts.ceiling(houses[i]);
            Integer f = ts.floor(houses[i]);
            if (c != null && f != null){
                res = Math.max(res, Math.min(c - houses[i], houses[i] - f));
            }else if (c == null){
                res = Math.max(res, houses[i] - f);
            }else{
                res = Math.max(res, c - houses[i]);
            }
        }
        return res;
    }
}

//一次遍历
class Solution2 {
    public int findRadius(int[] houses, int[] heaters) {
        int n = houses.length, m = heaters.length;
        int res = 0;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int heaterInd = 0;
        for (int i = 0; i < n; i++){
            while (heaterInd < m - 1 && (Math.abs(houses[i] - heaters[heaterInd]) >= 
            Math.abs(houses[i] - heaters[heaterInd+1]))){
                heaterInd++;
            }
            res = Math.max(res, Math.abs(houses[i] - heaters[heaterInd]));
        }
        return res;
    }
}