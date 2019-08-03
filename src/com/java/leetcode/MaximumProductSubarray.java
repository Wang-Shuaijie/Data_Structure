package com.java.leetcode;

public class MaximumProductSubarray {
	/**
	 * ����һ���������� nums ���ҳ�һ�������г˻��������������У����������ٰ���һ��������

ʾ�� 1:

����: [2,3,-2,4]
���: 6
����: ������ [2,3] �����˻� 6��
//������[2], [3], [-2], [4], [2, 3], [3, -2], [-2, 4], [2, 3, -2], [3, -2, 4], [2, 3, -2, 4]
ʾ�� 2:

����: [-2,0,-1]
���: 0
����: �������Ϊ 2, ��Ϊ [-2,-1] ���������顣


	 */
	//��̬�滮��ÿһ��ֻ��Ҫ��ס��ǰһ�����������ֵ�͸�������Сֵ
	public static int maxProduct(int[] A) {
		if (A == null || A.length == 0) {
	        return 0;
	    }
	    int[] f = new int[A.length];
	    int[] g = new int[A.length];
	    f[0] = A[0];
	    g[0] = A[0];
	    int res = A[0];
	    for (int i = 1; i < A.length; i++) {
	        f[i] = Math.max(Math.max(f[i - 1] * A[i], g[i - 1] * A[i]), A[i]);
	        g[i] = Math.min(Math.min(f[i - 1] * A[i], g[i - 1] * A[i]), A[i]);
	        res = Math.max(res, f[i]);
	    }
	    return res;
	}
	
	//�����ƽ⣨ֱ�����ÿ�������еĳ˻���ȡ���ֵ������ʱ
	public static int maxProduct2(int[] nums) {
		int res=nums[0];
		int index=1;
		
		while(index<=nums.length) {
			for(int i=0;i<=nums.length-index;i++) {
				int product=1;
				for(int j=0;j<index;j++) {
					product*=nums[i+j];
				}
				if(product>res) {
					res=product;
				}
			}
			index++;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int[] nums=new int[] {2,3,-2,4};
		System.out.println(maxProduct(nums));
	}
}
