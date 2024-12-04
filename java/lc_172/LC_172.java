package lc_172;

/**
 * @author 黄豪
 *172. 阶乘后的零
给定一个整数 n，返回 n! 结果尾数中零的数量。
 */
public class LC_172 {

}
class Solution{
	public int trailingZeroes(int n) {
	    int zeroCount = 0;
	    for (int i = 5; i <= n; i += 5) {
	        int powerOf5 = 5;
	        while (i % powerOf5 == 0) {
	            zeroCount += 1;
	            powerOf5 *= 5;
	        }
	    }
	    return zeroCount;
	}
}
class Solution1{
	public int trailingZeroes(int n) {
	    int zeroCount = 0;
	    long currentMultiple = 5;
	    while (n > 0) {
	        n /= 5;
	        zeroCount += n;
	    }
	    return zeroCount;
	}
}
