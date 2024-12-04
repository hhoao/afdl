package lc_2734;

/**
 * LC_2734
 *
 * @author xianxing
 * @since 2024/6/27
 **/

public class LC_2734 {
}


class Solution {
    public String smallestString(String s) {
        StringBuilder res = new StringBuilder();
        boolean acceptA = s.charAt(0) == 'a';
        boolean end = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (end) {
                res.append(c);
            } else if (c == 'a') {
                if (acceptA) {
                    res.append('a');
                } else {
                    end = true;
                }
            } else {
                res.append(c - 1);
                acceptA = false;
            }
        }
        return res.toString();
    }
}
