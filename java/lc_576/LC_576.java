package lc_576;

/*
 *@author: 黄豪
 *@date : 2021年8月15日
 *@todo:给你一个大小为 m x n 的网格和一个球。球的起始坐标为 [startRow, startColumn] 。你可以将球移到在四个方向上相邻的单元格内（可以穿过网格边界到达网格之外）。你 最多 可以移动 maxMove 次球。

给你五个整数 m、n、maxMove、startRow 以及 startColumn ，找出并返回可以将球移出边界的路径数量。因为答案可能非常大，返回对 109 + 7 取余 后的结果。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/out-of-boundary-paths
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class LC_576 {
	public static void main(String[] args) {
		Solution so = new Solution();
		System.out.println(so.findPaths(2, 2, 2, 0, 0));
	}
}
class Solution {
    int ans, m, n, maxMove;
    private void move(int row, int column, int n){
        if (row == m || row < 0 || column < 0 || column == this.n){
            ans++;
            return;
        }
        if (n == maxMove){
           return; 
        }
        
        move(row+1, column, n+1);
        move(row-1, column, n+1);
        move(row, column+1, n+1);
        move(row, column-1, n+1);
    }
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m; 
        this.n = n; 
        this.maxMove = maxMove; 
        this.ans = 0;
        move(startRow, startColumn, 0);
        return ans;
    }
}
