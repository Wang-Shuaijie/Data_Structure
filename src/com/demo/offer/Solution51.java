package com.demo.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution51 {
	/**
	 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。请找出数组中任意一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是重复的数字2或者3。
	 */
	public int duplicate(int[] nums) {
		if(nums==null || nums.length==0) return -1;
		Map<Integer, Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i])+1);
			}else {
				map.put(nums[i], 1);
			}
		}
		
		for(int key:map.keySet()) {
			if(map.get(key)>1) {
				return key;
			}
		}
		return -1;
	}
	
	
	
	
	
	
	//一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
	public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
		// 先转成String类利用remove删除，如果直接删除数值类型会理解成下标
		ArrayList<String> list = new ArrayList<>();
		for (int i = 0; i < array.length; i++) {
			if (!list.contains(String.valueOf(array[i]))) {
				list.add(String.valueOf(array[i]));
			} else {
				list.remove(String.valueOf(array[i]));
			}
		}
		if (list.size() != 0) {
			num1[0] = Integer.valueOf(list.get(0));
			num2[0] = Integer.valueOf(list.get(1));
		}
	}
}
