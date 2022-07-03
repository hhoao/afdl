package lc_201;

/**
 * @author 黄豪
 *201. 数字范围按位与
给你两个整数 left 和 right ，表示区间 [left, right] ，返回此区间内所有数字 按位与 的结果（包含 left 、right 端点）。
 */
public class LC_201 {

}
//移位
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int cnt = 0;
        while (left != right){
            cnt++;
            left = left>>>1;
            right = right>>>1;
        }
        return right << cnt;
    }
}
//方法二：Brian Kernighan 算法
class Solution1 {
    public int rangeBitwiseAnd(int left, int right) {
        while (left < right){
            right = right & right - 1;
        }
        return right;
    }
}