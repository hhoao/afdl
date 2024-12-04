package contest.lc_100340;

/**
 * LC_100340
 *
 * @author xianxing
 * @since 2024/6/30
 **/

public class LC_100340 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxHeightOfTriangle(2, 4));
        System.out.println(solution.maxHeightOfTriangle(10, 1));
    }
}

class Solution {
    public int maxHeightOfTriangle(int red, int blue) {
        return Math.max(getTier(red, blue), getTier(blue, red));
    }

    int getTier(int first, int second) {
        int i = 1;
        while (true) {
            if (i % 2 == 1) {
                if (first < i) {
                    break;
                }
                first -= i;
            } else {
                if (second < i) {
                    break;
                }
                second -= i;
            }
            i++;
        }
        return i - 1;
    }
}
