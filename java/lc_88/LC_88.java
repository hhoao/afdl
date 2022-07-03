package lc_88;

/**
 * @author 黄豪 88. 合并两个有序数组 给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使
 *         nums1 成为一个有序数组。
 * 
 *         初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m +
 *         n，这样它就有足够的空间保存来自 nums2 的元素。
 */
public class LC_88 {

}

//双指针//从前往后
class Solution {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		// Make a copy of nums1.
		int[] nums1_copy = new int[m];
		System.arraycopy(nums1, 0, nums1_copy, 0, m);

		// Two get pointers for nums1_copy and nums2.
		int p1 = 0;
		int p2 = 0;

		// Set pointer for nums1
		int p = 0;

		// Compare elements from nums1_copy and nums2
		// and add the smallest one into nums1.
		while ((p1 < m) && (p2 < n))
			nums1[p++] = (nums1_copy[p1] < nums2[p2]) ? nums1_copy[p1++] : nums2[p2++];

		// if there are still elements to add
		if (p1 < m)
			System.arraycopy(nums1_copy, p1, nums1, p1 + p2, m + n - p1 - p2);
		if (p2 < n)
			System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
	}
}

//方法2 : 双指针 / 从后往前
class Solution2 {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int p1 = m - 1;
		int p2 = n - 1;
		int p = m + n - 1;
		while ((p1 >= 0) && (p2 >= 0))
			nums1[p--] = (nums1[p1] < nums2[p2]) ? nums2[p2--] : nums1[p1--];
		System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
	}
}
