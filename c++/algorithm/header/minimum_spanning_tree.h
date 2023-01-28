//
// Created by hhoa on 23-1-19.
//
#include <vector>

using namespace std;

#ifndef ALGORITHM_MINIMUM_SPANNING_TREE_H
#define ALGORITHM_MINIMUM_SPANNING_TREE_H

class minimum_spanning_tree {
public:
    /**
     * Prim算法
     * @param adj 节点个数
     * @param mat 带权连通无向图, 例如, {{1, 2, 3}, {0, 1, 2}} 表示节点1到节点2权值为3,  节点0,1的权值为2
     * @return 最小全值
     */
    static int prim(int n, const vector<vector<int>>& mat);
    /**
     * Kruskal算法
     * @param n 节点个数
     * @param mat 带权连通无向图, 例如, {{1, 2, 3}, {0, 1, 2}} 表示节点1到节点2权值为3,  节点0,1的权值为2
     * @return 最小全值
     */
    static int kruskal(int n, vector<vector<int>>& mat);
};
#endif //ALGORITHM_MINIMUM_SPANNING_TREE_H
