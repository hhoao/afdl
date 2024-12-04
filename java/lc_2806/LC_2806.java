package lc_2806;

/**
 * LC_2806
 *
 * @author xianxing
 * @since 2024/6/12
 **/

public class LC_2806 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.accountBalanceAfterPurchase(15));
    }
}

class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        return 100 - (purchaseAmount + 5) / 10 * 10;
    }
}

class Solution1 {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        return 100 - (purchaseAmount / 10 * 10 + (purchaseAmount % 10 >= 5 ? 10 : 0));
    }
}
