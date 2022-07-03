package lc_165;

/**
 * @author 黄豪
 *165. 比较版本号
给你两个版本号 version1 和 version2 ，请你比较它们。

版本号由一个或多个修订号组成，各修订号由一个 '.' 连接。每个修订号由 多位数字 组成，可能包含 前导零 。每个版本号至少包含一个字符。修订号从左到右编号，下标从 0 开始，最左边的修订号下标为 0 ，下一个修订号下标为 1 ，以此类推。例如，2.5.33 和 0.1 都是有效的版本号。

比较版本号时，请按从左到右的顺序依次比较它们的修订号。比较修订号时，只需比较 忽略任何前导零后的整数值 。也就是说，修订号 1 和修订号 001 相等 。如果版本号没有指定某个下标处的修订号，则该修订号视为 0 。例如，版本 1.0 小于版本 1.1 ，因为它们下标为 0 的修订号相同，而下标为 1 的修订号分别为 0 和 1 ，0 < 1 。

返回规则如下：

如果 version1 > version2 返回 1，
如果 version1 < version2 返回 -1，
除此之外返回 0。
 */
public class LC_165 {

}
//我的代码
class Solution {
    public int compareVersion(String version1, String version2) {
        String[] ss1 = version1.split("\\.");
        String[] ss2 = version2.split("\\.");
        int k = ss1.length, j = ss2.length;
        int n = Math.max(k, j);
        int state = 0;
        for (int i = 0; i < n; i++){
            int num1 = 0, num2 = 0;
            if (k > i) num1 = Integer.valueOf(ss1[i]);
            if (j > i) num2 = Integer.valueOf(ss2[i]);
            if (i < k && i < j && num1 == num2) continue;
            state = (k == n && i >= j && num1 != 0) ? 1 : 0;
            if (state != 0) return state;
            state = (j == n && i >= k && num2 != 0) ? -1 : 0;
            if (i < k && i < j){
                state = (num1 < num2) ? -1 : 1;
            }

            if (state != 0) return state;
        }
        return state;
    }
}
//官方
class Solution1 {
	public int compareVersion(String version1, String version2) {
		String[] nums1 = version1.split("\\.");
		String[] nums2 = version2.split("\\.");
		int n1 = nums1.length, n2 = nums2.length;

		// compare versions
		int i1, i2;
		for (int i = 0; i < Math.max(n1, n2); ++i) {
			i1 = i < n1 ? Integer.parseInt(nums1[i]) : 0;
			i2 = i < n2 ? Integer.parseInt(nums2[i]) : 0;
			if (i1 != i2) {
				return i1 > i2 ? 1 : -1;
			}
		}
    // the versions are equal
    return 0;
  }
}
//双指针一次遍历
class Solution2 {	
    public int compareVersion(String version1, String version2) {
        int l = 0, r = 0;
        int n = version1.length(), m = version2.length();
        int max = Math.max(n, m);
        while (l < n || r < m){
            int a= 0, b = 0;
            while(l < n && version1.charAt(l) != '.') a = a * 10 + version1.charAt(l++) - '0';
            while(r < m && version2.charAt(r) != '.') b = b * 10 + version2.charAt(r++) - '0';
            if (a > b) return 1;
            else if (a < b) return -1;
            l++;
            r++;
        }
        return 0;
    }
}
