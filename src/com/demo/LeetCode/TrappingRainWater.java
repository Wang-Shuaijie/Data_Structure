package com.demo.LeetCode;

public class TrappingRainWater {
	/**
	 * ���� n ���Ǹ�������ʾÿ�����Ϊ 1 �����ӵĸ߶�ͼ�����㰴�����е����ӣ�����֮���ܽӶ�����ˮ��

������������ [0,1,0,2,1,0,1,3,2,1,2,1] ��ʾ�ĸ߶�ͼ������������£����Խ� 6 ����λ����ˮ����ɫ���ֱ�ʾ��ˮ���� ��л Marcos ���״�ͼ��

ʾ��:         *
      *       * *   *
  *   * *   * * * * * *
0 1 2 3 4 5 6 7 8 9 0 1 
����: [0,1,0,2,1,0,1,3,2,1,2,1]
���: 6

	 */
	public static int trap(int[] height) {
        int left=0;
        int right=height.length-1;
        int res=0;
        int leftMax=0;
        int rightMax=0;
        while(left<right) {
        	if(height[left]<height[right]) {
        		leftMax=Math.max(height[left], leftMax);
        		res+=leftMax-height[left];
        		left++;
        	}else {
        		rightMax=Math.max(height[right],rightMax);
        		res+=rightMax-height[right];
        		right--;
        	}
        }
		return res;
    }
	
	public static void main(String[] args) {
		int[] height=new int[] {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(trap(height));
	}
}
