package lc_307;

/*
 *@author: 黄豪
 *@date : 2021年9月14日
 *@todo:给你一个数组 nums ，请你完成两类查询，其中一类查询要求更新数组下标对应的值，另一类查询要求返回数组中某个范围内元素的总和。

实现 NumArray 类：

NumArray(int[] nums) 用整数数组 nums 初始化对象
void update(int index, int val) 将 nums[index] 的值更新为 val
int sumRange(int left, int right) 返回子数组 nums[left, right] 的总和（即，nums[left] + nums[left + 1], ..., nums[right]）

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/range-sum-query-mutable
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
public class LC_307 {
	public static void main(String[] args) {
		NumArray na = new NumArray(new int[] {0, 9, 5, 7, 3});
		System.out.println(na.sumRange(2, 4));
	}
}
//线段树
class NumArray {
    private int[] tree;    
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        int t = 1, k = 1;
        while (k <= n){
        	k *= 2;
            t += k;
        }
        tree = new int[t + 1];
        tree[1] = buildTree(1, 0, n-1);
    }
    private int buildTree(int i, int start, int end){
        if (i > tree.length){
            return 0;
        }
        if (start == end){
        	tree[i] = nums[start];
            return nums[start];
        }
        int left  = buildTree(i * 2, start, (end + start) / 2);
        int right = buildTree(i * 2 + 1, (end + start) / 2+1, end);
        tree[i] = left+right;
        return left + right;
    }
    private void helper(int i, int k, int start, int end, int value) {
    	if (start == end) {
    		tree[k] = value;
    		return;
    	}
    	int mid = (start + end) / 2;
    	int left = 0, right = 0;
    	if (i > mid) {
    		left = tree[k * 2];
    		helper(i, k*2+1, mid+1, end, value);
    		right = tree[k *2 + 1];
    	}else {
    		right = tree[k*2+1];
    		helper(i, k*2, start, mid, value);
    		left = tree[k * 2];
    	}
    	tree[k] = left + right;
    }
    private int sumHelper(int i, int left, int right, int arrLeft, int arrRight) {
    	if (left == arrLeft && right == arrRight) {
    		return tree[i];
    	}
    	int sum = 0;
    	int mid = (arrLeft + arrRight) / 2;
    	if (left < mid + 1 && right > mid) {
    		sum += sumHelper(i*2+1, mid + 1, right, mid+1, arrRight);
    		sum += sumHelper(i*2, left, mid, arrLeft, mid);
    	}else {
    		sum += left < mid + 1 ? sumHelper(i*2, left, right, arrLeft, mid) : 0;
    		sum += right > mid ? sumHelper(i*2+1, left , right, mid+1, arrRight) : 0;
    	}
    	return sum;
    }
    public void update(int index, int val) {
    	helper(index, 1, 0, nums.length - 1, val);
    }
    
    public int sumRange(int left, int right) {
    	return sumHelper(1, left, right, 0, nums.length - 1);
    }
}