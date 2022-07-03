package lc_1208;

import java.util.TreeMap;

/*
 *@author: 黄豪
 *@date : 2022年1月12日
 *@todo:"krrgw"
"zjxss"
19
*/
public class LC_1208 {
	public static void main(String[] args) {
		System.out.println(new Solution().equalSubstring("abcd","abcd",0));
	}
}
//前缀和
class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        if (s.equals(t) && maxCost==0){
            return n;
        }
        int[] preSum = new int[n + 1];
        for (int i = 1; i <= n; i++){
            preSum[i] = Math.abs(t.charAt(i - 1) - s.charAt(i - 1)) + preSum[i - 1];
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 0;
        map.put(0, 0);
        for (int i = 1; i <= n; i++){
            if (map.ceilingKey(preSum[i] - maxCost) != null){
                ans = Math.max(ans, i - map.get(map.ceilingKey(preSum[i] - maxCost)));
            }
            map.put(preSum[i], i);
        }
        return ans;
    }
}
//滑动窗口
class Solution1 {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int l = 0;
        int curSum = 0, ans = 0;
        for (int i = 1; i <= n; i++){
            curSum += Math.abs(t.charAt(i - 1) - s.charAt(i - 1));
            while (curSum > maxCost){
                curSum -= Math.abs(t.charAt(l) - s.charAt(l));
                l++;
            }
            ans = Math.max(ans, i - l);
        }
        return ans;
    }
}