package lc_354;

import java.util.Arrays;

/*
 *@author: 黄豪
 *@date : 2021年10月27日
 *@todo:354. 俄罗斯套娃信封问题
给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。

当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。

请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。

注意：不允许旋转信封。
*/
public class LC_354 {

}
class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        int[] f = new int[n];
        Arrays.sort(envelopes, (a, b)->a[0]-b[0]);
        Arrays.fill(f, 1);
        int ans = 1;
        for (int i = 1; i < n; i++){
            for (int j = 0; j < i; j++){
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]){
                    f[i] = Math.max(f[i], f[j]+1);
                    ans = Math.max(ans, f[i]);
                }
            }
        }
        return ans;
    }
}