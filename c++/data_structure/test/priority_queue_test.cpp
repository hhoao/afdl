#include <cassert>
#include <algorithm>
#include <iostream>
#include <random>
#include "priority_queue.h"

void test(int batch) {
    std::random_device rd;
    std::mt19937 g(rd());
    std::uniform_int_distribution<int> dist(0, batch - 1);
    std::cout << "test batch: " << "-----------------------" << batch << std::endl;
    PriorityQueue queue;
    int n = batch;
    std::vector<int> deputyArr(n);
    std::cout << "test offer" << std::endl;
    for (int i = 0; i < n; i++) {
        int num = dist(rd);
         queue.offer(num);
        deputyArr[i] = num;
    }
    sort(deputyArr.begin(), deputyArr.end());

    std::cout << "test poll" << std::endl;
    for (int i = 0; i < n; i++) {
        assert(queue.poll() == deputyArr[i]);
    }
    std::cout << "test clean and size" << std::endl;
    queue.clean();
    assert(queue.size() == 0);

    std::cout << "test remove" << std::endl;
    for (int i = 0; i < n; i++) {
        int num = dist(rd);
        queue.offer(num);
        deputyArr[i] = num;
    }
    std::shuffle(deputyArr.begin(), deputyArr.end(), g);
    for (int i = 0; i < n / 2; i++){
        uniform_int_distribution<int>::param_type param(0, deputyArr.size() - 1);
        dist.param(param);
        int r = dist(rd);
        queue.remove(deputyArr[r]);
        deputyArr.erase(deputyArr.begin()+r);
    }
    sort(deputyArr.begin(), deputyArr.end());
    for (int i = 0; i < n / 2; i++) {
        assert(queue.poll() == deputyArr[i]);
    }
}

int main() {
    for (int i = 0; i < 1000; i++) {
        test(i);
    }
}
