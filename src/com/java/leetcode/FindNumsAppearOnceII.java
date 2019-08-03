package com.java.leetcode;

import java.util.HashMap;

public class FindNumsAppearOnceII {
	/**
	 * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。

说明：

你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？

示例 1:

输入: [2,2,3,2]
输出: 3

	 */
	public int singleNumber(int[] nums) {
		if(nums==null || nums.length==0) return -1;
		HashMap<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i])+1);
			}else {
				map.put(nums[i], 1);
			}
		}
		
		for(int key:map.keySet()) {
			if(map.get(key)==1) {
				return key;
			}
		}
		return -1;
	}
	
	//官方解法
	public int singleNumber2(int[] nums) {
		  int ones = 0, twos = 0, threes = 0;
		        
		  for (int i = 0; i < nums.length; i++) {
		    // twos holds the num that appears twice
		    twos |= ones & nums[i];
		    
		    // ones holds the num that appears once
		    ones ^= nums[i];
		 
		    // threes holds the num that appears three times
		    threes = ones & twos;
		            
		    // if num[i] appears three times
		    // doing this will clear ones and twos
		    ones &= ~threes;
		    twos &= ~threes;
		  }
		        
		  return ones;
		}
}
