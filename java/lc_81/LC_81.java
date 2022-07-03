package lc_81;

/**
 * @author 黄豪
 *81. 搜索旋转排序数组 II
假设按照升序排序的数组在预先未知的某个点上进行了旋转。

( 例如，数组 [0,0,1,2,2,5,6] 可能变为 [2,5,6,0,0,1,2] )。

编写一个函数来判断给定的目标值是否存在于数组中。若存在返回 true，否则返回 false。
 */
public class LC_81 {

}
class Solution{
	public boolean search(int[] nums, int target) {
	    if (nums == null || nums.length == 0) {
	        return false;
	    }
	    int start = 0;
	    int end = nums.length - 1;
	    int mid;
	    while (start <= end) {
	        mid = start + (end - start) / 2;
	        if (nums[mid] == target) {
	            return true;
	        }
	        if (nums[start] == nums[mid]) {
	            start++;
	            continue;
	        }
	        //前半部分有序
	        if (nums[start] < nums[mid]) {
	            if (nums[mid] > target && nums[start] <= target) {
	                end = mid - 1;
	            } else {
	                start = mid + 1;
	            }
	        } else {
	            if (nums[mid] < target && nums[end] >= target) {
	                start = mid + 1;
	            } else {  //否则，去后半部分找
	                end = mid - 1;
	
	            }
	        }
	    }
	    //一直没找到，返回false
	    return false;
	}
}
