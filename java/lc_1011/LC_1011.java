package lc_1011;

import java.util.Arrays;

public class LC_1011 {

}
class Solution{
	public int shipWithinDays(int[] weights, int D) {
		int l = Arrays.stream(weights).max().getAsInt(), r = Arrays.stream(weights).sum();
		while (l < r) {
			int mid = l + r >> 1;
			int day = 1, cur = 0;
			for (int weight : weights) {
				if (cur + weight > mid) {
					cur = 0;
					day++;
				}
				cur+=weight;
			}
			if (day <= D) {
				r = mid;
			}else {
				l = mid + 1;
			}
		}
		return l;
	}
}