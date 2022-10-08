#include "priority_queue.h"


bool PriorityQueue::remove() {
	int n = size();
	data[1] = data[n];
	data.pop_back();
	maxHeapify(1);
	return true;
}


void PriorityQueue::clean() {
	data.clear();
	data.push_back(0);
}


int PriorityQueue::poll() {
	int ans = data[1];
	int n = size();
	data[1] = data[n];
	data.pop_back();
	maxHeapify(1);
	return ans;
}


void PriorityQueue::swap(int i, int j) {
	int temp = data[i];
	data[i] = data[j];
	data[j] = temp;
}


void PriorityQueue::build() {
	for (int i = size() / 2; i > 0; i--) {
		maxHeapify(i);
	}
}


int PriorityQueue::peek() {
	return data.back();
}

void PriorityQueue::offer(int element) {
	data.push_back(element);
	int n = size();
	while (n > 1) {
		int p = parent(n);
		if (compare(element, data[p]) > 0) {
			swap(n, p);
		}
		n = p;
	}
}


int PriorityQueue::size() {
	return data.size() - 1;
}


int PriorityQueue::compare(int o1, int o2) {
	return o1 - o2;
}


void PriorityQueue::maxHeapify(int i) {
	while (left(i) < size()) {
		int l = left(i);
		int r = right(i);
		int max = i;
		if (compare(data[l], data[max]) > 0) {
			max = l;
		}
		if (compare(data[r], data[max]) > 0) {
			max = r;
		}
		if (i != max) {
			int temp_data = data[max];
			data[max] = data[i];
			data[i] = temp_data;
			i = max;
		}
	}
}
//获取左节点

int PriorityQueue::left(int i) {
	return i * 2;
}
//获取父节点
int PriorityQueue::parent(int i) {
	return i / 2;
}
/*
 * 
 * */
int PriorityQueue::right(int i) {
	return i * 2 + 1;
}
