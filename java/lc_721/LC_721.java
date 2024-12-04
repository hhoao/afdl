package lc_721;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@author: 黄豪
 *@date : 2021年12月17日
 *@todo:721. 账户合并
给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。

现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。

合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是 按字符 ASCII 顺序排列 的邮箱地址。账户本身可以以 任意顺序 返回。
*/
public class LC_721 {

}
//并查集
class Solution {
    class UnionFind{
        public Map<String, String> parent;
        public Map<String, String> name;
        UnionFind(){
            parent = new HashMap<>();
            name = new HashMap<>();
        }
        String find(String email){
            String p = parent.getOrDefault(email, email);
            if (p == email){
                return p;
            }else{
                String ans = find(p);
                this.parent.put(email, ans);
                return ans;
            }
        }
        void insert(String e, String n){
            String p = parent.getOrDefault(e, e);
            parent.put(e, p);
            this.name.put(p, n);
        }
        void union(String e1, String e2){
            e1 = find(e1);
            e2 = find(e2);
            this.parent.put(e1, e2);
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int size = accounts.size();
        UnionFind uf = new UnionFind();
        for (int i = 0; i < size; i++){
            List<String> account = accounts.get(i);
            int n = account.size();
            for (int j = 1; j < n; j++){
                uf.insert(account.get(j), account.get(0));
                if (j > 1){
                    uf.union(account.get(j - 1), account.get(j));
                }
            }
        }
        Map<String, List<String>> eMap = new HashMap<>();
        List<List<String>> ret = new ArrayList<>();
        List<Map.Entry<String, String>> parentEntry = new ArrayList<>(uf.parent.entrySet());
        for (Map.Entry<String, String> entry : parentEntry){
            String p = uf.find(entry.getKey());
            List<String> list = eMap.getOrDefault(p, new ArrayList<>());
            
            if (list.size() == 0){
                list.add(p);
            }
            if (entry.getKey() != p)
                list.add(entry.getKey());
            eMap.put(p, list);
        }
        Comparator<String> cp = new Comparator<>(){
            public int compare(String a, String b){
                int len = a.length() > b.length() ? b.length() : a.length();
                for (int i = 0; i < len; i++){
                    if (a.charAt(i) == b.charAt(i)){
                        continue;
                    }
                    if (a.charAt(i) < b.charAt(i)){
                        return -1;
                    }else{
                        return 1;
                    }
                }
                return a.length() - b.length();
            }
        };
        for (Map.Entry<String, List<String>> s : new ArrayList<>(eMap.entrySet())){
            List<String> user = s.getValue();
            Collections.sort(user, cp);
            s.getValue().add(0, uf.name.get(s.getValue().get(0)));
            ret.add(s.getValue());
        }
        return ret;
    }
}
