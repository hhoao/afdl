#include "priority_queue.h"

bool PriorityQueue::contains(int num) {
    int n = 0;
    while (data[n] != num) {
        if (data[n] < num && left(n) < size()) {
            n = left(n);
        } else if (right(n) < size()) {
            n = right(n);
        } else {
            return false;
        }
    }

    return true;
}

void PriorityQueue::siftDown(int i, int moved){
    while (i < data.size() / 2) {
        int child = i * 2 + 1;
        int right = i * 2 + 2;
        int value = data[child];
        if (right < data.size() && compare(value, data[right]) < 0) {
            value = data[child=right];
        }
        if (compare(moved, value) >= 0) {
            break;
        }
        data[i] = value;
        i = child;
    }
    data[i] = moved;
}
void PriorityQueue::siftUp(int i, int moved) {
    while (i > 0) {
        int parent = (i - 1) >> 1;
        int e = data[parent];
        if (compare(moved, e) <= 0)
            break;
        data[i] = e;
        i = parent;
    }
    data[i] = moved;
}


bool PriorityQueue::remove(int num) {
    int index = -1;
    for (int i = 0; i < data.size(); i++) {
        if (num == data[i]) {
            index = i;
        }
    }
    if (index == -1) {
        return false;
    }
    int k = data[data.size() - 1];
    data.pop_back();
    siftDown(index, k);
    if (data[index] == k) {
        siftUp(index, k);
    }
    return true;
}


void PriorityQueue::clean() {
    data.clear();
}


int PriorityQueue::poll() {
    int ans = data[0];
    int n = size() - 1;
    data[0] = data[n];
    data.pop_back();
    maxHeapify(0);
    return ans;
}


void PriorityQueue::swap(int i, int j) {
    int temp = data[i];
    data[i] = data[j];
    data[j] = temp;
}


int PriorityQueue::peek() {
    return data.back();
}

void PriorityQueue::offer(int element) {
    data.push_back(element);
    int n = size() - 1;
    while (n >= 1) {
        int p = parent(n);
        if (compare(element, data[p]) > 0) {
            swap(n, p);
        }
        n = p;
    }
}


int PriorityQueue::size() {
    return data.size();
}


int PriorityQueue::compare(int o1, int o2) {
    return o2 - o1;
}

//堆排序
void PriorityQueue::build() {
    for (int i = size() / 2; i >= 0; i--) {
        maxHeapify(i);
    }
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
        } else {
            break;
        }
    }
}
//获取左节点

int PriorityQueue::left(int i) {
    return i * 2 + 1;
}

//获取父节点
int PriorityQueue::parent(int i) {
    return (i - 1) / 2;
}

/*
 *
 * */
int PriorityQueue::right(int i) {
    return i * 2 + 2;
}
