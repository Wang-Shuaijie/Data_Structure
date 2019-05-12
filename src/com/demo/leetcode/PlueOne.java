package com.demo.leetcode;

public class PlueOne {
	/**
	 * ����һ����������ɵķǿ���������ʾ�ķǸ��������ڸ����Ļ����ϼ�һ��

���λ���ִ�����������λ�� ������ÿ��Ԫ��ֻ�洢һ�����֡�

����Լ���������� 0 ֮�⣬��������������㿪ͷ��

ʾ�� 1:

����: [1,2,3]
���: [1,2,4]
����: ���������ʾ���� 123��

	 */
	public int[] plusOne(int[] digits) {
		int carry=1;
		for(int i=digits.length-1;i>=0;i++) {
			int temp=digits[i]+carry;
			carry=temp/10;
			digits[i]=temp%10;
			if(carry==0) {
				return digits; 
			}
		}
		if(carry!=0) {
			int[] res=new int[digits.length+1];
			res[0]=1;
			return res;
		}
		return digits;
	}
}
