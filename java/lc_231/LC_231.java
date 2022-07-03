package lc_231;

/**
 * @author 黄豪
 *231. 2的幂
给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 */
public class LC_231 {

}
//官方

class Solution{
    public int countDigitOne(int n) {
        int count = 0;

        for (long k = 1; k <= n; k *= 10) {
            long r = n / k, m = n % k;
            count += (r + 8) / 10 * k + (r % 10 == 1 ? m + 1 : 0);
        }

        return count;
    }
}