#pragma once
#include <vector>

using namespace std;


/**
 * 优先队列
**/
class PriorityQueue {
private:
	vector<int> data;
    /**
     * 获取左节点
     * @param i 下标
     * @return  左节点下标
     */
	int left(int i);
    /**
     * 获取右节点
     * @param i 下标
     * @return 右节点下标
     */
	int right(int i);
    /**
     * 获取父节点
     * @param i 下标
     * @return 父节点下标
     */
	int parent(int i);
    /**
     * 比较两个元素
     * @param o1 元素1
     * @param o2 元素2
     * @return
     */
	int compare(int o1, int o2);
    /**
     * 交换元素
     * @param i i
     * @param j j
     */
	void swap(int i, int j);
    /**
     * 大堆化
     * @param i 下标
     */
    void maxHeapify(int i);
    /**
     * 建堆
     */
    void build();
public:
    /**
     * 向队列中放入元素
     * @param data
     */
	void offer(int data);
    /**
     * 弹出最顶部元素
     * @return
     */
	int poll();
    /**
     * 获取最顶部元素
     * @return num
     */
	int peek();
    /**
     * 清空队列
     */
	void clean();
    /**
     * 优先队列大小
     * @return
     */
	int size();
    /**
     * 移除元素
     * @param num
     * @return
     */
	bool remove(int num);
    /**
     *
     * @param num
     * @return
     */
    bool contains(int num);

    void siftDown(int i, int moved);

    void siftUp(int index, int k);
};

