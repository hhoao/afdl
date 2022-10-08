#include <vector>
#include <cassert>
#include "linked_list.h"
#include "iostream"

//
// test linked_list
// Created by hhoa on 22-9-28.
//

int main(){
    srand((unsigned) time(nullptr));
    int size = 10000;
    std::vector<int> vec;
    linked_list<int> list;
    std::cout << "test is_empty()" << std::endl;
    assert(vec.empty() == list.is_empty());
    vec.emplace_back(1);
    list.add(1);
    assert(vec.empty() == list.is_empty());

    std::cout << "test put()" << std::endl;
    for (int i = 0; i < size; i++){
        int value = rand()%size;
        vec.emplace_back(value);
        list.add(value);
    }
    for (int i = 0; i < size; i++){
        assert(vec[i] == list.get(i));
    }
    std::cout << "test insert()" << std::endl;
    for (int i = 0; i < size; i++){
        int value = rand()%size;
        int index = rand()%size;
        vec.insert(vec.begin() + index, value);
        list.insert(index, value);
    }
    for (int i = 0; i < vec.size(); i++){
        assert(vec[i] == list.get(i));
    }
    std::cout << "test remove()" << std::endl;
    for (int i = 0; i < size; i++){
        int index = rand()%size;
        vec.erase(vec.begin()+index);
        list.remove(index);
    }
    for (int i = 0; i < vec.size(); i++){
        assert(vec[i] == list.get(i));
    }
    std::cout << "test size()" << std::endl;
    assert(vec.size() == list.size());
}