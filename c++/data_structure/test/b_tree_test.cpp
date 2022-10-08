//
// Created by hhoa on 22-9-29.
//

#include <iostream>
#include <cassert>
#include <algorithm>
#include "b_tree.h"

int main(){
    b_tree bTree;
    int size = 100;
    std::vector<std::pair<int, int>> insert_values(size);
    srand((unsigned) time(nullptr));
    for (int i = 0; i < size; i++){
        insert_values[i] = std::pair<int, int>(i, 0);
    }
    std::random_shuffle(insert_values.begin(), insert_values.end());

    std::cout << "-------------- test put and traverse -----------------" << std::endl;
    for (int i = 0; i < size; i++){
        int key = insert_values[i].first, value =  rand() % 100;
        insert_values[i].second = value;
        bTree.put(key, value);
    }
    std::vector<std::pair<int, int>> elements = bTree.traverse();
    std::sort(insert_values.begin(), insert_values.end());

    for (int i = 0; i < size; i++){
        std::pair<int, int> pa = insert_values[i];
        int v = bTree.search(pa.first);
        assert(v == elements[i].second);
        assert(v == pa.second);
    }
    std::cout << "end!" << std::endl;
    std::cout << "---------------- test remove ---------------" << std::endl;
    std::random_shuffle(insert_values.begin(), insert_values.end());
    for (int i = 0; i < size/2; i++){
        std::pair<int, int> remove_value = insert_values[0];
        insert_values.erase(insert_values.begin());
        bTree.remove(remove_value.first);
    }
    std::sort(insert_values.begin(), insert_values.end());
    for (int i = 0; i < size; i++){
        std::pair<int, int> pa = insert_values[i];
        int v = bTree.search(pa.first);
        assert(v == elements[i].second);
        assert(v == pa.second);
    }
    std::cout << "end!"<< std::endl;
}
