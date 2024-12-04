#pragma once
#include <vector>
using namespace std;

/**
 * 并查集
 */
class union_find_set{
private:
    /**
     * 各个下标的父节点集合
     */
	vector<int> fa;
    /**
     * 每个节点权值集合
     */
	vector<int> rank;
public:
    union_find_set(int capacity) {
		for (int i = 0; i <= capacity; i++) {
			fa.push_back(i);
			rank.push_back(1);
		}
	}
    /**
     * 查找
     * @param i index
     * @return
     */
    int find(int i);
    /**
     * 合并
     * @param i
     * @param j
     */
    void merge(int i, int j);
};
