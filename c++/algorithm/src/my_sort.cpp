//
// Created by hhoa on 23-1-19.
//

#include "vector"
#include "my_sort.h"

using namespace std;

void swap(int *i, int j, int k) {
    int f;

    f = i[j];
    i[j] = i[k];
    i[k] = f;
}

void my_sort::bubble_sort(vector<int> &arr) {
    int i;
    int j;

    for (i = 0; i < arr.size(); i++) {
        for (j = 0; j < arr.size() - 1 - i; j++) {
            if (arr[j] > arr[j + 1]) {
                arr[j] ^= arr[j + 1];
                arr[j + 1] ^= arr[j];
                arr[j] ^= arr[j + 1];
            }
        }
    }
}

void max_heapify(vector<int> &arr, int index, unsigned long heap_size) {
    int l, r;

    l = index * 2 + 1;
    r = index * 2 + 2;

    int largest = index;
    if (l <= heap_size && arr[l] > arr[largest]) {
        largest = l;
    }
    if (r <= heap_size && arr[r] > arr[largest]) {
        largest = r;
    }
    if (largest != index) {
        arr[index] ^= arr[largest];
        arr[largest] ^= arr[index];
        arr[index] ^= arr[largest];
        max_heapify(arr, largest, heap_size);
    }
}

void build_max_heap(vector<int> &arr) {
    for (int i = (int) (arr.size() - 1) / 2; i >= 0; i--) {
        max_heapify(arr, i, arr.size() - 1);
    }
}

void my_sort::heap_sort(vector<int> &arr) {
    build_max_heap(arr);
    unsigned long heap_size = arr.size() - 1;
    for (unsigned long i = arr.size() - 1; i > 0; i--) {
        arr[i] ^= arr[0];
        arr[0] ^= arr[i];
        arr[i] ^= arr[0];
        heap_size--;
        max_heapify(arr, 0, heap_size);
    }
}

int find_pos(vector<int> &arr, int low, int high) {
    int val = arr[low];

    while (low < high) {
        while (low < high && arr[high] >= val)
            --high;
        arr[low] = arr[high];

        while (low < high && arr[low] <= val)
            ++low;
        arr[high] = arr[low];
    }
    arr[high] = val;

    return high;
}

void my_sort::quick_sort(vector<int> &arr, int low, int high) {
    int pos;
    if (low < high) {
        pos = find_pos(arr, low, high);
        quick_sort(arr, low, pos - 1);
        quick_sort(arr, pos + 1, high);
    }
}

void my_sort::quick_sort(vector<int> &arr) {
    quick_sort(arr, 0, (int) arr.size() - 1);
}

void my_sort::odd_even_sort(vector<int> &arr) {
    int i, flag1, flag2, temp;
    flag1 = 1;
    flag2 = 0;
    int k = 0;
    while (true) {
        flag2 = 0;
        for (i = k; i < arr.size() - 1; i += 2) {
            if (arr[i] > arr[i + 1]) {
                temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
                flag2 = 1;
            }
        }
        if (flag1 == 0 && flag2 == 0) {
            return;
        } else {
            flag1 = flag2;
            k = (k + 1) % 2;
        }
    }
}
