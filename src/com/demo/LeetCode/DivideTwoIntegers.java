package com.demo.LeetCode;

public class DivideTwoIntegers {
	/**
	 * �������������������� dividend �ͳ��� divisor�������������Ҫ��ʹ�ó˷��������� mod �������
	 * ���ر����� dividend ���Գ��� divisor �õ����̡�
	 * ʾ�� 1:
	 * ����: dividend = 10, divisor = 3
	 * ���: 3
	 * ���ǣ�1.Խ��;2.+,-;3.=0 ��3/5;4.����Ϊ0�����ǣ����������Լ����쳣
	 */
	public static int divide(int dividend,int divisor) {
		int sign=1;
		//�ж�������
		if((dividend>0 && divisor<0)||(dividend<0 && divisor>0)) sign=-1;
		//long��ֹԽ��
		long ldividend=Math.abs(dividend);
		long ldivisor=Math.abs(divisor);
		if(ldividend<ldivisor || ldividend==0) return 0;
		long lres=divide(ldividend, ldivisor);
		int res=0;
		if(lres>Integer.MAX_VALUE) {
			res=(sign==1)?Integer.MAX_VALUE:Integer.MIN_VALUE;
		}else {
			res=(int)lres*sign;
		}
		return res;
	}
	
	//Time:O(logn)  Space:O(logn) 
	private static long divide(long ldividend, long ldivisor) {
		// TODO Auto-generated method stub
		if(ldividend<ldivisor) return 0;
		long sum=ldivisor;
		long multile=1;
		/**
		 * 8 / 2=4
		 * sum=2 multile=1
		 * sum=4 multile=2 
		 * sum=8(����ѭ��) multile=4+divide(0/2) 			
		 */
		while((sum+sum)<=ldividend) {
			sum+=sum;
			multile+=multile;
		}
		//�ݹ�
		return multile+divide(ldividend-sum, ldivisor);
	}
	
	public static void main(String[] args) {
		System.out.println(divide(8, 5));
	}
}
