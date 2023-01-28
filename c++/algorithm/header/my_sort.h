//
// Created by hhoa on 23-1-19.
//
#include "vector"

using namespace std;

#ifndef ALGORITHM_SORT_H
#define ALGORITHM_SORT_H


class my_sort {
public:
    /**
     * 冒泡排序
     * @param arr 需要排序的数组
     */
    static void bubble_sort(vector<int> &arr);
    /**
     * 堆排序
     * @param arr
     */
    static void heap_sort(vector<int> &arr);
    /**
     * 快速排序
     * @param arr 需要排序的数组
     */
    static void quick_sort(vector<int> &arr);
    /**
     * 快速排序
     * @param arr 需要排序的数组
     * @param start 起始位置
     * @param end 终点位置
     */
    static void quick_sort(vector<int> &arr, int start, int end);
    /**
     * 奇偶排序
     * 奇偶交换排序如下所述：第一趟对所有奇数i，将a[i]和a[i+1]进行比较；第二趟对所有的偶数i，将a[i]和a[i+1]进行比较，若a[i]>a[i+1]，则将两者交换；第三趟对奇数i；第四趟对偶数i，…，依次类推直至整个序列有序为止。
     * @param arr 需要排序的数组
     */
    static void odd_even_sort(vector<int> &arr);
};


#endif //ALGORITHM_SORT_H
