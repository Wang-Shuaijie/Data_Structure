package com.demo.leetcode;

public class FindMinimuminRotatedSortedArrayII {
	/**
	 * Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
	 */
public int findMin(int[] nums) {
        
        int result = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length - 1;
        
        while(left <= right){
            int middle = (left + right) / 2;
            
            if(nums[middle] < nums[right]){          //m-r∂Œ”––Ú
                if(nums[middle] < result){
                    result = nums[middle];
                }
                right = middle - 1;
            }else if(nums[middle] > nums[right]){    //l-m∂Œ”––Ú
                if(nums[left] < result){
                    result = nums[left];
                }
                left = middle + 1;
            }else{                                   //≤ªƒ‹≈–∂œ£¨“∆∂Ø±ﬂ‘µ
                if(nums[right] < result){
                    result = nums[right];
                }
                right--;
            }
        }
        
        return result;
    }
}
