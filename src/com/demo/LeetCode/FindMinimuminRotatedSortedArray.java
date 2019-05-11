package com.demo.LeetCode;

public class FindMinimuminRotatedSortedArray {
	/**
	 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 
	 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 
	 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。 
	 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
	 */
	public int findMin(int[] num) {
		int low = 0, high = num.length - 1;
		int ret = Integer.MAX_VALUE;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			// On the sorted part.
			if (num[low] <= num[high]) {
				return Math.min(num[low], ret);
			} else { // On the rotated part.
				// num[mid] is on the left rotated part.
				if (num[mid] >= num[low]) {
					low = mid + 1;
				} else { // num[mid] is on the right rotated part.
					ret = num[mid];
					high = mid - 1;
				}
			}
		}
 	return ret;
	}
}
