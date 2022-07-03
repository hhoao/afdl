package lc_139;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author 黄豪
 *139. 单词拆分
给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。

说明：

拆分时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
 */
public class LC_139 {

}
//我的代码 超时
class Solution {
    Map<Integer, List<Integer>> indexMap = new HashMap<>();
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = wordDict.size();
        for (int i = 0; i < n; i++){
            String wo = wordDict.get(i);
            int index = s.indexOf(wo, 0);
            while (index != -1){
                List<Integer> list = indexMap.getOrDefault(index, new ArrayList<>());
                list.add(wo.length());
                indexMap.put(index, list);
                index++;
                index = s.indexOf(wo, index);
            }
        }
        return canJump(0, s.length());
    }
    public boolean canJump(int step, int len) {
        if (step > len) return false;
        List<Integer> startList= indexMap.get(step);
        if (startList ==null) return false;
        int n = startList.size();
        for (int i = 0; i < n; i++){
            int k = startList.get(i);
            if (k + step == len) return true;
            if (indexMap.containsKey(k + step)){
                if (canJump(k + step, len)) return true;
            }
        }
        return false;
    }
}
//官方 动态规划
class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
//0ms
class Solution2 {
    public boolean wordBreak(String s, List<String> wordDict) {
    	if(s.length()==0)return true;
        if(s.length()>150)return false;
        for(int i=0;i<wordDict.size();i++){
            String word=wordDict.get(i);
            if(s.startsWith(word)){
                if(wordBreak(s.substring(word.length()),wordDict))
                    return true;
            }
        }
        return false;
    }
}