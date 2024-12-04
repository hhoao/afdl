package lc_153;

public class LC_153 {

}
//我的代码 二分查找
class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r){
            int mid=  (l + r) >> 1;
            if (nums[mid] > nums[r]){
                l = mid + 1;
            }else{
                if (mid > 0 && nums[mid - 1] > nums[mid]){
                    return nums[mid];
                }else{
                    r = mid - 1;
                }
            }
        }
        return nums[l];
    }
}
//官方二分
class Solution1 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int pivot = low + (high - low) / 2;
            if (nums[pivot] < nums[high]) {
                high = pivot;
            } else {
                low = pivot + 1;
            }
        }
        return nums[low];
    }
}
