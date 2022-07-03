package lc_91;

/**
 * @author 黄豪
 *91. 解码方法
一条包含字母 A-Z 的消息通过以下映射进行了 编码 ：

'A' -> 1
'B' -> 2
...
'Z' -> 26
要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"111" 可以将 "1" 中的每个 "1" 映射为 "A" ，从而得到 "AAA" ，或者可以将 "11" 和 "1"（分别为 "K" 和 "A" ）映射为 "KA" 。注意，"06" 不能映射为 "F" ，因为 "6" 和 "06" 不同。

给你一个只含数字的 非空 字符串 num ，请计算并返回 解码 方法的 总数 。

题目数据保证答案肯定是一个 32 位 的整数。
 */
public class LC_91 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.numDecodings("27"));//22626
	}
}
//动态规划
//垃圾代码这么多行
class Solution{
	public int numDecodings(String s) {
		if (s == null || s.charAt(0) == '0') {
			return 0;
		}
		int n = s.length();
		int[] dp = new int[n];
		dp[0] = 1;
		if (n > 1) {
			if (s.charAt(1) - 48 == 0) {
				if (s.charAt(0) - 48> 2) {
					return 0;
				}else {
					dp[1] = 1;
				}
			}else {
				if (s.charAt(0) - 48 > 2) {
					dp[1] = 1;
				} else {
					if (s.charAt(0) - 48 == 2) {
						if (s.charAt(1) - 48 <= 6) {
							dp[1] = 2;
						}else {
							dp[1] = 1;
						}
					}else {
						dp[1] = 2;
					}
				}
				
			}
		}
		
		for (int i = 2; i < n; i++) {
			if (s.charAt(i) - 48 == 0) {
				if (s.charAt(i - 1) - 48 > 2) {
					return 0;
				}else if (s.charAt(i - 1) - 48 == 0){
					return 0;
				}else{
					dp[i] = dp[i - 2];
					dp[i-1] = 0;
				}
			}else if(s.charAt(i - 1) - 48 > 2) {
				dp[i] = dp[i - 1];
			}else {
				if (s.charAt(i - 1) - 48 == 2) {
					if (s.charAt(i) - 48 <= 6) {
						dp[i] = dp[i - 1] + dp[i - 2];
					}else {
						dp[i] = dp[i - 1];
					}
				}else if (s.charAt(i - 1) - 48== 0){
					dp[i] = dp[i - 1];
				}else{
					dp[i] = dp[i - 1] + dp[i - 2];
				}
			}
		}
		return dp[n - 1];
    }
}

//多优雅
class Solution1 {
    public int numDecodings(String s) {
        if(s.charAt(0) =='0') return 0;
        int pre = 1,curr = 1;
        for (int i = 1; i < s.length(); i++) {
            int temp = curr;
            if (s.charAt(i) == '0') {
                if(s.charAt(i-1) =='1' || s.charAt(i-1)=='2') curr =pre;
                else return 0;
            } else if (s.charAt(i-1)=='1' ||(s.charAt(i-1) =='2' &&s.charAt(i)>='1'&&s.charAt(i)<='6')) {
                curr = curr+pre;
            }
            pre =temp;
        }
        return curr;
    }
}