package lc_127;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * @author 黄豪
 *127. 单词接龙
字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：

序列中第一个单词是 beginWord 。
序列中最后一个单词是 endWord 。
每次转换只能改变一个字母。
转换过程中的中间单词必须是字典 wordList 中的单词。
给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中的 单词数目 。如果不存在这样的转换序列，返回 0。
 */
public class LC_127 {
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		String beginWord = "hit";
		String endWord = "cog";
		list.add("hot");
		list.add("dot");
		list.add("dog");
		list.add("lot");
		list.add("log");
		list.add("cog");
		System.out.println(new Solution2().ladderLength(beginWord, endWord, list));
	}

}
class Solution {
    Map<String, Integer> wordId = new HashMap<String, Integer>();
    List<List<Integer>> edge = new ArrayList<List<Integer>>();
    int nodeNum = 0;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        for (String word : wordList) {
            addEdge(word);
        }
        addEdge(beginWord);
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        int[] dis = new int[nodeNum];
        Arrays.fill(dis, Integer.MAX_VALUE);
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[beginId] = 0;

        Queue<Integer> que = new LinkedList<Integer>();
        que.offer(beginId);
        while (!que.isEmpty()) {
            int x = que.poll();
            if (x == endId) {
                return dis[endId] / 2 + 1;
            }
            for (int it : edge.get(x)) {
                if (dis[it] == Integer.MAX_VALUE) {
                    dis[it] = dis[x] + 1;
                    que.offer(it);
                }
            }
        }
        return 0;
    }

    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; ++i) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            int id2 = wordId.get(newWord);
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<Integer>());
        }
    }
}
class Solution1 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (!set.contains(endWord))
            return 0;
        Queue<String> q1 = new LinkedList<>();
        q1.add(beginWord);
        Queue<String> q2 = new LinkedList<>();
        q2.add(endWord);
        Set<String> s1 = new HashSet<>();
        s1.add(beginWord);
        Set<String> s2 = new HashSet<>();
        s2.add(endWord);
        int ans = 0;
        while (!q1.isEmpty() && !q2.isEmpty()) {
            ans++;
            if (q1.size() > q2.size()) {
                Queue<String> temp = q1;
                q1 = q2;
                q2 = temp;
                Set<String> s = new HashSet<>();
                s = s1;
                s1 = s2;
                s2 = s;
            }
            int size = q1.size();
            while (size-- > 0) {
                String s = q1.poll();
                char[] cc = s.toCharArray();
                for (int i = 0; i < cc.length; i++) {
                    char old = cc[i];
                    for (char j = 'a'; j <= 'z'; j++) {
                        if (old == j)
                            continue;
                        cc[i] = j;
                        String tt = new String(cc);
                        if (!set.contains(tt))
                            continue;
                        if (s1.contains(tt))
                            continue;
                        if (s2.contains(tt))
                            return ans + 1;
                        s1.add(tt);
                        q1.add(tt);
                    }
                    cc[i] = old;
                }
            }
        }
        return 0;
    }
}
class Solution2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        Set<String> visited = new HashSet<>();
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        int step = 1;
        visited.add(beginWord);
        visited.add(endWord);
        beginSet.add(beginWord);
        endSet.add(endWord);
        while(!beginSet.isEmpty() && !endSet.isEmpty()){
            step++;
            if(beginSet.size() > endSet.size()){
                Set<String> tmp = new HashSet<>();
                tmp = beginSet;
                beginSet = endSet;
                endSet = tmp;
            }

            Set<String> newBeginSet = new HashSet<>();
            for(String word:beginSet){
                if(changeLetter(word,wordSet,visited,newBeginSet,endSet)) return step;
            }
            beginSet = newBeginSet;
        }
        return 0;
    }

    public boolean changeLetter(String s,Set<String> wordSet,Set<String> visited,Set<String> newBeginSet, Set<String> endSet){
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            char c = chars[i];
            for(char j = 'a'; j <= 'z'; j++){
                if(c == j) continue;
                chars[i] = j;
                String newStr = new String(chars);
                if(!wordSet.contains(newStr)) continue;
                if(endSet.contains(newStr)) return true;
                if(visited.contains(newStr)) continue;
                newBeginSet.add(newStr);
                visited.add(newStr);
            }
            chars[i] = c;
        }
        return false;
    }
}