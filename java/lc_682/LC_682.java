package lc_682;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LC_682
 *
 * @author xianxing
 * @since 2024/7/29
 **/

public class LC_682 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.calPoints(new String[]{"5","-2","4","C","D","9","+","+"});
        System.out.println(i);
    }
}

class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> queue = new ArrayDeque<>();
        int res = 0;
        for (String operation : operations) {
            if (operation.equals("+")) {
                Integer first = queue.pop();
                int score = first + queue.peek();
                res += score;
                queue.push(first);
                queue.push(score);
            } else if (operation.equals("D")) {
                int score = queue.peek() * 2;
                res += score;
                queue.push(score);
            } else if (operation.equals("C")) {
                res -= queue.pop();
            } else {
                int i = Integer.parseInt(operation);
                queue.push(i);
                res += i;
            }
        }
        return res;
    }
}
