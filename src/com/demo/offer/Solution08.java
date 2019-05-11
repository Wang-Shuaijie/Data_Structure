package com.demo.offer;

public class Solution08 {
	/**
	 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
	 *  输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 
	 *  例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
	 *  
	 *  思路：利用二分法，找到中间的数，然后和最左边的值进行比较，若大于最左边的数，
	 *  则最左边从mid开始，若小于最右边值，则最右边从mid开始。若左中右三值相等，
	 *  则取mid前后值中较小的数。
	 */
	public int minNumberInRotateArray(int[] nums) {
		if(nums.length==0 || nums==null) return 0;
		int left=0;
		int right=nums.length-1;
		int res=Integer.MAX_VALUE;
		while(left<=right) {
			int mid=(right-left)/2+left;
			//无翻转
			if(nums[left]<nums[right]) {
				return Math.min(nums[left], res);
			}else {
				// num[mid] is on the left rotated part.
				if(nums[mid]>=nums[left]) {
					left=mid+1;
				}else {// num[mid] is on the right rotated part.
					res=nums[mid];
					right=mid-1;
				}
			}
		}
		return res;
	}
}
