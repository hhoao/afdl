//
// Created by hhoa on 22-9-19.
//

#include <queue>
#include "Solution.h"

//bfs
int findLongestNode(int u, vector<int> &parent, vector<vector<int>> &adj) {
    vector<bool> visited(adj.size());
    queue<int> qu;
    qu.emplace(u);
    visited[u] = true;
    int node = -1;
    while (!qu.empty()) {
        int cur = qu.front();
        qu.pop();
        node = cur;
        for (int v: adj[cur]) {
            if (!visited[v]) {
                visited[v] = true;
                parent[v] = cur;
                qu.emplace(v);
            }
        }
    }
    return node;
}

vector<int> Solution::findMinHeightTrees(int n, vector<vector<int>> &edges) {
    if (n == 1){
        return {0};
    }
    vector<vector<int>> adj(n);
    for (vector<int> edge: edges) {
        adj[edge[0]].emplace_back(edge[1]);
        adj[edge[1]].emplace_back(edge[0]);
    }
    vector<int> parent(n, -1);
    int x = findLongestNode(0, parent, adj);
    int y = findLongestNode(x, parent, adj);
    vector<int> path;
    parent[x] = -1;
    while (y != -1) {
        path.emplace_back(y);
        y = parent[y];
    }

    if (path.size() % 2 == 0) {
        return {path[path.size() / 2], path[path.size() / 2 - 1]};
    } else {
        return {path[path.size() / 2]};
    }
}
