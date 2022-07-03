package lc_171;

/**
 * @author 黄豪
 *171. Excel表列序号
给定一个Excel表格中的列名称，返回其相应的列序号。
 */
public class LC_171 {

}
//我的代码
class Solution {
    public int titleToNumber(String columnTitle) {
        int n = columnTitle.length();
        int sum = 0;
        for (int i = 0; i < n; i++){
            char c = columnTitle.charAt(i);
            sum += (c - 64)* Math.pow(26, n - i - 1);
        }
        return sum;
    }
}