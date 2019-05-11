package com.demo.LeetCode;

public class FindMinimuminRotatedSortedArray {
	/**
	 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת�� 
	 * ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء� 
	 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1�� 
	 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0
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
