//
// Created by hhoa on 23-1-19.
//

#include <vector>
#include <iostream>
#include <algorithm>
#include <cassert>
#include "../header/my_sort.h"

using namespace std;

int main() {
    srand((unsigned) time(nullptr));
    int size = 1000;
    std::vector<int> vec;
    std::vector<int> test_vec;
    std::cout << "-----test bubble_sort()-----" << std::endl;
    for (int i = 0; i < size; i++) {
        int value = rand() % size;
        vec.emplace_back(value);
        test_vec.emplace_back(value);
    }
    my_sort::bubble_sort(vec);
    sort(test_vec.begin(), test_vec.end());
    for (int i = 0; i < vec.size(); i++) {
        assert(test_vec[i] == vec[i]);
    }
    cout << "-----end-----" << endl;
    vec.clear();
    test_vec.clear();
    std::cout << "-----test heap_sort()-----" << std::endl;
    for (int i = 0; i < size; i++) {
        int value = rand() % size;
        vec.emplace_back(value);
        test_vec.emplace_back(value);
    }
    my_sort::heap_sort(vec);
    sort(test_vec.begin(), test_vec.end());
    for (int i = 0; i < vec.size(); i++) {
        assert(test_vec[i] == vec[i]);
    }
    cout << "-----end-----" << endl;
    vec.clear();
    test_vec.clear();

    std::cout << "-----test quick_sort()-----" << std::endl;
    for (int i = 0; i < size; i++) {
        int value = rand() % size;
        vec.emplace_back(value);
        test_vec.emplace_back(value);
    }
    my_sort::quick_sort(vec);
    sort(test_vec.begin(), test_vec.end());
    for (int i = 0; i < vec.size(); i++) {
        assert(test_vec[i] == vec[i]);
    }
    cout << "-----end-----" << endl;
    std::cout << "-----test odd_even_sort()-----" << std::endl;
    for (int i = 0; i < size; i++) {
        int value = rand() % size;
        vec.emplace_back(value);
        test_vec.emplace_back(value);
    }
    my_sort::odd_even_sort(vec);
    sort(test_vec.begin(), test_vec.end());
    for (int i = 0; i < vec.size(); i++) {
        assert(test_vec[i] == vec[i]);
    }
    cout << "-----end-----" << endl;
}
