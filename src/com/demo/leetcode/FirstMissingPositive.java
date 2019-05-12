package com.demo.leetcode;

import java.util.HashSet;

public class FirstMissingPositive {
	/**
	 * 给定一个未排序的整数数组，找出其中没有出现的最小的正整数。

示例 1:

输入: [1,2,0]
输出: 3

	 */
	
	
	//用hsahset比较简单，但不满足time:O(n)
	public static int firstMissingPositive2(int[] nums) {
		int res=0;
		HashSet<Integer> set=new HashSet<>();
		//第一遍遍历数组把所有的数都存入HashSet中，并且找出数组的最大值
		for(int num:nums) {
			if(num<=0) continue;
			set.add(num);
			res=Math.max(res, num);
		}
		//下次循环从1开始递增找数字，哪个数字找不到就返回哪个数字，如果一直找到了最大的数字，则返回最大值+1
		for(int i=1;i<=res;i++) {
			if(!set.contains(i)) return i;
		}
		return res+1;
	}
	
	/*
	 * 既然不能建立新的数组，那么我们只能覆盖原有数组，
	 * 我们的思路是把1放在数组第一个位置nums[0]，2放在第二个位置nums[1]，
	 * 即需要把nums[i]放在nums[nums[i] - 1]上，那么我们遍历整个数组，
	 * 如果nums[i] != i + 1, 而nums[i]为整数且不大于n，
	 * 另外nums[i]不等于nums[nums[i] - 1]的话，我们将两者位置调换，
	 * 如果不满足上述条件直接跳过，最后我们再遍历一遍数组，
	 * 如果对应位置上的数不正确则返回正确的数
	 */
	
	public static int firstMissingPositive(int[] nums) {
		int n=nums.length;
		for(int i=0;i<n;i++) {
			while(nums[i]>0 && nums[i]<=n && nums[nums[i]-1]!=nums[i]) {
				swap(nums[i], nums[nums[i]-1]);
			}
		}
		for(int i=0;i<n;i++) {
			if(nums[i]!=i+1) return i+1;
		}
		return n+1;
	}
	
	private static void swap(int a,int b) {
		int temp=a;
		a=b;
		b=temp;
	}
	
	
	public static void main(String[] args) {
		int[] nums=new int[] {1,2,0};
		System.out.println(firstMissingPositive2(nums));
	}
}
