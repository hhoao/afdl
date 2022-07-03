package lc_399;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

/*
 *@author: 黄豪
 *@date : 2021年12月13日
 *@todo:399. 除法求值
给你一个变量对数组 equations 和一个实数值数组 values 作为已知条件，其中 equations[i] = [Ai, Bi] 和 values[i] 共同表示等式 Ai / Bi = values[i] 。每个 Ai 或 Bi 是一个表示单个变量的字符串。

另有一些以数组 queries 表示的问题，其中 queries[j] = [Cj, Dj] 表示第 j 个问题，请你根据已知条件找出 Cj / Dj = ? 的结果作为答案。

返回 所有问题的答案 。如果存在某个无法确定的答案，则用 -1.0 替代这个答案。如果问题中出现了给定的已知条件中没有出现的字符串，也需要用 -1.0 替代这个答案。

注意：输入总是有效的。你可以假设除法运算中不会出现除数为 0 的情况，且不存在任何矛盾的结果。
*/
public class LC_399 {

}
class Pair{
    public String parent;
    public Double weight;
    Pair(String parent, Double weight){
        this.parent = parent;
        this.weight = weight;
    }
}
class UnionFind{
    Map<String, Pair> edges;
    UnionFind(){
        edges = new HashMap<>();
    }
    Pair find(String str){
        if (!edges.containsKey(str)){
            edges.put(str, new Pair(str, 1.0));
        }
        Pair edge  = edges.get(str);
        if (edge.parent.equals(str)){
            return edge;
        }
        Pair par = find(edge.parent);
        edge.parent = par.parent;
        edge.weight *= par.weight;
        return edge;
    }

    void union(String x, String y, Double value){
        Pair xP = find(x);
        Pair yP = find(y);
        if (yP.parent == xP.parent){
            return;
        }
        if (xP.parent.equals(x)){
            xP.parent = y;
            xP.weight = value;
            return;
        }
        edges.get(xP.parent).weight = value /  xP.weight;
        edges.get(xP.parent).parent = y;
    }
    boolean connected(String x, String y){
        return find(x).parent.equals(find(y).parent);
    }
    Double device(String x, String y){
        if (!edges.containsKey(x) || !edges.containsKey(y) || !connected(x, y)) {
            return -1.0;
        }
        return edges.get(x).weight / edges.get(y).weight;
    }
}
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int size = equations.size();
        UnionFind unionFind = new UnionFind();
        for (int i = 0; i < size; i++){
            List<String> equation = equations.get(i);
            unionFind.union(equation.get(0) , equation.get(1), values[i]);
        }
        int n = queries.size();
        double[] ans = new double[n];
        for (int i = 0; i < n; i++){
            ans[i] = unionFind.device(queries.get(i).get(0), queries.get(i).get(1));
        }
        return ans;
    }
}
