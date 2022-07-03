package lc_383;

/*
 *@author: 黄豪
 *@date : 2021年12月17日
 *@todo:383. 赎金信
给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。

如果可以，返回 true ；否则返回 false 。

magazine 中的每个字符只能在 ransomNote 中使用一次。
*/
public class LC_383 {

}
//遍历
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] words1 = new int[26];
        int[] words2 = new int[26];
        int n = ransomNote.length(), m = magazine.length();
        for (int i = 0; i < n; i++){
            words1[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < m; i++){
            words2[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++){
            if (words1[i] > words2[i]) return false;
        }
        return true;
    }
}
class Solution1 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] words1 = new int[26];
        int[] words2 = new int[26];
        int n = ransomNote.length(), m = magazine.length();
        
        for (int i = 0; i < m; i++){
            words2[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++){
            int k = ransomNote.charAt(i) - 'a';
            words1[k]++;
            if (words1[k] > words2[k]) return false;
        }
        return true;
    }
}