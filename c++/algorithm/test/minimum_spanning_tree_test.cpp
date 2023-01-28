#include <iostream>
#include <cassert>
#include "minimum_spanning_tree.h"

int main(){
    std::cout << "test prim" << endl;
    vector<vector<int>> edges({{0, 1, 4}, {0, 7, 8}, {1, 7, 11}, {1, 2, 8}, {2, 8, 2}, {2, 5, 4},
                                {2, 3, 7}, {3, 4, 9}, {3, 5, 14}, {4, 5, 10}, {5, 6, 2}, {6, 7, 1},
                               {6, 8, 6}, {7, 8, 7}});

    int min_weight = minimum_spanning_tree::prim(9, edges);
    assert(min_weight == 37);
    cout << "successful"  << endl;
    edges = {{0, 1, 4}, {0, 7, 8}, {1, 7, 11}, {1, 2, 8}, {2, 8, 2}, {2, 5, 4},
                                       {2, 3, 7}, {3, 4, 9}, {3, 5, 14}, {4, 5, 10}, {5, 6, 2}, {6, 7, 1},
                                       {6, 8, 6}, {7, 8, 7}};
    std::cout << "test kruskal" << endl;
    assert(37 == minimum_spanning_tree::kruskal(9, edges));
    cout << "successful" << endl;
}
