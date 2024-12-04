package lc_1610;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 *@author: 黄豪
 *@date : 2021年12月16日
 *@todo:1610. 可见点的最大数目
给你一个点数组 points 和一个表示角度的整数 angle ，你的位置是 location ，其中 location = [posx, posy] 且 points[i] = [xi, yi] 都表示 X-Y 平面上的整数坐标。

最开始，你面向东方进行观测。你 不能 进行移动改变位置，但可以通过 自转 调整观测角度。换句话说，posx 和 posy 不能改变。你的视野范围的角度用 angle 表示， 这决定了你观测任意方向时可以多宽。设 d 为你逆时针自转旋转的度数，那么你的视野就是角度范围 [d - angle/2, d + angle/2] 所指示的那片区域。
*/
public class LC_1610 {
	public static void main(String[] args) {
		int point = 3;
		List<List<Integer>> points = new ArrayList<>();
		for (int i = 0; i < point; i++) {
			points.add(new ArrayList<>());
		}
//		[[65,62],[91,61],[82,80]]
//				17
//				[6,84]
		points.get(0).add(40);
		points.get(0).add(0);
		points.get(1).add(27);
		points.get(1).add(73);
		points.get(2).add(66);
		points.get(2).add(85);
//		[[40,0],[27,73],[66,85]]
//				44
//				[40,52]

		int angle = 44;
		List<Integer> location = Arrays.asList(40, 52); 
		System.out.println(new Solution1().visiblePoints(points, angle, location));
	}
}

//暴力(超时)
class Solution {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        List<Double> as = new ArrayList<>();
        int extra = 0;
        for (List<Integer> point : points){
            double dx = point.get(0) - location.get(0);
            double dy = point.get(1) - location.get(1);
            double a;
            if (dx == 0.0){
                if (dy == 0.0) {
                    extra++;
                    continue;
                }
                a = dy > 0 ? 90.0 : 270.0;
                as.add(a);
                continue;
            }else{
                double k = dy / dx;
                a = Math.atan(k) / Math.PI * 180.0;
            }
            if (dx > 0){
                if (dy >= 0){
                    as.add(a);
                }else{
                    as.add(360.0 + a);
                }
            }else{
                if (dy > 0) as.add(180.0 + a);
                else as.add(180.0 + a);
            }
        }
        
        Collections.sort(as, (a, b)-> {
        	if (a == b) return 0;
        	return b > a ? 1 : -1;
        });
        int n = as.size();
        int ans = 0;
        for (int i = 0; i < n; i++){
            int t = 0;
            for (int j = i, k = 0; k < n; k++,j++){
                double disAng = (j / n == 0 ? as.get(i) - as.get(j) : Math.abs(360.0 - as.get(j % n) + as.get(i))); 
                if (disAng >= 0 && disAng <= angle){
                    t++;
                }
            }
            ans = Math.max(t, ans);
        }
        return ans+extra;
    }
}
//二分查找
class Solution1 {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location) {
        int sameCnt = 0;
        List<Double> polarDegrees = new ArrayList<>();
        int locationX = location.get(0);
        int locationY = location.get(1);
        for (int i = 0; i < points.size(); ++i) {
            int x = points.get(i).get(0);
            int y = points.get(i).get(1);
            if (x == locationX && y == locationY) {
                sameCnt++;
                continue;
            }
            Double degree = Math.atan2(y - locationY, x - locationX);
            polarDegrees.add(degree);
        }
        Collections.sort(polarDegrees);

        int m = polarDegrees.size();
        for (int i = 0; i < m; ++i) {
            polarDegrees.add(polarDegrees.get(i) + 2 * Math.PI);
        }

        int maxCnt = 0;
        Double toDegree = angle * Math.PI / 180;
        for (int i = 0; i < m; ++i) {
            int iteration = binarySearch(polarDegrees, polarDegrees.get(i) + toDegree, false);
            maxCnt = Math.max(maxCnt, iteration - i);
        }
        return maxCnt + sameCnt;
    }

    public int binarySearch(List<Double> nums, Double target, boolean lower) {
        int left = 0, right = nums.size() - 1;
        int ans = nums.size();
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums.get(mid) > target || (lower && nums.get(mid) >= target)) {
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
