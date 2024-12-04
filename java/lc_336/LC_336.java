package lc_336;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 *@author: 黄豪
 *@date : 2021年12月14日
 *@todo:336. 回文对
给定一组 互不相同 的单词， 找出所有 不同 的索引对 (i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。
*/
public class LC_336 {
	public static void main(String[] args) {
		Solution solution = new Solution();
		solution.palindromePairs(new String[] {"abcd","dcba","lls","s","sssll"});
	}
}
//字典树+暴力
class Solution {
    class Node{
        Node[] word;
        int flag;
        public Node(){
            word = new Node[26];
            this.flag = -1;
        }
    }
    private Node dictionary;

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = words.length;
        dictionary = new Node();
        for (int i = 0; i < n; i++){
            insert(words[i].toCharArray(), i);
        }
        for (int i = 0; i < n; i++){
            char[] word = words[i].toCharArray();
            int m = word.length;
            for (int j = 0; j <= m; j++){
                if (isPalindromic(word, j, m - 1)){
                    int leftId = find(word, 0, j - 1);
                    if (leftId != -1 && leftId != i){
                        ans.add(Arrays.asList(i, leftId));
                    }
                }
                if (j != 0 && isPalindromic(word, 0, j - 1)){
                    int rightId = find(word, j, m - 1);
                    if (rightId != -1 && rightId != i){
                        ans.add(Arrays.asList(rightId, i));
                    }
                }
            }
        }
        return ans;
    }
    private int find(char[] word, int l, int r){
        Node curNode = dictionary;
        for (int i = r; i >= l; i--){
            char c = word[i];
            if (curNode.word[c - 'a'] == null){
                return -1;
            }else{
                curNode = curNode.word[c - 'a'];
            }
        }
        return curNode.flag;
    }
    private void insert(char[] s, int flag){
        Node curNode = dictionary;
        int n = s.length;
        for (int i = 0; i < n; i++){
        	if (curNode.word[s[i] - 'a'] == null) {
        		curNode.word[s[i] - 'a'] = new Node();
        	}
            curNode = curNode.word[s[i] - 'a'];
        }
        curNode.flag = flag;
    }
    private boolean isPalindromic(char[] word, int l, int r){
        while (l < r){
            if (word[l] != word[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
