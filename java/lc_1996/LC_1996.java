package lc_1996;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/*
 *@author: 黄豪
 *@date : 2022年1月28日
 *@todo:1996. 游戏中弱角色的数量
你正在参加一个多角色游戏，每个角色都有两个主要属性：攻击 和 防御 。给你一个二维整数数组 properties ，其中 properties[i] = [attacki, defensei] 表示游戏中第 i 个角色的属性。

如果存在一个其他角色的攻击和防御等级 都严格高于 该角色的攻击和防御等级，则认为该角色为 弱角色 。更正式地，如果认为角色 i 弱于 存在的另一个角色 j ，那么 attackj > attacki 且 defensej > defensei 。

返回 弱角色 的数量。

 

示例 1：

输入：properties = [[5,5],[6,3],[3,6]]
输出：0
解释：不存在攻击和防御都严格高于其他角色的角色。
示例 2：

输入：properties = [[2,2],[3,3]]
输出：1
解释：第一个角色是弱角色，因为第二个角色的攻击和防御严格大于该角色。
*/
public class LC_1996 {

}
//暴力超时
class Solution {
    public int numberOfWeakCharacters(int[][] properties) {
        int n = properties.length;
        int ans = 0;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (properties[i][0] < properties[j][0] && properties[i][1] < properties[j][1]){
                    ans++;
                    break;
                }
            }
        }
        return ans;
    }
}
//排序
class Solution1 {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (a, b)->a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        int maxDef = 0;
        int ans = 0;
        for (int[] property : properties){
            if (property[1] < maxDef){
                ans++;
            }else{
                maxDef = property[1];
            }
        }
        return ans;
    }
}
//单调栈
class Solution3 {
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, (o1, o2) -> {
            return o1[0] == o2[0] ? (o2[1] - o1[1]) : (o1[0] - o2[0]);
        });
        int ans = 0;
        Deque<Integer> st = new ArrayDeque<Integer>();
        for (int[] p : properties) {
            while (!st.isEmpty() && st.peek() < p[1]) {
                st.pop();
                ans++;
            }
            st.push(p[1]);
        }
        return ans;
    }
}
