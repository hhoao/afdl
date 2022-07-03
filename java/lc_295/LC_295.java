package lc_295;

import java.util.PriorityQueue;

/*
 *@author: 黄豪
 *@date : 2021年9月8日
 *@todo:题目描述
评论 (326)
题解 (493)
提交记录
295. 数据流的中位数
中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。

例如，

[2,3,4] 的中位数是 3

[2,3] 的中位数是 (2 + 3) / 2 = 2.5

设计一个支持以下两种操作的数据结构：

void addNum(int num) - 从数据流中添加一个整数到数据结构中。
double findMedian() - 返回目前所有元素的中位数。
*/
public class LC_295 {
	public static void main(String[] args) {
		MedianFinder m = new MedianFinder();
		m.addNum(1);
		m.addNum(2);
		m.findMedian();
	}
}

class MedianFinder {

    /** initialize your data structure here. */
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;
    public MedianFinder() {
        minHeap = new PriorityQueue<>((a, b) -> a - b);
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }
    
    public void addNum(int num) {
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
        Integer minPeek = minHeap.peek();
        Integer maxPeek = maxHeap.peek();
        if (minSize <= maxSize){
            if (maxPeek != null && maxPeek > num){
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            }else{
                minHeap.offer(num);
            }
        }else{
            if (minPeek != null && minPeek < num){
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }else{
                maxHeap.offer(num);
            }
        }
        
    }
    
    public double findMedian() {
        int minSize = minHeap.size();
        int maxSize = maxHeap.size();
        if (minSize < maxSize){
            return maxHeap.peek();
        }else if (minSize > maxSize){
            return minHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }
}
