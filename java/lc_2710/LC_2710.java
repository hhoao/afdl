package lc_2710;

/**
 * LC_2710
 *
 * @author xianxing
 * @since 2024/6/29
 **/

public class LC_2710 {
}


class Solution {
    public String removeTrailingZeros(String num) {
        int i = num.length() - 1;
        while (num.charAt(i) == '0') {
            i--;
        }
        return num.substring(0, i+1);
    }
}
