package lc_205;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 黄豪
 *205. 同构字符串
给定两个字符串 s 和 t，判断它们是否是同构的。

如果 s 中的字符可以按某种映射关系替换得到 t ，那么这两个字符串是同构的。

每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。
 */
public class LC_205 {

}
//我的代码
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] smapper = new int[256];
        boolean[] tmapper = new boolean[256];
        Arrays.fill(smapper, -1);
        int n = s.length();
        for (int i = 0; i < n; i++){
            int j = smapper[s.charAt(i)];
            
            if (j == -1 ){
                if (tmapper[t.charAt(i)] == true){
                    return false;
                }
                tmapper[t.charAt(i)] = true;
                smapper[s.charAt(i)] = t.charAt(i);
            }else{
                if (j != t.charAt(i)){
                    return false;
                }
            }
        }
        return true;
    }
}
//官方哈希表
class Solution1 {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> s2t = new HashMap<Character, Character>();
        Map<Character, Character> t2s = new HashMap<Character, Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
            char x = s.charAt(i), y = t.charAt(i);
            if ((s2t.containsKey(x) && s2t.get(x) != y) || (t2s.containsKey(y) && t2s.get(y) != x)) {
                return false;
            }
            s2t.put(x, y);
            t2s.put(y, x);
        }
        return true;
    }
}
