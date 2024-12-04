package lc_73;
/*
 * 73. 矩阵置零
给定一个 m x n 的矩阵，如果一个元素为 0，则将其所在行和列的所有元素都设为 0。请使用原地算法。
 */
public class LC_73 {

}

class Solution {
	public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return;
        boolean rowSet = false;
        boolean colSet = false;
        if(matrix[0][0] == 0){
            rowSet = true;
            colSet = true;
        }else {
            for (int row = 0; row < matrix.length; row++) {
                if (matrix[row][0] == 0) {
                    rowSet = true;
                    break;
                }
            }
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[0][col] == 0) {
                    colSet = true;
                    break;
                }
            }
        }

        for (int row = 1; row < matrix.length; row++) {
            for (int col = 1; col < matrix[0].length; col++) {
                if(matrix[row][col] == 0){
                    matrix[row][0] = 0;
                    matrix[0][col] = 0;
                }
            }
        }

        for (int row = matrix.length-1; row >= 0; row--) {
            for (int col = matrix[0].length-1; col >=0 ; col--) {
                if(matrix[row][0] == 0 || matrix[0][col] == 0){
                    matrix[row][col] = 0;
                }
            }
        }

        if(rowSet){
            for (int row = 0; row < matrix.length; row++) {
                matrix[row][0] = 0;
            }
        }
        if(colSet){
            for (int col = 0; col < matrix[0].length; col++) {
                matrix[0][col] = 0;
            }
        }
    }
}
