package lc_522;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * LC_522
 *
 * @author xianxing
 * @since 2024/6/17
 **/

public class LC_522 {
    public static void main(String[] args) {
        Solution solution = new Solution();
//        int luSlength = solution.findLUSlength(new String[]{"j","j","viez","ogk","ogk","lfn","ypmhwx","ypmhwx","m","m","ak","ivivzoncju","ivivzoncju","wmybi","wmybi","dyzfjg","dyzfjg"});
//        int luSlength = solution.findLUSlength(new String[]{"aaa", "aaa", "aa"});
//        int luSlength = solution.findLUSlength(new String[]{"abaa","abaa","eaec","eaec","eae","z"});
        int luSlength = solution.findLUSlength(new String[]{"aabbcc", "aabbcc","c","e"});
        System.out.println(luSlength);
    }
}

class Solution {
    public int findLUSlength(String[] strs) {
        Arrays.sort(strs, (str1, str2) -> str2.length() - str1.length());

        Map<String, Integer> topMap = new HashMap<>();
        Map<String, Integer> tierMap = new HashMap<>();
        int curLength = strs[0].length();
        tierMap.put(strs[0], 1);
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            if (str.length() != curLength) {
                int currentLength = getCurrentLength(topMap, tierMap);
                if (currentLength != -1) {
                    return currentLength;
                }

                curLength = str.length();
                tierMap = new HashMap<>();
            }
            tierMap.compute(str, (k, v) -> {
                if (v == null) {
                    return 1;
                }
                return v + 1;
            });
        }
        return getCurrentLength(topMap, tierMap);
    }

    int getCurrentLength(Map<String, Integer> topMap, Map<String, Integer> tierMap) {
        if (topMap.isEmpty() ) {
            topMap.putAll(tierMap);
            for (Map.Entry<String, Integer> topEle : topMap.entrySet()) {
                if (topEle.getValue() == 1 ) {
                    return topEle.getKey().length();
                }
            }
        } else {
            for (Map.Entry<String, Integer> frontEle : tierMap.entrySet()) {
                boolean isSubSequence = false;
                String curStr = frontEle.getKey();
                for (Map.Entry<String, Integer> topEle : topMap.entrySet()) {
                    if (frontEle.getValue() > 1 || isSubSequence(topEle.getKey(), frontEle.getKey())) {
                        isSubSequence = true;
                        break;
                    }
                }
                if (!isSubSequence) {
                    return curStr.length();
                }
            }

        }
        return -1;
    }

    boolean isSubSequence(String main, String sub) {
        int l = 0, r = 0;
        while (l < main.length() && r < sub.length()) {
            if (main.charAt(l) == sub.charAt(r)) {
                r++;
            }
            l++;
        }
        return r == sub.length();
    }
}

// 官方 (not enough)
class Solution1 {
    public int findLUSlength(String[] strs) {
        int n = strs.length;
        int ans = -1;
        for (int i = 0; i < n; ++i) {
            boolean check = true;
            for (int j = 0; j < n; ++j) {
                if (i != j && isSubseq(strs[i], strs[j])) {
                    check = false;
                    break;
                }
            }
            if (check) {
                ans = Math.max(ans, strs[i].length());
            }
        }
        return ans;
    }

    public boolean isSubseq(String s, String t) {
        int ptS = 0, ptT = 0;
        while (ptS < s.length() && ptT < t.length()) {
            if (s.charAt(ptS) == t.charAt(ptT)) {
                ++ptS;
            }
            ++ptT;
        }
        return ptS == s.length();
    }
}

