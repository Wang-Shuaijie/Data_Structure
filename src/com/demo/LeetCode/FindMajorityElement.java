package com.demo.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindMajorityElement {
	/**
	 * 给定�?个大小为 n 的数组，找到其中的众数�?�众数是指在数组中出现次数大�? �? n/2 �? 的元素�??
你可以假设数组是非空的，并且给定的数组�?�是存在众数�?
示例 1:

输入: [3,2,3]
输出: 3
	 */
	public int majorityElement(int[] nums) {
		//根据题目规定众数出现次数大于N/2,先给数组排序，如果第�?个数和中间数相同，则第一个数是众�?
		//如果�?后一个数和中间数相同，则众数是最后一个数；否则众数为中间�?
		if(nums==null || nums.length==0) return -1;
		Arrays.sort(nums);
		int mid=nums[nums.length/2];
		if(nums[0]==mid) {
			return nums[0];
		}else if(nums[nums.length-1]==mid) {
			return nums[nums.length-1];
		}else {
			return mid;
		}
	}
	
	
	//补充：求众数（出现最多的数）
	public static List<Integer> modalElement(int[] nums){
		List<Integer> res=new ArrayList<>();
		if(nums==null || nums.length==0) return res;
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(nums[i])) {
				map.put(nums[i], map.get(nums[i])+1);
			}else {
				map.put(nums[i], 1);
			}
		}
		//遍历hashmap,寻找value�?大的�?
		int maxValue=0;
		for(Integer key:map.keySet()) {
			int value=map.get(key);
			if(value>maxValue) {
				maxValue=value;
			}
		}

		for(Integer key:map.keySet()) {
			if(map.get(key)==maxValue) {
				res.add(key);
			}
		}

		return res;
	}
	
	public static void main(String[] args) {
		int[] nums=new int[] {1,1,1,2,2,2,3,4};
		List<Integer> res=modalElement(nums);
		System.out.println(res.toString());
	}
	
}
