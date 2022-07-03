package lc_140;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 黄豪
 *140. 单词拆分 II
给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。

说明：

分隔时可以重复使用字典中的单词。
你可以假设字典中没有重复的单词。
 */
public class LC_140 {

}
//我的代码
class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        getList(s, wordDict, ans, new StringBuffer());
        return ans;
    }
    public void getList(String s, List<String> wordDict, List<String> ans, StringBuffer sublist){
        if (s.length() == 0) {
            StringBuffer temp = new StringBuffer(sublist);
            temp.delete(sublist.length() - 1, sublist.length());
            ans.add(temp.toString());
            return;
        }
        int n = wordDict.size();
        for (int i =0; i < n; i++){
            String word = wordDict.get(i);
            if (s.startsWith(word)){
                String addWord = word + " ";
                sublist.append(addWord);
                getList(s.substring(word.length()), wordDict, ans, sublist); 
                sublist.delete(sublist.length()- addWord.length(), sublist.length());
            }
        }
    }
}