#pragma once
#include <vector>
using namespace std;

class Set {
private:
	vector<int> fa;
	vector<int> rank;
public:
	Set(int capacity) {
		for (int i = 0; i <= capacity; i++) {
			fa.push_back(i);
			rank.push_back(1);
		}
	}
	int find(int i) {
		return fa[i] == i ? i : (fa[i] = find(fa[i]));
	}
	void merge(int i, int j) {
		int x = find(i), y = find(j);
		if (rank[x] <= y) {
			fa[x] = y;
		}
		else {
			fa[y] = x;
		}
		if (x != y && rank[x] == rank[y]) {
			rank[y]++;
		}
	}
};