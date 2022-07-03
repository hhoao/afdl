package lc_290;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
 *@author: 黄豪
 *@date : 2021年5月8日
 *@todo:290. 单词规律
给定一种规律 pattern 和一个字符串 str ，判断 str 是否遵循相同的规律。

这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应规律。
*/
public class LC_290 {

}
//我的代码
class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        String[] strs = s.split(" ");
        if (pattern.length() != strs.length) return false;
        for (int i = 0; i < pattern.length(); i++){
            char ch = pattern.charAt(i);
            
            if (!map.containsKey(ch)){
                if (set.contains(strs[i])) return false;
                map.put(ch, strs[i]);
                set.add(strs[i]);
            }else{
                if (!map.get(ch).equals(strs[i])){
                    return false;
                }
            }
        }
        return true;
    }
}