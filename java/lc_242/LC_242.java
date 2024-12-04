package lc_242;

/**
 * @author 黄豪
 *242. 有效的字母异位词
给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 */
public class LC_242 {

}
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int n = s.length();
        int[] smap = new int[26];
        int[] tmap = new int[26];
        for (int i = 0; i < n; i++){
            smap[s.charAt(i) - 'a']++;
            tmap[t.charAt(i) - 'a']++;
        }
        for (int i =0 ; i< 26; i++){
            if (smap[i] != tmap[i]){
                return false;
            }
        }
        return true;
    }
}
