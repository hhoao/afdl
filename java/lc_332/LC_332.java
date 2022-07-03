package lc_332;

import java.util.*;

/**
 * Created by macro on 2022/3/25
 *
 * @author hhoa
 **/
public class LC_332 {
    public static void main(String[] args) {
    }
}
class Solution {
    private List<String> ans;
    private Map<String, List<String>> collect;
    private Map<String, boolean[]> visited;


    public boolean dfs(List<String> collectPos, String src, int totalTickets, int curTickets){
        if (totalTickets == curTickets){
            ans = new ArrayList<>(collectPos);
            return true;
        }
        if (!collect.containsKey(src)){
            return false;
        }
        List<String> tarPositions = collect.get(src);
        int n = tarPositions.size();
        for (int i = 0; i < n; i++){
            String tarPosition = tarPositions.get(i);
            if (visited.get(src)[i]){
                continue;
            }
            collectPos.add(tarPosition);
            visited.get(src)[i] = true;
            if (dfs(collectPos, tarPosition, totalTickets, curTickets+1)){
                return true;
            }
            visited.get(src)[i] = false;
            collectPos.remove(collectPos.size() - 1);
        }
        return false;
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        int n = tickets.size();
        collect = new HashMap<>();
        visited = new HashMap<>();
        for (List<String> ticket : tickets){
            List<String> strs = collect.computeIfAbsent(ticket.get(0), key-> new ArrayList<>());
            strs.add(ticket.get(1));
        }

        for (Map.Entry<String, List<String>> entry : collect.entrySet()){
            List<String> value = entry.getValue();
            visited.put(entry.getKey(), new boolean[value.size()]);
            Collections.sort(value);
        }

        List<String> collectPos = new ArrayList<>();
        collectPos.add("JFK");
        dfs(collectPos, "JFK", n, 0);
        return ans;
    }
}

/**
 * πŸ∑ΩÃ‚Ω‚
 */
class Solution1 {
    Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    List<String> itinerary = new LinkedList<String>();

    public List<String> findItinerary(List<List<String>> tickets) {
        for (List<String> ticket : tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(itinerary);
        return itinerary;
    }

    public void dfs(String curr) {
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }
        itinerary.add(curr);
    }
}