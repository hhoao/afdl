package lc_74;
/*
 * 73. 矩阵置零
给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 */
public class LC_74 {

}
class Solution {
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		if (m == 0)
			return false;
		int n = matrix[0].length;

		// 二分查找
		int left = 0, right = m * n - 1;
		int pivotIdx, pivotElement;
		while (left <= right) {
			pivotIdx = (left + right) / 2;
			pivotElement = matrix[pivotIdx / n][pivotIdx % n];
			if (target == pivotElement)
				return true;
			else {
				if (target < pivotElement)
					right = pivotIdx - 1;
				else
					left = pivotIdx + 1;
			}
		}
		return false;
	}
}
