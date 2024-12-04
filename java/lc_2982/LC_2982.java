package lc_2982;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LC_2982
 *
 * @author xianxing
 * @since 2024/5/30
 **/

public class LC_2982 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int i = solution.maximumLength("abcccccdddd");
        System.out.println(i);
    }
}

class Solution {
    public int maximumLength(String s) {
        char[] charArray = s.toCharArray();
        ArrayList<Integer>[] arrayLists = new ArrayList[26];
        int cnt = 0;
        for (int i = 0; i < charArray.length; i++) {
            cnt++;
            int i1 = charArray[i] - 'a';
            if (arrayLists[i1] == null) {
                arrayLists[i1] = new ArrayList<>();
            }
            ArrayList<Integer> arrayList = arrayLists[i1];
            arrayList.add(cnt);
            for (int j = arrayList.size() - 1; j > 0; j--) {
                if (arrayList.get(j) > arrayList.get(j - 1)) {
                    Collections.swap(arrayList, j, j - 1);
                } else {
                    break;
                }
            }

            if (i + 1 < charArray.length && charArray[i] != charArray[i+1]) {
                cnt = 0;
                while (arrayList.size() > 3) {
                    arrayList.remove(arrayList.size() - 1);
                }
            }
        }
        int res = -1;
        for (ArrayList<Integer> arrayList : arrayLists) {
            if (arrayList != null && arrayList.size() >= 3) {
                res = Math.max(arrayList.get(arrayList.size() - 1), res);
            }
        }
        return res;
    }
}
