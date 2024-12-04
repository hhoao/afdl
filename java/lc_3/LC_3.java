/*
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
package lc_3;
import java.util.*;

public class LC_3 {
	public static void main(String[] args) {
		Scanner s1 = new Scanner(System.in);
		System.out.println(Solution.lengthOfLongestSubstring(s1.next()));
		s1.close();
		
	}
}
class Solution {
    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = 0, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk < n && !occ.contains(s.charAt(rk))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i);
        }
        return ans;
    }
}
