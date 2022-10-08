#pragma once
#include <vector>

using namespace std;


/**
 * 优先队列
**/
class PriorityQueue {
private:
	vector<int> data;
	int left(int i);
	int right(int i);
	int parent(int i);
	void build();
	int compare(int o1, int o2);
	void swap(int i, int j);
public:
	PriorityQueue() {
		data.push_back(0);
	}
	
	void maxHeapify(int i);
	void offer(int data);
	int poll();
	int peek();
	void clean();
	int size();
	bool remove();
};

