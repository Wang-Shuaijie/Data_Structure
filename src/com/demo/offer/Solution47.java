package com.demo.offer;

public class Solution47 {
	/**
	 * дһ������������������֮�ͣ�Ҫ���ں������ڲ���ʹ��+��-��*��/����������š�
	 */
	public int add(int num1, int num2) {
		while(num2!=0) {
			//�����λ
			int temp=num1^num2;
			//�����λ
			num2=(num1&num2)<<1;
			num1=temp;
		}
		return num1;
	}
}
