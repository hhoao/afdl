package lc_1452;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@author: 黄豪
 *@date : 2021年12月20日
 *@todo:1452. 收藏清单
给你一个数组 favoriteCompanies ，其中 favoriteCompanies[i] 是第 i 名用户收藏的公司清单（下标从 0 开始）。

请找出不是其他任何人收藏的公司清单的子集的收藏清单，并返回该清单下标。下标需要按升序排列。
*/
public class LC_1452 {
	public static void main(String[] args) {
		List<List<String>> list = new ArrayList<>();
		list.add(Arrays.asList("leetcode","google","facebook"));
		list.add(Arrays.asList("google","microsoft"));
		list.add(Arrays.asList("google","facebook"));
		list.add(Arrays.asList("google"));
		list.add(Arrays.asList("amazon"));
		System.out.println(new Solution().peopleIndexes(list));
	}
}
//字典树
class Solution {
    class Node{
        Node[] words;
        boolean isEnd;
        List<Integer> companys;
        Node(){
            words = new Node[26];
            isEnd = false;
        }
        public void insert(String str, Integer company){
            char[] cs = str.toCharArray();
            int n = str.length();
            Node curNode = this;
            for (int i = 0; i < n; i++){
                if (curNode.words[cs[i] - 'a'] == null){
                    curNode.words[cs[i] - 'a'] = new Node();
                }
                curNode = curNode.words[cs[i] - 'a'];
            }
            
            if (!curNode.isEnd){
                curNode.isEnd = true;
                curNode.companys = new ArrayList<>();
                curNode.companys.add(company);
            }else{
                curNode.companys.add(company);
            }
        }
        public List<Integer> getCompanys(String str){
            char[] cs = str.toCharArray();
            int n = str.length();
            Node curNode = this;
            for (int i = 0; i < n; i++){
                if (curNode.words[cs[i] - 'a'] == null){
                    return null;
                }else{
                    curNode = curNode.words[cs[i] - 'a'];
                }
            }
            return curNode.companys;
        }
    }
    Node dictionary;
    
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        dictionary = new Node();
        int n = favoriteCompanies.size();
        Map<List<String>, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++){
            indexMap.put(favoriteCompanies.get(i), i);
        } 
        Collections.sort(favoriteCompanies, (a, b)->{
           return b.size() - a.size(); 
        });
        List<Integer> ret = new ArrayList<>();
        for (int i = 0; i < n; i++){
            Map<Integer, Integer> companySigns = new HashMap<>();
            List<String> collect = favoriteCompanies.get(i);
            Integer index = indexMap.get(collect);
            boolean isSon = false;
            int m = collect.size();
            for (int j = 0; j < m; j++){
                List<Integer> companys = dictionary.getCompanys(collect.get(j));
                if (companys != null){
                    for (Integer company : companys){
                        Integer companySign;
                        companySign = companySigns.getOrDefault(company, 0) + 1;
                        companySigns.put(company, companySign);
                        if (companySign == m){
                            isSon = true;
                        }
                    }
                }
                dictionary.insert(collect.get(j), index);
            }
            if (!isSon){
                ret.add(index);
            }
        }
        Collections.sort(ret);
        return ret;
    }
}
