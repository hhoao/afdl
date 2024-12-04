package lc_202;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author 黄豪
 *202. 快乐数
编写一个算法来判断一个数 n 是不是快乐数。

「快乐数」定义为：

对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
如果 可以变为  1，那么这个数就是快乐数。
如果 n 是快乐数就返回 true ；不是，则返回 false 。
 */
public class LC_202 {

}
//我的代码
class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1){
            int sum = 0;
            while (n != 0){
                int i = n %10;
                n /= 10;
                sum = sum + i * i;
            }
            
            if (set.contains(sum)) return false;
            set.add(sum);
            n = sum;
        }
        return true;
    }
}
//快慢指针
class Solution1 {

    public int getNext(int n) {
       int totalSum = 0;
       while (n > 0) {
           int d = n % 10;
           n = n / 10;
           totalSum += d * d;
       }
       return totalSum;
   }

   public boolean isHappy(int n) {
       int slowRunner = n;
       int fastRunner = getNext(n);
       while (fastRunner != 1 && slowRunner != fastRunner) {
           slowRunner = getNext(slowRunner);
           fastRunner = getNext(getNext(fastRunner));
       }
       return fastRunner == 1;
   }
}
//方法三：数学
class Solution2 {
    private static Set<Integer> cycleMembers =
        new HashSet<>(Arrays.asList(4, 16, 37, 58, 89, 145, 42, 20));

    public int getNext(int n) {
        int totalSum = 0;
        while (n > 0) {
            int d = n % 10;
            n = n / 10;
            totalSum += d * d;
        }
        return totalSum;
    }


    public boolean isHappy(int n) {
        while (n != 1 && !cycleMembers.contains(n)) {
            n = getNext(n);
        }
        return n == 1;
    }
}
