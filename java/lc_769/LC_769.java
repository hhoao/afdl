package lc_769;

/*
 *@author: 黄豪
 *@date : 2022年1月24日
 *@todo:769. 最多能完成排序的块
数组arr是[0, 1, ..., arr.length - 1]的一种排列，我们将这个数组分割成几个“块”，并将这些块分别进行排序。之后再连接起来，使得连接的结果和按升序排序后的原数组相同。

我们最多能将数组分成多少块？

示例 1:

输入: arr = [4,3,2,1,0]
输出: 1
解释:
将数组分成2块或者更多块，都无法得到所需的结果。
例如，分成 [4, 3], [2, 1, 0] 的结果是 [3, 4, 0, 1, 2]，这不是有序的数组。
示例 2:

输入: arr = [1,0,2,3,4]
输出: 4
解释:
我们可以把它分成两块，例如 [1, 0], [2, 3, 4]。
然而，分成 [1, 0], [2], [3], [4] 可以得到最多的块数。
*/
public class LC_769 {

}
//贪心
class Solution {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int start = 0, end = 0;
        boolean[] visited = new boolean[n + 1];
        int ans = 0;
        for (int i = 0; i < n; i++){
            visited[arr[i]] = true;
            end = Math.max(end, arr[i]);
            while (visited[start]){
                if (start == end){
                    ans++;
                }
                start++;
            }
        }
        return ans;
    }
}
//官方
class Solution1 {
    public int maxChunksToSorted(int[] arr) {
        int ans = 0, max = 0;
        for (int i = 0; i < arr.length; ++i) {
            max = Math.max(max, arr[i]);
            //max==i时说明前面刚好有0到i的所有数
            if (max == i) ans++;
        }
        return ans;
    }
}
