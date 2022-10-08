#pragma once
#include <vector>
#include <concurrent_priority_queue.h>
using namespace std;
//最短路径算法
template<class E>
class Node {
public:
	E element;
	Node<E>* set;
	Node<E>* next;

	Node() {
		
	}
	Node(E element) {
		this->element = element;
	}
};

template <class E>
class PriorityQueue {
private:
	int (*compartor)(E o1, E o2);
	vector<E> elements;
	void heapify(int i) {
		while (i * 2 < size()) {
			int l = left(i);
			int r = right(i);
			int max = i;
			if (compare(elements[l], elements[max]) > 0) {
				max = l;
			}
			if (compare(elements[r], elements[max]) > 0) {
				max = r;
			}
			if (max != i) {
				swap(i, max);
				i = max;
				continue;
			}
			break;
		}
	}
	void swap(int i, int j) {
		E temp = elements[i];
		elements[i] = elements[j];
		elements[j] = temp;
	}
	int compare(E o1, E o2) {
		if (compartor != NULL) {
			return (*compartor)(o1, o2);
		}
		else {
			return 0;
		}
	}
	int parent(int i) {
		return i / 2;
	}
	int left(int i) {
		return i * 2;
	}
	int right(int i) {
		return i * 2 + 1;
	}
public:

	PriorityQueue() {
		E dummy;
		elements.push_back(dummy);
	}
	PriorityQueue(int (*cp)(E a, E b)) {
		E dummy;
		elements.push_back(dummy);
		compartor = cp;
	}
	E poll() {
		E res = elements[1];
		elements[1] = elements[size()];
		elements.pop_back();
		heapify(1);
		return res;
	}
	void offer(E element) {
		elements.push_back(element);
		int i = size();
		while (parent(i) >= 1 && compare(elements[i], elements[parent(i)])>0) {
			swap(i, parent(i));
			i = parent(i);
		}
	}
	E peek() {
		return elements[1];
	}
	int size() {
		return elements.size() - 1;
	}
};
//prim算法
int prim(vector<pair<int, int>> adj, vector<vector<pair<int, int>>> mat) {
	vector<int> target;
	bool visited[9];
	memset(visited, false, 9);
	PriorityQueue<pair<int, pair<int, int>>> queue(
		[](pair<int, pair<int, int>> o1, pair<int, pair<int, int>> o2) {
			return o2.first - o1.first;
		}
	);
	unsigned int count = 0;
	pair<int, pair<int, int>> p(0, adj[0]);
	queue.offer(p);
	int power = 0;
	while (count < adj.size() ) {
		pair<int, pair<int, int>> ele = queue.poll();
		vector<pair<int, int>> list = mat[ele.second.first];
		for (unsigned int i = 0; i < list.size(); i++) {
			if (visited[list[i].first]) {
				continue;
			}
			p.first = list[i].second;
			p.second = adj[list[i].first];
			queue.offer(p);
		}
		if (!visited[ele.second.first]) {
			power += ele.first;
			visited[ele.second.second] = true;
			count++;
		}
	}
	return power;
}
//Kruskal算法
int kruskal(vector<pair<int, int>> adj, vector<vector<pair<int, int>>> mat) {
	PriorityQueue<pair<int, pair<int, int>>> queue(
		[](pair<int, pair<int, int>> o1, pair<int, pair<int, int>> o2) {
			return o2.first - o1.first;
		}
	);
	bool visited[9][9];
	bool point_visited[9];
	int target = 0;
	memset(point_visited, false, 9);
	for (int i = 0; i < 9; i++) {
		memset(visited[i], false, 9);
	}

	for (unsigned int i = 0; i < mat.size(); i++) {
		for (unsigned int j = 0; j < mat[i].size(); j++) {
			if (!visited[i][mat[i][j].first]) {
				pair<int, int> edge(i, mat[i][j].first);
				visited[i][mat[i][j].first] = true;
				visited[mat[i][j].first][i] = true;
				int power = mat[i][j].second;
				pair<int, pair<int, int>> pEdge(power, edge);
				queue.offer(pEdge);
			}
		}
	}
	unsigned int count = 0;
	while (count < adj.size()) {
		pair<int, pair<int, int>> pEdge = queue.poll();
		if (!point_visited[pEdge.second.first] || !point_visited[pEdge.second.second])
			target += pEdge.first;
		if (!point_visited[pEdge.second.second]) {
			point_visited[pEdge.second.second] = true;
			count++;
		}
		if (!point_visited[pEdge.second.first]) {
			point_visited[pEdge.second.first] = true;
			count++;
		}
	}
	return target;
}
