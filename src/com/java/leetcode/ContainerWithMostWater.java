package com.java.leetcode;

public class ContainerWithMostWater {
	/**
	 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
	 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
	 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
	 * 
	 * 输入: [1,8,6,2,5,4,8,3,7] 输出: 49 (1,8)--(8,7)
	 */
	public static int maxArea(int[] height) {
		int res=0;
		int l=0,r=height.length-1;
		while(l<r) {
			res=Math.max(res,Math.min(height[l], height[r])*(r-l));
			if(height[l]<height[r]) {
				l++;
			}else {
				r--;
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums=new int[] {1,8,6,2,5,4,8,3,7};
		System.out.println(maxArea(nums));
	}
}
