package lc_2034;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

/*
 *@author: 黄豪
 *@date : 2022年1月23日
 *@todo:2034. 股票价格波动
给你一支股票价格的数据流。数据流中每一条记录包含一个 时间戳 和该时间点股票对应的 价格 。

不巧的是，由于股票市场内在的波动性，股票价格记录可能不是按时间顺序到来的。某些情况下，有的记录可能是错的。如果两个有相同时间戳的记录出现在数据流中，前一条记录视为错误记录，后出现的记录 更正 前一条错误的记录。

请你设计一个算法，实现：

更新 股票在某一时间戳的股票价格，如果有之前同一时间戳的价格，这一操作将 更正 之前的错误价格。
找到当前记录里 最新股票价格 。最新股票价格 定义为时间戳最晚的股票价格。
找到当前记录里股票的 最高价格 。
找到当前记录里股票的 最低价格 。
请你实现 StockPrice 类：

StockPrice() 初始化对象，当前无股票价格记录。
void update(int timestamp, int price) 在时间点 timestamp 更新股票价格为 price 。
int current() 返回股票 最新价格 。
int maximum() 返回股票 最高价格 。
int minimum() 返回股票 最低价格 。
 

示例 1：

输入：
["StockPrice", "update", "update", "current", "maximum", "update", "maximum", "update", "minimum"]
[[], [1, 10], [2, 5], [], [], [1, 3], [], [4, 2], []]
输出：
[null, null, null, 5, 10, null, 5, null, 2]

解释：
StockPrice stockPrice = new StockPrice();
stockPrice.update(1, 10); // 时间戳为 [1] ，对应的股票价格为 [10] 。
stockPrice.update(2, 5);  // 时间戳为 [1,2] ，对应的股票价格为 [10,5] 。
stockPrice.current();     // 返回 5 ，最新时间戳为 2 ，对应价格为 5 。
stockPrice.maximum();     // 返回 10 ，最高价格的时间戳为 1 ，价格为 10 。
stockPrice.update(1, 3);  // 之前时间戳为 1 的价格错误，价格更新为 3 。
                          // 时间戳为 [1,2] ，对应股票价格为 [3,5] 。
stockPrice.maximum();     // 返回 5 ，更正后最高价格为 5 。
stockPrice.update(4, 2);  // 时间戳为 [1,2,4] ，对应价格为 [3,5,2] 。
stockPrice.minimum();     // 返回 2 ，最低价格时间戳为 4 ，价格为 2 。
*/
public class LC_2034 {

}
//哈希表+有序列表
class StockPrice {
    private Integer lastTimeStamp;
    private Map<Integer, Integer> stockPriceMap;
    private TreeMap<Integer, Set<Integer>> priceRank;
    public StockPrice() {
        stockPriceMap = new HashMap<>();
        priceRank = new TreeMap<>();
        lastTimeStamp = null;
    }
    
    public void update(int timestamp, int price) {
        Integer prePrice = stockPriceMap.get(timestamp);
        if (prePrice != null){
            Set<Integer> timeSet =  priceRank.get(prePrice);
            timeSet.remove(timestamp);
            if (timeSet.isEmpty()){
                priceRank.remove(prePrice);
            }
        }
        lastTimeStamp = lastTimeStamp != null ? Math.max(timestamp, lastTimeStamp) : timestamp;
        stockPriceMap.put(timestamp, price);
        Set<Integer> timeSet = priceRank.get(price);
        if (timeSet == null){
            timeSet = new HashSet<>();
            priceRank.put(price, timeSet);
            timeSet.add(timestamp);
        }else{
            timeSet.add(timestamp);
        }
    }
    
    public int current() {
        return stockPriceMap.get(lastTimeStamp);
    }
    
    public int maximum() {
        return priceRank.lastKey();
    }
    
    public int minimum() {
        return priceRank.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
//哈希表+两个堆
class StockPrice1 {
    private Integer lastTimeStamp;
    private Map<Integer, Integer> stampMap;
    private PriorityQueue<int[]> minHeap;
    private PriorityQueue<int[]> maxHeap;
    public StockPrice1() {
        lastTimeStamp = 0;
        stampMap = new HashMap<>();
        minHeap = new PriorityQueue<>((a, b)->a[0] - b[0]);
        maxHeap = new PriorityQueue<>((a, b)->b[0] - a[0]);
    }
    
    public void update(int timestamp, int price) {
        stampMap.put(timestamp, price);
        minHeap.offer(new int[]{price, timestamp});
        maxHeap.offer(new int[]{price, timestamp});
        lastTimeStamp = Math.max(timestamp, lastTimeStamp);
    }
    
    public int current() {
        return stampMap.get(lastTimeStamp);
    }
    
    public int maximum() {
        while (true){
            int[] maxPrice = maxHeap.peek();
            if (stampMap.get(maxPrice[1]) == maxPrice[0]){
                return maxPrice[0];
            }else{
                maxHeap.poll();  
            }
        }
    }
    
    public int minimum() {
        while (true){
            int[] minPrice = minHeap.peek();
            if (stampMap.get(minPrice[1]) == minPrice[0]){
                return minPrice[0];
            }else{
                minHeap.poll();  
            }
        }
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */
