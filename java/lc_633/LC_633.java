package lc_633;

/**
 * @author 黄豪
 *633. 平方数之和
给定一个非负整数 c ，你要判断是否存在两个整数 a 和 b，使得 a2 + b2 = c 。
 */
public class LC_633 {

}
//双指针
class Solution {
    public boolean judgeSquareSum(int c) {
        long  l = 0, r = (int) Math.sqrt(c);
        while (l <= r){
            long total = l * l + r * r;
            if (total == c) return true;
            if (total < c){
                l++;
            }else if (total > c){
                r--;
            }
        }
        return false;
    }
}
//math sql函数
class Solution1 {
    public boolean judgeSquareSum(int c) {
        for (long a = 0; a * a <= c; a++) {
            double b = Math.sqrt(c - a * a);
            if (b == (int) b) {
                return true;
            }
        }
        return false;
    }
}
