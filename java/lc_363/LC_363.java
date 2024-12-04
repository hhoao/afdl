package lc_363;

import java.util.TreeSet;

public class LC_363 {

}
//有序集合
class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0;i < n; i++){
            int[] matrixs = new int[m];
            for (int j = 0; j <= i; j++){
                for (int column = 0; column < m; column++){
                    matrixs[column] += matrix[j][column];
                }
                
                TreeSet<Integer> sumSet = new TreeSet<>();
                int s = 0;
                sumSet.add(0);
                for (int v : matrixs){
                    s += v;
                    Integer abandon = sumSet.ceiling(s - k);
                    if (abandon != null){
                        ans = Math.max(ans, s - abandon);
                    }
                    sumSet.add(s);
                }
                
            }
        }
        return ans;
    }
}
