package lc_304;

/*
 *@author: 黄豪
 *@date : 2021年9月13日
 *@todo:
*/
public class LC_304 {
	
}
//二维前缀和
class NumMatrix {
    int[][] sumMatrix;
    public NumMatrix(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        sumMatrix = new int[n][m];
        sumMatrix[0][0] = matrix[0][0];
        for (int column = 1; column < m; column++){
            sumMatrix[0][column] = matrix[0][column] + sumMatrix[0][column - 1];
        }
        for (int row = 1; row < n; row++){
            sumMatrix[row][0] = matrix[row][0] + sumMatrix[row - 1][0];
        }
        for (int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                sumMatrix[i][j] = sumMatrix[i-1][j] + sumMatrix[i][j - 1]  - sumMatrix[i - 1][j - 1] +
                 matrix[i][j];
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (row1 > 0 && col1 > 0){
            return sumMatrix[row2][col2] - sumMatrix[row1 - 1][col2] - 
                sumMatrix[row2][col1 - 1] + sumMatrix[row1 - 1][col1 - 1];
        }else if (row1 == 0 && col1 == 0){
            return sumMatrix[row2][col2];
        }
        return sumMatrix[row2][col2] - (row1 > 0 ? sumMatrix[row1 - 1][col2] : sumMatrix[row2][col1 - 1]);
    }
}
//一维前缀和
class NumMatrix1 {
    int[][] sums;

    public NumMatrix1(int[][] matrix) {
        int m = matrix.length;
        if (m > 0) {
            int n = matrix[0].length;
            sums = new int[m][n + 1];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    sums[i][j + 1] = sums[i][j] + matrix[i][j];
                }
            }
        }
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int i = row1; i <= row2; i++) {
            sum += sums[i][col2 + 1] - sums[i][col1];
        }
        return sum;
    }
}

