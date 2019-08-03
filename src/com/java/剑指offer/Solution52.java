package com.java.��ָoffer;

public class Solution52 {
	/**
	 * ����һ������A[0,1,...,n-1],�빹��һ������B[0,1,...,n-1],����B�е�Ԫ��B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]������ʹ�ó�����
	 */
	
//	���ڵ�һ��forѭ��
//	��һ����b[0] = 1;
//	�ڶ�����b[1] = b[0] * a[0] = a[0]
//	��������b[2] = b[1] * a[1] = a[0] * a[1];
//	���Ĳ���b[3] = b[2] * a[2] = a[0] * a[1] * a[2];
//	���岽��b[4] = b[3] * a[3] = a[0] * a[1] * a[2] * a[3];
//	Ȼ����ڵڶ���forѭ��
//	��һ��
//	temp *= a[4] = a[4]; 
//	b[3] = b[3] * temp = a[0] * a[1] * a[2] * a[4];
//	�ڶ���
//	temp *= a[3] = a[4] * a[3];
//	b[2] = b[2] * temp = a[0] * a[1] * a[4] * a[3];
//	������
//	temp *= a[2] = a[4] * a[3] * a[2]; 
//	b[1] = b[1] * temp = a[0] * a[4] * a[3] * a[2];
//	���Ĳ�
//	temp *= a[1] = a[4] * a[3] * a[2] * a[1]; 
//	b[0] = b[0] * temp = a[4] * a[3] * a[2] * a[1];
	public int[] multiply(int[] A) {
		int[] B=new int[A.length];
		if(A.length==0 || A==null) return B;
		B[0]=1;
		//��������������
		for(int i=1;i<B.length;i++) {
			B[i]=B[i-1]*A[i-1];
		}
		int temp=1;
		//��������������
		for(int j=B.length-2;j>=0;j--) {
			temp*=A[j+1];
			B[j]*=temp;
		}
		return B;
	}
}
