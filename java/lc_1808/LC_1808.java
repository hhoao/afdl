package lc_1808;

/*
 *@author: 黄豪
 *@date : 2021年12月25日
 *@todo:1808. 好因子的最大数目
给你一个正整数 primeFactors 。你需要构造一个正整数 n ，它满足以下条件：

n 质因数（质因数需要考虑重复的情况）的数目 不超过 primeFactors 个。
n 好因子的数目最大化。如果 n 的一个因子可以被 n 的每一个质因数整除，我们称这个因子是 好因子 。比方说，如果 n = 12 ，那么它的质因数为 [2,2,3] ，那么 6 和 12 是好因子，但 3 和 4 不是。
请你返回 n 的好因子的数目。由于答案可能会很大，请返回答案对 109 + 7 取余 的结果。

请注意，一个质数的定义是大于 1 ，且不能被分解为两个小于该数的自然数相乘。一个数 n 的质因子是将 n 分解为若干个质因子，且它们的乘积为 n 。
*/
public class LC_1808 {

}
class Solution {
	static final int MOD = (int)Math.pow(10, 9) + 7;
	private int quickMul(int a, int n) {
		int res = 1;
		while (n > 0) {
			if (n % 2 == 1) {
				res = (int)((long)res * a % MOD);
			}
			a = (int)((long)a * a% MOD);
			n /= 2;
		}
		return res;
	}
	public int integerBreak(int n) {
	    if (n <= 3) {
	        return n - 1;
	    }
	    int quotient = n / 3;
	    int remainder = n % 3;
	    if (remainder == 0) {
	        return (int) quickMul(3, quotient);
	    } else if (remainder == 1) {
	        return (int) ((long)quickMul(3, quotient - 1) * 4 % MOD);
	    } else {
	        return (int) ((long)quickMul(3, quotient) * 2 % MOD);
	    }
	}
	public int maxNiceDivisors(int primeFactors) {
        if (primeFactors == 1) return 1;
        if (primeFactors == 2) return 2;
        if (primeFactors == 3) return 3;
        return integerBreak(primeFactors);
    }
}
