package com.demo.offer;

import java.util.ArrayList;
import java.util.List;

public class Solution65 {
	/**
	 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值
	 * 
	 * 思路：两个for循环，第一个for循环滑动窗口，第二个for循环滑动窗口中的值，
	 * 寻找最大值。还可以使用时间复杂度更低的双端队列求解。
	 */
	public List<Integer> maxInWindows(int[] nums, int size){
		List<Integer> res=new ArrayList<>();
		if(nums==null || nums.length==0) return res;
		int len=nums.length-size+1;
		for(int i=0;i<len;i++) {
			int current=size+1;
			int max=nums[i];
			for(int j=i;j<current;j++) {
				if(max<nums[j]) {
					max=nums[j];
				}
			}
			res.add(max);
		}
		return res;
	}
}
