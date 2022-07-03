package lc_357;

/*
 *@author: »ÆºÀ
 *@date : 2021Äê10ÔÂ27ÈÕ
 *@todo:
*/
public class LC_357 {

}
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0){
            return 1;
        }
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i <= n; i++){
            dp[i] = 10 * dp[i - 1] + (i - 1) * (9 * (int)Math.pow(10, i - 2) - dp[i - 1]);
        }
        int sum = 0;
        for (int i = 2; i <= n; i++){
            sum += dp[i];
        }
        return (int)Math.pow(10, n) - sum;
    }
}