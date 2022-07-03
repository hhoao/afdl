package lc_137;

/**
 * @author 黄豪
 *137. 只出现一次的数字 II
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
 */
public class LC_137 {

}
//位运算 + 有限状态机
class Solution{
	public int singleNumber(int[] nums) {
		int ones = 0, twos = 0;
		for (int num :nums) {
			ones  = ones ^ num & ~ twos;
			twos = twos ^ num & ~ ones;
		}
		return ones;
	}
}
//方法二：遍历统计
class Solution1 {
    public int singleNumber(int[] nums) {
        int[] counts = new int[32];
        for(int num : nums) {
            for(int j = 0; j < 32; j++) {
                counts[j] += num & 1;
                num >>>= 1;
            }
        }
        int res = 0, m = 3;
        for(int i = 0; i < 32; i++) {
            res <<= 1;
            res |= counts[31 - i] % m;
        }
        return res;
    }
}