package lc_2586;

class Solution {
    public int vowelStrings(String[] words, int left, int right) {
        int v = 1;
        char[] y = new char[]{'a', 'e', 'i', 'o', 'u'};
        for (char c : y) {
            v |= 1 << (c - 'a');
        }
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (((1 << (words[i].charAt(0) - 'a')) & v) > 0 &&
                ((1 << (words[i].charAt(words[i].length() - 1) - 'a')) & v) > 0) {
                ans++;
            }
        }
        return ans;
    }
}
