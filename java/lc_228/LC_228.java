package lc_228;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author 黄豪
 *228. 汇总区间
给定一个无重复元素的有序整数数组 nums 。

返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。

列表中的每个区间范围 [a,b] 应该按如下格式输出：

"a->b" ，如果 a != b
"a" ，如果 a == b
 */
public class LC_228 {

}
//我的代码
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int n = nums.length;
        if (n == 0) return res;
        int l = nums[0];
        int r = nums[0];
        for (int i = 1; i < n; i++){
            if (nums[i] == r + 1){
                r = nums[i];
            }else{
                res.add(l == r ? "" + l : l + "->"+r);
                l = nums[i];
                r = nums[i];
            }
        }
        res.add(l == r ? "" + l : l + "->"+r);
        return res;
    }
}