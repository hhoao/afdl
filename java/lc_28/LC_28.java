package lc_28;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 黄豪
 *28. 实现 strStr()
实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。
 */
public class LC_28 {

}
//KMP[5ms] > Horspool[7ms] > 有限状态机[29ms] > Sunday[347ms] > (滑动窗口[353ms])> 双指针[1760ms])(不知道为什么,可能是官方函数快好多)
//滑动窗口
class Solution {
  public int strStr(String haystack, String needle) {
    int L = needle.length(), n = haystack.length();

    for (int start = 0; start < n - L + 1; ++start) {
      if (haystack.substring(start, start + L).equals(needle)) {
        return start;
      }
    }
    return -1;
  }
}
//双指针线性时间复杂度
class Solution2 {
  public int strStr(String haystack, String needle) {
    int L = needle.length(), n = haystack.length();
    if (L == 0) return 0;

    int pn = 0;
    while (pn < n - L + 1) {
      while (pn < n - L + 1 && haystack.charAt(pn) != needle.charAt(0)) ++pn;

      int currLen = 0, pL = 0;
      while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
        ++pn;
        ++pL;
        ++currLen;
      }

      if (currLen == L) return pn - L;
      pn = pn - currLen + 1;
    }
    return -1;
  }
}
//Rabin-Karp - 常数复杂度
class Solution3 {
  public int charToInt(int idx, String s) {
    return (int)s.charAt(idx) - (int)'a';
  }

	public int strStr(String haystack, String needle) {
		int L = needle.length(), n = haystack.length();
		if (L > n)
			return -1;
		int a = 26;

		long modulus = (long) Math.pow(2, 31);

		long h = 0, ref_h = 0;
		for (int i = 0; i < L; ++i) {
			h = (h * a + charToInt(i, haystack)) % modulus;
			ref_h = (ref_h * a + charToInt(i, needle)) % modulus;
		}
		if (h == ref_h)
			return 0;

		long aL = 1;
		for (int i = 1; i <= L; ++i)
			aL = (aL * a) % modulus;

		for (int start = 1; start < n - L + 1; ++start) {
			h = (h * a - charToInt(start - 1, haystack) * aL + charToInt(start + L - 1, haystack)) % modulus;
			if (h == ref_h)
				return start;
		}
		return -1;
	}
}
//有限状态自动机
class Solution1 {
  int[][] dp;
  public int strStr(String haystack, String needle) {
      int n = haystack.length(), m = needle.length();
      if (m == 0) return 0;
      this.dp = new int[m][256];
      dp[0][needle.charAt(0)] = 1;
      int x = 0;
      for (int i = 1; i < m; i++){
          char c = needle.charAt(i);
          for (int j = 0; j < 256; j++){
              if (j == c){
                  dp[i][j] = i+1; 
              }else{
                  dp[i][j] = dp[x][j];
              }
          }
          x = dp[x][c];
      }
      return search(haystack);
  }
  public int search(String haystack){
      int n = haystack.length(), m = dp.length;
      int state = 0;
      for (int i = 0; i < n; i++){
          state = dp[state][haystack.charAt(i)];
          if (state == m){
              return i - m + 1;
          }
      }
      return -1;
  }
}
//Sunday算法
class Solution4 {
    public int strStr(String haystack, String needle) {
        if (needle.length() < 1) {
            return 0;
        }
        if (haystack.length() < 1) {
            return -1;
        }
        int hLength = haystack.length();
        int nLength = needle.length();
        Map<Character, Integer> offset = new HashMap<>();
        for (int i = 0; i < nLength; i++) {
            offset.put(needle.charAt(i), nLength - i);
        }
        int point = 0;
        while (point < hLength - nLength + 1) {
            if (needle.equals(haystack.substring(point, point + nLength))) {
                return point;
            } else {
                int index = point + nLength;
                if (index > hLength - 1) {
                    return -1;
                }
                point += Objects.requireNonNullElseGet(offset.get(haystack.charAt(index)), () -> nLength + 1);
            }
        }
        return -1;
    }
}
//Horspool
class Solution5 {
	public static int strStr(String haystack, String needle) {
	    if (needle.equals("")) return 0;
	    if (needle.length() > haystack.length()) return -1;
	    Map<Character, Integer> shiftTable = new HashMap<>();
	    char[] haystacks = haystack.toCharArray();
	    char[] needles = needle.toCharArray();
	    int n = haystacks.length, m = needles.length;

	    for (int i = 0; i < needles.length - 1; i++) {
	        shiftTable.put(needles[i], needles.length - 1 - i);
	    }

	    int i = m - 1;
	    while (i < n) {
	        int k = 0;
	        while (k < m && needles[m - k - 1] == haystacks[i - k]) {
	            k++;
	        }
	        if (k == m) return i - m + 1;
	        else i += shiftTable.get(haystacks[i]) == null ? m : shiftTable.get(haystacks[i]);
	    }

	    return -1;
	}
}
