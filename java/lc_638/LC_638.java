package lc_638;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 *@author: 黄豪
 *@date : 2021年12月1日
 *@todo:638. 大礼包
在 LeetCode 商店中， 有 n 件在售的物品。每件物品都有对应的价格。然而，也有一些大礼包，每个大礼包以优惠的价格捆绑销售一组物品。

给你一个整数数组 price 表示物品价格，其中 price[i] 是第 i 件物品的价格。另有一个整数数组 needs 表示购物清单，其中 needs[i] 是需要购买第 i 件物品的数量。

还有一个数组 special 表示大礼包，special[i] 的长度为 n + 1 ，其中 special[i][j] 表示第 i 个大礼包中内含第 j 件物品的数量，且 special[i][n] （也就是数组中的最后一个整数）为第 i 个大礼包的价格。

返回 确切 满足购物清单所需花费的最低价格，你可以充分利用大礼包的优惠活动。你不能购买超出购物清单指定数量的物品，即使那样会降低整体价格。任意大礼包可无限次购买。
*/
class Solution {
    Map<List<Integer>, Integer> memo = new HashMap<>();
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        int n = needs.size();
        List<List<Integer>> filterSpecial = new ArrayList<>();
        for (List<Integer> sp : special){
            int totalCount = 0, totalPrice = 0;
            for (int i = 0; i < n; i++){
                totalCount += sp.get(i);
                totalPrice += sp.get(i) * price.get(i);
            }
            if (totalCount > 0 && totalPrice > sp.get(n)){
                filterSpecial.add(sp);
            }
        }
        return dfs(price, filterSpecial, needs);
    }
    public int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs){
        if (!memo.containsKey(needs)){
            int minPrice = 0;
            for (int i = 0; i < needs.size(); i++){
                minPrice += needs.get(i) *price.get(i);
            }
            for (List<Integer> sp : special){
                List<Integer> aftNeeds = new ArrayList<>();
                for (int i = 0; i < needs.size(); i++){
                    if (sp.get(i) > needs.get(i)){
                        break;
                    }else{
                        aftNeeds.add(needs.get(i) - sp.get(i));
                    }
                }
                if (aftNeeds.size() == needs.size()){
                    minPrice = Math.min(minPrice, dfs(price, special, aftNeeds) + sp.get(needs.size()));
                }
            }
            memo.put(needs, minPrice);
        }
        return memo.get(needs);
    }
}