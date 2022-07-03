package lc_85;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author 黄豪
 *85. 最大矩形
给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 */
public class LC_85 {
	public static void main(String[] args) {
		
		//char[][] matrix = {{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}};
		char[][] matrix = {{'1'}};
		System.out.print(new Solution().maximalRectangle(matrix));
	}
}
class Solution{
	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0) {
			return 0;
		}
		int x = matrix.length, y = matrix[0].length; 
		int[][] virMatrix = new int[x + 2][y];
		
		for (int i = 0; i < x; i++) {
			virMatrix[i+1][0] = matrix[i][0] - 48;
		}
		for (int i = 0; i < x; i++) {
			for (int j = 1; j < y; j++) {
				if (matrix[i][j] == '1') {
					virMatrix[i+1][j] = virMatrix[i+1][j - 1] + 1;
				}else {
					virMatrix[i+1][j] = 0;
				}
			}
		}
		Deque<Integer> stack = new ArrayDeque<Integer>(); 
		int ans = 0;
		for (int j = y - 1; j >= 0; j--) {
			stack.clear();
			stack.push(0);
			for (int i = 1; i <= x+1; i++) {
				while (virMatrix[i][j] < virMatrix[stack.peek()][j]) {
					int curNum = virMatrix[stack.pop()][j];
					int width  = i - stack.peek() - 1;
					ans = Math.max(ans, width * curNum);
				}
				stack.push(i);
			}
		}
		return ans;
	}
}