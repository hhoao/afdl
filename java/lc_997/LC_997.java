package lc_997;

/*
 *@author: 黄豪
 *@date : 2021年12月19日
 *@todo:997. 找到小镇的法官
在一个小镇里，按从 1 到 n 为 n 个人进行编号。传言称，这些人中有一个是小镇上的秘密法官。

如果小镇的法官真的存在，那么：

小镇的法官不相信任何人。
每个人（除了小镇法官外）都信任小镇的法官。
只有一个人同时满足条件 1 和条件 2 。
给定数组 trust，该数组由信任对 trust[i] = [a, b] 组成，表示编号为 a 的人信任编号为 b 的人。

如果小镇存在秘密法官并且可以确定他的身份，请返回该法官的编号。否则，返回 -1。
*/
public class LC_997 {

}
//题解
class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] targets = new int[n+1];
        boolean[] vis = new boolean[n+1];
        int m = trust.length;
        for (int i = 0; i < m; i++){
            targets[trust[i][1]]++;
            vis[trust[i][0]] = true;
            if (targets[trust[i][1]] == n) 
                return -1;
        }
        for (int i = 1; i <= n; i++){
            if (targets[i] == n - 1 && !vis[i])
                return i;
        }
        return -1;
    }
}
