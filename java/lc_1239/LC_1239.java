package lc_1239;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *@author: 黄豪
 *@date : 2021年12月2日
 *@todo:1239. 串联字符串的最大长度
给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。

请返回所有可行解 s 中最长长度。
*/
public class LC_1239 {

}
//暴力
class Solution {
    public int dfs(boolean[] hasWord, int k, List<String> arr){
        int n = arr.size();
        int l = 0;
        for (int i = k; i < n; i++){
            String str = arr.get(i);
            int strlen = str.length();
            boolean hasCom = false;
            boolean[] copyArr = Arrays.copyOf(hasWord, 26);
            for (int j = 0; j < strlen; j++){
                if (copyArr[str.charAt(j) - 'a']) {
                    hasCom =true;
                    break;
                }else{
                    copyArr[str.charAt(j) - 'a'] = true;
                }
            }
            if (!hasCom){
                for (int j = 0; j < strlen; j++){
                    copyArr[str.charAt(j) - 'a'] = true;
                }
                l = Math.max(l, dfs(copyArr, i, arr)+strlen);
            }
        }
        return l;
    }
    public int maxLength(List<String> arr) {
        int s = arr.size();
        return dfs(new boolean[26], 0, arr);
    }
}
//迭代+位运算
class Solution1 {
    public int maxLength(List<String> arr) {
        int ans = 0;
        List<Integer> masks = new ArrayList<Integer>();
        masks.add(0);
        for (String s : arr) {
            int mask = 0;
            for (int i = 0; i < s.length(); ++i) {
                int ch = s.charAt(i) - 'a';
                if (((mask >> ch) & 1) != 0) { // 若 mask 已有 ch，则说明 s 含有重复字母，无法构成可行解
                    mask = 0;
                    break;
                }
                mask |= 1 << ch; // 将 ch 加入 mask 中
            }
            if (mask == 0) {
                continue;
            }
            int n = masks.size();
            for (int i = 0; i < n; ++i) {
                int m = masks.get(i);
                if ((m & mask) == 0) { // m 和 mask 无公共元素
                    masks.add(m | mask);
                    ans = Math.max(ans, Integer.bitCount(m | mask));
                }
            }
        }
        return ans;
    }
}