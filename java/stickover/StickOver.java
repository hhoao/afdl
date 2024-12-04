package stickover;

/**
 * @author 黄豪
 *在你的面前从左到右摆放着n根长短不一的木棍，你每次可以折断一根木棍，并将折断后得到的两根木棍一左一右放在原来的位置（即若原木棍有左邻居，则两根新木棍必须放在左邻居的右边，若原木棍有右邻居，新木棍必须放在右邻居的左边，所有木棍保持左右排列）。折断后的两根木棍的长度必须为整数，且它们之和等于折断前的木棍长度。你希望最终从左到右的木棍长度单调不减，那么你需要折断多少次呢？
 */
public class StickOver {
	
}
class Solution{
	public int stickOver(int[] nums) {
		int ans = 0;
	    for (int i = nums.length - 2; i >= 0; i--) {
	        if (nums[i + 1] >= nums[i]) continue;
	        int t = (nums[i] - 1) / nums[i + 1];
	        ans += t;
	        nums[i] /= (t + 1);
	    }
	    return ans;
	}
}
