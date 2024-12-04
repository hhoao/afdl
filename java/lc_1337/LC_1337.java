package lc_1337;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 *@author: 黄豪
 *@date : 2021年8月1日
 *@todo:
 *1337. 矩阵中战斗力最弱的 K 行
给你一个大小为 m * n 的矩阵 mat，矩阵由若干军人和平民组成，分别用 1 和 0 表示。

请你返回矩阵中战斗力最弱的 k 行的索引，按从最弱到最强排序。

如果第 i 行的军人数量少于第 j 行，或者两行军人数量相同但 i 小于 j，那么我们认为第 i 行的战斗力比第 j 行弱。

军人 总是 排在一行中的靠前位置，也就是说 1 总是出现在 0 之前。

 
*/
public class LC_1337 {
	public static void main(String[] args) {
		int i = 0;
		int[] j  = {i, 0};
	}
}

//MySolution
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        List<int[]> army = new ArrayList<>();
        int row = mat.length,  column = mat[0].length;
        for (int i = 0; i < row; i++){
            int[] info = {i, 0};
            for (int j = 0; j < column; j++){
                if (mat[i][j] == 0){
                    break;
                }
                info[1]++;
            }
            army.add(info);
        }
        Collections.sort(army, new Comparator<int[]>(){
           public int compare(int[] army1, int[] army2){
               return army1[1] - army2[1] == 0 ? army1[0] - army2[0] : army1[1] - army2[1];
           } 
        });
        int[] most_power = new int[k];
        for (int i = 0; i < k; i++){
            most_power[i] = army.get(i)[0];
        }
        return most_power;
    }
}
