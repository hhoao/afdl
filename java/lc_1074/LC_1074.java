package lc_1074;

import java.util.HashMap;
import java.util.Map;

/*
 *@author: 黄豪
 *@date : 2022年1月3日
 *@todo:1074. 元素和为目标值的子矩阵数量
给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。

子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。

如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。
示例 1：



输入：matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
输出：4
解释：四个只含 0 的 1x1 子矩阵。
示例 2：

输入：matrix = [[1,-1],[-1,1]], target = 0
输出：5
解释：两个 1x2 子矩阵，加上两个 2x1 子矩阵，再加上一个 2x2 子矩阵。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/number-of-submatrices-that-sum-to-target
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class LC_1074 {
	public static void main(String[] args) {
		new Solution().numSubmatrixSumTarget(new int[][]{{1, -1},{-1, 1}}, 0);
	}
}
//前缀和+哈希表
class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int n = matrix.length, m = matrix[0].length;
        int ans = 0;
        for (int i = 0; i < n; i++){
            int[] columns = new int[m];
            for (int j = i; j < n; j++){
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0, 1);
                for (int col = 0; col < m; col++){
                    columns[col] += matrix[j][col];
                }
                int sum = 0;
                for (int colSum : columns){
                    sum += colSum;
                    ans += map.getOrDefault(sum - target, 0);
                    map.put(sum, map.getOrDefault(sum, 0) +1);
                }
            }
        }
        
        return ans;
    }
}