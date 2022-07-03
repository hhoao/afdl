package lc_466;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: 黄豪
 *@date : 2021年9月30日
 *@todo:466. 统计重复个数
定义 str = [s, n] 表示 str 由 n 个字符串 s 连接构成。

例如，str == ["abc", 3] =="abcabcabc" 。
如果可以从 s2 中删除某些字符使其变为 s1，则称字符串 s1 可以从字符串 s2 获得。

例如，根据定义，s1 = "abc" 可以从 s2 = "abdbec" 获得，仅需要删除加粗且用斜体标识的字符。
现在给你两个字符串 s1 和 s2 和两个整数 n1 和 n2 。由此构造得到两个字符串，其中 str1 = [s1, n1]、str2 = [s2, n2] 。

请你找出一个最大整数 m ，以满足 str = [str2, m] 可以从 str1 获得。
*/
public class LC_466 {
	public static void main(String[] args) {
		Solution so = new Solution();
		System.out.println(so.getMaxRepetitions("baba", 11, "baab", 1));
	}
}
//动态规划
class Solution {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        int[] dp = new int[s2.length()];
        for (int i = 0; i < s2.length(); i++) {
            int j = i;
            for (int p = 0; p < s1.length(); p++) {
                if (s1.charAt(p) == s2.charAt(j)) {
                    j = (j + 1) % s2.length();
                    dp[i]++;
                }
            }
        }
        int cnt = 0, p = 0;
        for (int i = 0; i < n1; i++) {
            int add = dp[p];
            p = (p + add) % s2.length();
            cnt += add;
        }
        return cnt / s2.length() / n2;
    }
}
//找循环节
class Solution1 {
    public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
        if (n1 == 0) {
            return 0;
        }
        int s1cnt = 0, index = 0, s2cnt = 0;
        Map<Integer, int[]> recall = new HashMap<Integer, int[]>();
        int[] preLoop = new int[2];
        int[] inLoop = new int[2];
        while (true) {
            ++s1cnt;
            for (int i = 0; i < s1.length(); ++i) {
                char ch = s1.charAt(i);
                if (ch == s2.charAt(index)) {
                    index += 1;
                    if (index == s2.length()) {
                        ++s2cnt;
                        index = 0;
                    }
                }
            }
            if (s1cnt == n1) {
                return s2cnt / n2;
            }
            if (recall.containsKey(index)) {
                int[] value = recall.get(index);
                int s1cntPrime = value[0];
                int s2cntPrime = value[1];
                preLoop = new int[]{s1cntPrime, s2cntPrime};
                inLoop = new int[]{s1cnt - s1cntPrime, s2cnt - s2cntPrime};
                break;
            } else {
                recall.put(index, new int[]{s1cnt, s2cnt});
            }
        }
        int ans = preLoop[1] + (n1 - preLoop[0]) / inLoop[0] * inLoop[1];
        int rest = (n1 - preLoop[0]) % inLoop[0];
        for (int i = 0; i < rest; ++i) {
            for (int j = 0; j < s1.length(); ++j) {
                char ch = s1.charAt(j);
                if (ch == s2.charAt(index)) {
                    ++index;
                    if (index == s2.length()) {
                        ++ans;
                        index = 0;
                    }
                }
            }
        }
        return ans / n2;
    }
}