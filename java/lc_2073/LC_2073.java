package lc_2073;


import java.util.ArrayDeque;

/**
 * LC_2073
 *
 * @author w
 * @since 2024/9/29
 **/

public class LC_2073 {
}

class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ticket = tickets[k];
        int ans = ticket - 1;
        for (int i = 0; i < tickets.length; i++) {
            if (i < k) {
                ans += Math.min(ticket, tickets[i]);
            } else {
                ans = Math.min(ticket - 1, tickets[i]);
            }
        }
        return ans;
    }
}
