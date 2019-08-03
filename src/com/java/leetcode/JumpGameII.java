package com.java.leetcode;

public class JumpGameII {
	/**
	 * 给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
你的目标是使用最少的跳跃次数到达数组的最后一个位置。
示例:
输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
	 */
	public static int jump(int[] nums) {
		if(nums==null || nums.length<2) return 0;
		int res=0;
		int curMaxArea=0;//当前能走的最大步数
		int maxNext=0;//最终走的最大步数
		//nums.length-1
		for(int i=0;i<nums.length-1;i++) {
			maxNext=Math.max(maxNext, i+nums[i]);
			if(i==curMaxArea) {
				res++;
				curMaxArea=maxNext;
			}
		}
		return res;
	}
	
	public static int jump2(int[] nums) {
		if(nums==null || nums.length<2) return 0;
		int level=0;
		int curMaxArea=0;
		int maxNext=0;
		int i=0;
		while(curMaxArea-i+1>0) {
			level++;
			for(;i<=curMaxArea;i++) {
				maxNext=Math.max(maxNext, nums[i]+i);
				if(maxNext>nums.length-1) {
					return level;
				}
			}
			curMaxArea=maxNext;
		}
		return level;
	}
	
	public static void main(String[] args) {
		int[] nums=new int[] {2,3,1,1,4};
		System.out.println(jump(nums));
	}
}
