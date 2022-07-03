package lc_169;

/**
 * @author 黄豪
 *169. 多数元素
给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。

你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class LC_169 {

}
//我的代码
class Solution {
    public int majorityElement(int[] nums) {
        int j = nums[0], n = nums.length, k = 1;
        for (int i = 1; i < n; i++){
            if (nums[i] == j){
                k++;
            }else{
                if (k == 0){
                    j = nums[i];
                }else{
                    k--;
                }
            }
        }
        return j;
    }
}