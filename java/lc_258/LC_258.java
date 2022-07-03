package lc_258;

/**
 * @author 黄豪
 *258. 各位相加
给定一个非负整数 num，反复将各个位上的数字相加，直到结果为一位数。
 */
public class LC_258 {

}
class Solution {
    public int addDigits(int num) {
        while (num >= 10){
            int t = 0;
            while (num > 0){
                int n = num % 10;
                num /= 10;
                t += n;
            }
            num = t;
        }
        return num;
    }
}
class Solution1 {
    public int addDigits(int num) {
        return (num -1) % 9 + 1;
    }
}