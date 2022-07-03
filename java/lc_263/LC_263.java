package lc_263;

/**
 * @author 黄豪
 *263. 丑数
给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。

丑数 就是只包含质因数 2、3 和/或 5 的正整数。
 */
public class LC_263 {

}
//递归
class Solution {
    public boolean isUgly(int n) {
        return dfs(n);
    }

    public boolean dfs(int n){
        if (n == 1) return true;
        if (n == 0) return false;
        return  (n % 3 == 0 && dfs(n / 3)) || (n % 2 == 0 && dfs(n / 2)) || (n % 5 == 0 && dfs(n / 5));
    }
}
//迭代
class Solution1 {
    public boolean isUgly(int n) {
      if(n<1){
          return false;
      }
      while(n%5==0){
          n=n/5;
      }
      while(n%3==0){
          n=n/3;
      }
      while(n%2==0){
          n=n/2;
      }
      return n==1;
    }
}