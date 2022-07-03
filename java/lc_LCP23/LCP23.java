package lc_LCP23;

import java.util.Arrays;

/*
 *@author: 黄豪
 *@date : 2021年10月2日
 *@todo:LCP 23. 魔术排列
秋日市集上，魔术师邀请小扣与他互动。魔术师的道具为分别写有数字 1~N 的 N 张卡牌，然后请小扣思考一个 N 张卡牌的排列 target。

魔术师的目标是找到一个数字 k（k >= 1），使得初始排列顺序为 1~N 的卡牌经过特殊的洗牌方式最终变成小扣所想的排列 target，特殊的洗牌方式为：

第一步，魔术师将当前位于 偶数位置 的卡牌（下标自 1 开始），保持 当前排列顺序 放在位于 奇数位置 的卡牌之前。例如：将当前排列 [1,2,3,4,5] 位于偶数位置的 [2,4] 置于奇数位置的 [1,3,5] 前，排列变为 [2,4,1,3,5]；
第二步，若当前卡牌数量小于等于 k，则魔术师按排列顺序取走全部卡牌；若当前卡牌数量大于 k，则取走前 k 张卡牌，剩余卡牌继续重复这两个步骤，直至所有卡牌全部被取走；
卡牌按照魔术师取走顺序构成的新排列为「魔术取数排列」，请返回是否存在这个数字 k 使得「魔术取数排列」恰好就是 target，从而让小扣感到大吃一惊。

示例 1：

输入：target = [2,4,3,1,5]

输出：true

解释：排列 target 长度为 5，初始排列为：1,2,3,4,5。我们选择 k = 2：
第一次：将当前排列 [1,2,3,4,5] 位于偶数位置的 [2,4] 置于奇数位置的 [1,3,5] 前，排列变为 [2,4,1,3,5]。取走前 2 张卡牌 2,4，剩余 [1,3,5]；
第二次：将当前排列 [1,3,5] 位于偶数位置的 [3] 置于奇数位置的 [1,5] 前，排列变为 [3,1,5]。取走前 2 张 3,1，剩余 [5]；
第三次：当前排列为 [5]，全部取出。
最后，数字按照取出顺序构成的「魔术取数排列」2,4,3,1,5 恰好为 target。

示例 2：

输入：target = [5,4,3,2,1]

输出：false

解释：无法找到一个数字 k 可以使「魔术取数排列」恰好为 target。
*/
public class LCP23 {
	public static void main(String[] args) {
		
		Solution so = new Solution();
		System.out.println(so.isMagic(new int[] {2,4,6,10,14,18,26,34,42,15,31,8,40,29,38,20,41,16,35,13,36,12,23,24,37,30,28,27,17,22,25,7,1,9,11,21,5,19,43,33,32,39,3}));
	}
}
//优化
class Solution {
	public boolean isMagic(int[] target) {
		int n = target.length;
		int[] orgin = new int[n];
		for (int i = 0; i < n; i++) orgin[i] = i + 1;
		int start = 0;
		int[] get = new int[n], odds = new int[(n + 1) / 2], even = new int[n / 2];
		int io = 0, ie = 0, res_size = n, index = 0;
		for (int i = 0; i < n; i++) if (i % 2 == 1) even[ie++] = orgin[i]; else odds[io++] = orgin[i];
		for (int i = 0; i < n; i++)
			if (target[i] == (i < ie ? even[i] : odds[i - ie]))
				start++;
			else
				break;
		if (start == 0) return false;
		while (index < n) {
			odds = new int[(res_size + 1) / 2];
			even = new int[res_size / 2];
			io = 0;
			ie = 0;
			for (int i = 0; i < res_size; i++)
				if (i % 2 == 1) even[ie++] = orgin[i];
				else odds[io++] = orgin[i];
			if (start <= res_size) {
				for (int i = 0; i < start; i++) get[index++] = i < ie ? even[i] : odds[i - ie];
				for (int i = start; i < res_size; i++) orgin[i - start] = i < ie ? even[i] : odds[i - ie];
				res_size -= start;
			} else {
				for (int i = 0; i < ie; i++) get[index++] = even[i];
				for (int i = 0; i < io; i++) get[index++] = odds[i];
			}
		}
		boolean res = true;
		for (int i = 0; i < n; i++) if (get[i] != target[i]) res = false;
		if (res) return true;
		return false;
	}
}
class Solution1 {
    public boolean isMagic(int[] target) {
        int n = target.length;
        int[] orgin = new int[n];
        for (int i = 0; i < n; i++){
            orgin[i] = i+1;
        }
        int start = 0;
        for (int i = 0; i < n; i++) {
        	if (target[i] % 2 == 0 && target[i] / 2 == (start+1)) {
        		start++;
        	}else break;
        }
        if (start == 0) return false;
        
        for(int k = start; k <= n; k++) {
        	int[] residue = Arrays.copyOf(orgin, n);
            int[] get = new int[n];
            int res_size = n;
            int index = 0;
	        while (index < n){
	            int[] odds = new int[(res_size+1) / 2];
	            int[] even = new int[res_size/2];
	            int io = 0, ie = 0;
	            for (int i = 0; i < res_size; i++){
	                if (i % 2 == 1){
	                    even[ie++] = residue[i];
	                }else{
	                    odds[io++] = residue[i];
	                }
	            }
	            if (k <= res_size){
	                for (int i = 0; i < k; i++){
	                    if (i < ie)
	                        get[index++] = even[i];
	                    else
	                        get[index++] = odds[i - ie];
	                }
	                res_size -= k;
	                for (int i = k; i < res_size+k; i++) {
	                	residue[i - k] = i < ie ? even[i] : odds[i - ie];
	                }
	            }else{
	                for (int i = 0; i < ie; i++){
	                    get[index++] = even[i];
	                }
	                for (int i = 0; i < io; i++){
	                    get[index++] = odds[i];
	                }
	            }
	        }
	        boolean res = true;
	        for (int i = 0; i < n; i++){
	            if (get[i] != target[i])
	                res =false;
	        }
	        if (res) return true;
        }
        
        return false;
    }
}