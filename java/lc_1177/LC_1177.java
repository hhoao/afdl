package lc_1177;

import java.util.ArrayList;
import java.util.List;

/*
 *@author: 黄豪
 *@date : 2022年1月12日
 *@todo:1177. 构建回文串检测
给你一个字符串 s，请你对 s 的子串进行检测。

每次检测，待检子串都可以表示为 queries[i] = [left, right, k]。我们可以 重新排列 子串 s[left], ..., s[right]，并从中选择 最多 k 项替换成任何小写英文字母。 

如果在上述检测过程中，子串可以变成回文形式的字符串，那么检测结果为 true，否则结果为 false。

返回答案数组 answer[]，其中 answer[i] 是第 i 个待检子串 queries[i] 的检测结果。

注意：在替换时，子串中的每个字母都必须作为 独立的 项进行计数，也就是说，如果 s[left..right] = "aaa" 且 k = 2，我们只能替换其中的两个字母。（另外，任何检测都不会修改原始字符串 s，可以认为每次检测都是独立的）

 

示例：

输入：s = "abcda", queries = [[3,3,0],[1,2,0],[0,3,1],[0,3,2],[0,4,1]]
输出：[true,false,false,true,true]
解释：
queries[0] : 子串 = "d"，回文。
queries[1] : 子串 = "bc"，不是回文。
queries[2] : 子串 = "abcd"，只替换 1 个字符是变不成回文串的。
queries[3] : 子串 = "abcd"，可以变成回文的 "abba"。 也可以变成 "baab"，先重新排序变成 "bacd"，然后把 "cd" 替换为 "ab"。
queries[4] : 子串 = "abcda"，可以变成回文的 "abcba"。
*/
public class LC_1177 {
	public static void main(String[] args) {
		System.out.println(new Solution().canMakePaliQueries("abcda", new int[][] {{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}}));
	}
}

//前缀和
class Solution {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length(), m = queries.length;
        int[][] f = new int[n+1][26];
        List<Boolean> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            f[i][s.charAt(i-1) - 'a']++;
            for (int j = 0; j < 26; j++) {
            	f[i][j] += f[i-1][j];
            }
        }
        
        for (int i = 0; i < m; i++){
            int orr = 0;
            for (int j = 0; j < 26; j++){
                if ((f[queries[i][1]+1][j] - f[queries[i][0]][j]) % 2 == 1){
                    orr++;
                }
            }
            ans.add((orr /2) <= queries[i][2]);
        }
        return ans;
    }
}
//状态压缩
class Solution1 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length(), m = queries.length;
        int[] f = new int[n+1];
        List<Boolean> ans = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            f[i] = f[i -1] ^ (1 << (s.charAt(i-1) - 'a'));
        }
        
        for (int i = 0; i < m; i++){
            int orr = 0;
            int state = f[queries[i][1] + 1] ^ f[queries[i][0]];
            while (state > 0){
                orr += ((state ^ 1) % 2 == 0) ? 1 : 0;
                state >>= 1;
            }
            
            ans.add((orr /2) <= queries[i][2]);
        }
        return ans;
    }
}