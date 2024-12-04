package lc_2844;

/**
 * LC_2844
 *
 * @author xianxing
 * @since 2024/7/25
 **/

//题目: [2844] 生成特殊数字的最少操作
//时间: 2024-07-25 22:14:36
//
//给你一个下标从 0 开始的字符串 num ，表示一个非负整数。
//
// 在一次操作中，您可以选择 num 的任意一位数字并将其删除。请注意，如果你删除 num 中的所有数字，则 num 变为 0。
//
// 返回最少需要多少次操作可以使 num 变成特殊数字。
//
// 如果整数 x 能被 25 整除，则该整数 x 被认为是特殊数字。
//
//
//
//
//
// 示例 1：
//
//
//输入：num = "2245047"
//输出：2
//解释：删除数字 num[5] 和 num[6] ，得到数字 "22450" ，可以被 25 整除。
//可以证明要使数字变成特殊数字，最少需要删除 2 位数字。
//
// 示例 2：
//
//
//输入：num = "2908305"
//输出：3
//解释：删除 num[3]、num[4] 和 num[6] ，得到数字 "2900" ，可以被 25 整除。
//可以证明要使数字变成特殊数字，最少需要删除 3 位数字。
//
// 示例 3：
//
//
//输入：num = "10"
//输出：1
//解释：删除 num[0] ，得到数字 "0" ，可以被 25 整除。
//可以证明要使数字变成特殊数字，最少需要删除 1 位数字。
//
//
//
//
// 提示
//
//
// 1 <= num.length <= 100
// num 仅由数字 '0' 到 '9' 组成
// num 不含任何前导零
//
//
// 👍 51 👎

public class LC_2844 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.minimumOperations("2245047");
        System.out.println(i);
    }
}

// 必须得是00、50、25、75 结尾，或者 num==0
// 创建个 visited map 该 map 的 key 为 0, 5, 当访问到其中的数字时都将 visited 中的指定 key 设置为 true
// 在遍历过程中如果访问到 7 和 2 那么判断 5 是否已经访问, 同理，如果访问到 0 和 5 则判断 0 是否已访问
// 如果已经访问，那么 map 中对应 key 的需要的最少操作为 n - index[key] + index[currentNum] -index[key]
// 因为已经没有更小的值了，所以可以直接返回该最少操作
// 如果整个遍历没有获取到最小操作值，那么直接返回字符串的长度

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minimumOperations(String num) {
        int five = -1, zero = -1;
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (c == '0' && zero == -1) {
                zero = i;
            }
            if (c == '5' && five == -1) {
                five = i;
            }
            if ((c == '7' || c == '2') && five != -1 && five != i) {
                return num.length() - i + 1;
            }
            if ((c == '0' || c == '5') && zero != -1 && zero != i) {
                return num.length() - i + 1;
            }
        }
        return num.length();
    }
}
