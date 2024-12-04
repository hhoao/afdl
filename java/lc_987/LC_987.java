package lc_987;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import tools.TreeNode;

/*
 *@author: 黄豪
 *@date : 2021年8月1日
 *@todo:
 *987. 二叉树的垂序遍历
给你二叉树的根结点 root ，请你设计算法计算二叉树的 垂序遍历 序列。

对位于 (row, col) 的每个结点而言，其左右子结点分别位于 (row + 1, col - 1) 和 (row + 1, col + 1) 。树的根结点位于 (0, 0) 。

二叉树的 垂序遍历 从最左边的列开始直到最右边的列结束，按列索引每一列上的所有结点，形成一个按出现位置从上到下排序的有序列表。如果同行同列上有多个结点，则按结点的值从小到大进行排序。

返回二叉树的 垂序遍历 序列。
*/
public class LC_987 {

}
class Solution {
    int min_column = 0;
    int max_column = 0;
    int row_num = 0;
    Map<Integer, Map<Integer, List<Integer>>> ansMap;
    
    public void getColumn(TreeNode root, int row, int column){
        if (root == null) return;
        if (row > row_num) row_num = row;
        if (column < min_column) min_column = column;
        if (column > max_column) max_column = column;
        
        Map<Integer, List<Integer>> column_map = ansMap.getOrDefault(column, new HashMap<>());
        List<Integer> row_list = column_map.getOrDefault(row, new ArrayList<>());
        row_list.add(root.val);
        column_map.put(row, row_list);
        ansMap.put(column, column_map);
        
        getColumn(root.left, row + 1, column - 1);
        getColumn(root.right, row + 1, column + 1);
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        ansMap = new HashMap<Integer, Map<Integer, List<Integer>>>();
        getColumn(root, 0, 0);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        for (int i = min_column; i <= max_column; i++){
            Map<Integer, List<Integer>> map = ansMap.get(i);
            List<Integer> column_list = new ArrayList<>();
            for (int j = 0; j <= row_num; j++){
                List<Integer> row_list = map.get(j);
                if (row_list != null){
                    Collections.sort(row_list);
                    for (int k = 0; k < row_list.size(); k++){
                        column_list.add(row_list.get(k));
                    }
                }
            }
               
            ans.add(column_list);
        }
        return ans;
    }
}
