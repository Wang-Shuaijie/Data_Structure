package com.demo.offer;

public class Solution46 {
	/**
	 * ��1+2+3+��+n��Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ��ּ������ж���䣨A?B:C��
	 */
	public int get_Sum(int n) {
		//���õݹ�
		int sum=n;
		boolean res=(n>0) && ((sum+=get_Sum(n-1))>0);
		return sum;
	}
}
