package lc_208;

import java.util.HashSet;
import java.util.Set;

/**
 * @author 黄豪
 *208. 实现 Trie (前缀树)
Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。

请你实现 Trie 类：

Trie() 初始化前缀树对象。
void insert(String word) 向前缀树中插入字符串 word 。
boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 */
public class LC_208 {

}
//我的代码
class Trie {
    private Set<String> dic;
    /** Initialize your data structure here. */
    public Trie() {
        this.dic = new HashSet<String>();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        dic.add(word);
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return dic.contains(word);
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        for (String str : dic){
            if (str.startsWith(prefix)){
                return true;
            }
        }
        return false;
    }
}
//改良
class Trie1 {
    public  Trie1[] tries;
    public  boolean isEnd;

    public Trie1() {
        this.tries = new Trie1[26];
        this.isEnd = false;
    }
    
    public void insert(String word) {
        Trie1 trie = this;
        int n = word.length();
        for (int i = 0; i < n; i++){
            char ch = word.charAt(i);
            int index=  ch - 'a';
            if (trie.tries[index] == null) 
                trie.tries[index] = new Trie1();
            trie = trie.tries[index];
        }
        trie.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie1 trie = this;
        int n = word.length();
        for (int i = 0; i < n; i++){
            int index = word.charAt(i) - 'a';
            if (trie.tries[index] == null){
                return false;
            }
            trie = trie.tries[index];
        }
        return trie.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        Trie1 trie = this;
        int n = prefix.length();
        for (int i = 0; i < n; i++){
            int index = prefix.charAt(i) - 'a';
            if (trie.tries[index] == null){
                return false;
            }
            trie = trie.tries[index];
        }
        return true;
    }
}
//官方
class Trie2 {
    private Trie2[] children;
    private boolean isEnd;

    public Trie2() {
        children = new Trie2[26];
        isEnd = false;
    }
    
    public void insert(String word) {
        Trie2 node = this;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                node.children[index] = new Trie2();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }
    
    public boolean search(String word) {
        Trie2 node = searchPrefix(word);
        return node != null && node.isEnd;
    }
    
    public boolean startsWith(String prefix) {
        return searchPrefix(prefix) != null;
    }

    private Trie2 searchPrefix(String prefix) {
        Trie2 node = this;
        for (int i = 0; i < prefix.length(); i++) {
            char ch = prefix.charAt(i);
            int index = ch - 'a';
            if (node.children[index] == null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
