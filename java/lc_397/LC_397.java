package lc_397;

/*
 *@author: 黄豪
 *@date : 2021年10月27日
 *@todo:397. 整数替换
给定一个正整数 n ，你可以做如下操作：

如果 n 是偶数，则用 n / 2替换 n 。
如果 n 是奇数，则可以用 n + 1或n - 1替换 n 。
n 变为 1 所需的最小替换次数是多少？
*/
public class LC_397 {
	public static void main(String[] args) {
		System.out.println(new Solution().integerReplacement(21));
	}
}
//递归
class Solution {
    public int integerReplacement(int n) {
        return (int)dfs(n);
    }
    long dfs(long i){
        if(i==1)return 0;
        if(i==2)return 1;
        if((i&1) == 1){
            return (long)Math.min(dfs((i+1)/2)+2,dfs(i-1)+1);
        }else return dfs(i/2)+1;
    }
}