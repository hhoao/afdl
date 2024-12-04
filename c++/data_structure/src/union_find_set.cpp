//
// Created by hhoa on 23-1-28.
//
#include "union_find_set.h"

int union_find_set::find(int i) {
    return fa[i] == i ? i : (fa[i] = find(fa[i]));
}

void union_find_set::merge(int i, int j) {
    int x = find(i), y = find(j);
    if (rank[x] <= y) {
        fa[x] = y;
    } else {
        fa[y] = x;
    }
    if (x != y && rank[x] == rank[y]) {
        rank[y]++;
    }
}
