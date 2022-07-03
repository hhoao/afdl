package lc_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LC_90 {
	public static void main(String[] args) {
		Solution2 solution = new Solution2();
		
		for (List<Integer> list : solution.subsetswithDup(new int[] {4, 4, 1, 4})) {
			for (Integer i : list) {
				System.out.print(i);
			}
			System.out.println();
		}
	}
}
//回溯
class Solution{
	public List<List<Integer>> subsetswithDup(int[] nums){
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int size = nums.length;
		dfs(ans, new ArrayList<Integer>(), nums, 0, size);
		return ans;
	} 
	public void dfs(List<List<Integer>> ans, List<Integer> temp, int[] nums, int n, int size) {
		ans.add(new ArrayList<>(temp));
		for (int i = n; i < size; i++) {
			if (i > n && nums[i] == nums[i - 1]) {
				continue;
			}
			temp.add(nums[i]);
			dfs(ans, temp, nums, i + 1, size);
			temp.remove(temp.size() - 1);
		}
	}
}

//迭代法

class Solution2{
	public List<List<Integer>> subsetswithDup(int[] nums){
		List<List<Integer>> ans = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		ans.add(new ArrayList<Integer>());
		int l = 0, r = ans.size();
		for (int i = 0; i < nums.length; i++) {
			r = ans.size();
			if (i > 0 && nums[i] == nums[i - 1]) {
				for (int j = l; j < r; j++) {
					List<Integer> list = new ArrayList<Integer>(ans.get(j));
					list.add(nums[i]);
					ans.add(list);
				}
			}else {
				for (int n = 0; n < r; n++) {
					List<Integer> cList = new ArrayList<Integer>(ans.get(n));
					cList.add(nums[i]);
					ans.add(cList);
				}
			}
			l = r;
		}
		return ans;
	}
}

//位运算
class Solution3{
	public List<List<Integer>> subsetsWithDup(int[] num) {
	    Arrays.sort(num);
	    List<List<Integer>> lists = new ArrayList<>();
	    int subsetNum = 1<<num.length;
	    for(int i=0;i<subsetNum;i++){
	        List<Integer> list = new ArrayList<>();
	        boolean illegal=false;
	        for(int j=0;j<num.length;j++){
	            //当前位是 1
	            if((i>>j&1)==1){
	                //当前是重复数字，并且前一位是 0，跳过这种情况
	                if(j>0&&num[j]==num[j-1]&&(i>>(j-1)&1)==0){
	                    illegal=true;
	                    break;
	                }else{
	                    list.add(num[j]);
	                }
	            }
	        }
	        if(!illegal){
	            lists.add(list); 
	        }
	
	    }
	    return lists;
	}
}
