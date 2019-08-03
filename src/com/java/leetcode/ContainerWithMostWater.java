package com.java.leetcode;

public class ContainerWithMostWater {
	/**
	 * ���� n ���Ǹ����� a1��a2��...��an��ÿ�������������е�һ���� (i, ai) ��
	 * �������ڻ� n ����ֱ�ߣ���ֱ�� i �������˵�ֱ�Ϊ (i, ai) �� (i, 0)��
	 * �ҳ����е������ߣ�ʹ�������� x �Ṳͬ���ɵ�����������������ˮ��
	 * 
	 * ����: [1,8,6,2,5,4,8,3,7] ���: 49 (1,8)--(8,7)
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
