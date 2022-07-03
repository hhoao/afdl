package lc_155;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * @author 黄豪
 *155. 最小栈
设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。

push(x) —— 将元素 x 推入栈中。
pop() —— 删除栈顶的元素。
top() —— 获取栈顶元素。
getMin() —— 检索栈中的最小元素。
 */
public class LC_155 {

}
//我的代码
class MinStack {
    private Deque<Integer> stack;
    private PriorityQueue<Integer> queue;
    public MinStack() {
        stack = new ArrayDeque<>();
        queue = new PriorityQueue<Integer>();
    }
    
    public void push(int val) {
        stack.add(val);
        queue.add(val);
    }
    
    public void pop() {
        int i = stack.pop();
        queue.remove(i);
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return queue.peek();
    }
}
//辅助栈
class MinStack1 {
    Deque<Integer> xStack;
    Deque<Integer> minStack;

    public MinStack1() {
        xStack = new LinkedList<Integer>();
        minStack = new LinkedList<Integer>();
        minStack.push(Integer.MAX_VALUE);
    }
    
    public void push(int x) {
        xStack.push(x);
        minStack.push(Math.min(minStack.peek(), x));
    }
    
    public void pop() {
        xStack.pop();
        minStack.pop();
    }
    
    public int top() {
        return xStack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}