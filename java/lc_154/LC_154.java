package lc_154;

/**
 * @author 黄豪
 *154. 寻找旋转排序数组中的最小值 II
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。

请找出其中最小的元素。

注意数组中可能存在重复的元素。
 */
public class LC_154 {

}
//我的代码 二分
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid = (l+r) >> 1;
            if (nums[mid] == nums[r]) r--;
            else if (nums[mid] < nums[r]){
                r = mid;
            }else{
                l = mid + 1;
            }
        }
        return nums[l];
    }
}
//[0, 1, 2, 2, 2]
//[2, 2, 0, 1, 2]
//[2, 2, 2, 0, 1]
//[2, 2, 2, 0, 2]
//[2, 0, 2, 2, 2]
//官方 二分
class Solution1 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else if (nums[pivot] > nums[high]) {
                low = pivot + 1;
            } else {
                high -= 1;
            }	
        }
        return nums[low];
    }
}
