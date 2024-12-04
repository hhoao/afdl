#include <vector>
#include <iostream>
#include <algorithm>
#include "queue"
#include "minimum_spanning_tree.h"

using namespace std;

int minimum_spanning_tree::prim(int n, const vector<vector<int>> &mat) {
    vector<vector<pair<int, int>>> adj(n);
    for (vector<int> edge: mat) {
        adj[edge[0]].emplace_back(edge[1], edge[2]);
        adj[edge[1]].emplace_back(edge[0], edge[2]);
    }
    vector<bool> visited(n);
    struct customLess {
        bool operator()(pair<int, int> o1, pair<int, int> o2) const {
            return o1.first > o2.first;
        }
    } myCustomLess;
    priority_queue<pair<int, int>, vector<pair<int, int>>, customLess> queue(myCustomLess);
    unsigned int count = 0;
    pair<int, int> p(0, 0);
    queue.push(p);
    int power = 0;
    while (count < n) {
        pair<int, int> ele = queue.top();
        queue.pop();
        vector<pair<int, int>> list = adj[ele.second];
        for (auto &i: list) {
            if (visited[i.first]) {
                continue;
            }
            p.first = i.second;
            p.second = i.first;
            queue.push(p);
        }
        if (!visited[ele.second]) {
            power += ele.first;
            visited[ele.second] = true;
            count++;
        }
    }
    return power;
}

int minimum_spanning_tree::kruskal(int n, vector<vector<int>> &mat) {
    //每个顶点配置一个标记值
    vector<int> assists(n);
    //初始状态下，每个顶点的标记都不相同
    for (int i = 0; i < n; i++) {
        assists[i] = i;
    }

    // 对所有边进行升序排序
    sort(mat.begin(), mat.end(), [](vector<int> v1, vector<int> v2) {
        return v1[2] < v2[2];
    });
    int target = 0, num = 0;

    for (auto edge: mat) {
        if (assists[edge[0]] != assists[edge[1]]) {
            target += edge[2];
            num++;
            int elem = assists[edge[0]];
            for (int j = 0; j < assists.size(); j++) {
                if (assists[j] == elem) {
                    assists[j] = assists[edge[1]];
                }
            }
            //如果选择的边的数量和顶点数相差1，证明最小生成树已经形成，退出循环
            if (num == n - 1) {
                break;
            }
        }
    }
    return target;
}

