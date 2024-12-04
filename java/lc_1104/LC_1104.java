package lc_1104;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 *@author: 黄豪
 *@date : 2021年7月29日
 *@todo:1104. 二叉树寻路
在一棵无限的二叉树上，每个节点都有两个子节点，树中的节点 逐行 依次按 “之” 字形进行标记。

如下图所示，在奇数行（即，第一行、第三行、第五行……）中，按从左到右的顺序进行标记；

而偶数行（即，第二行、第四行、第六行……）中，按从右到左的顺序进行标记。



给你树上某一个节点的标号 label，请你返回从根节点到该标号为 label 节点的路径，该路径是由途经的节点标号所组成的。
*/
public class LC_1104 {
	public static void main(String[] args) {
		Solution so = new Solution();
		System.out.println(so.pathInZigZagTree(1));
	}
}
class Solution {
    public List<Integer> pathInZigZagTree(int label) {
        List<Integer> ans = new ArrayList<>();
        int k = label;
        int tier = 0;
        while(k > 0){
            tier++;
            k /= 2;
        }
        while (tier > 0){
            ans.add(label);
            int pre_tier_num_total = (int)Math.pow(2, tier - 1) - 1;
            int pre_tier_num = (int)Math.pow(2, tier -2)-1;
            label = pre_tier_num_total - label/2 + pre_tier_num + 1;
            tier--;
        }
        Collections.reverse(ans);
        return ans;
    }
}
