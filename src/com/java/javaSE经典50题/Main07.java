package com.java.javaSE����50��;
/**
 * ��Ŀ����s=a+aa+aaa+aaaa+aa��a��ֵ������a��һ�����֡�
 * ����2+22+222+2222+22222(��ʱ����5�������)��
 * ����������м��̿��ơ�����������ʽ�磺2+22+222=246
 * @author WangShuaiJie
 *
 */
public class Main07 {
	public static void main(String[] args) {
		System.out.println(getSum(2, 3));
	}
	
	private static int getSum(int num, int count) {
		/*
		 * 2+22+222
		 * 1����һ����һ��num,���һ����3��num
		 * 2�� ��1�͵�2�����num*10����2�͵��������num*100����k�͵�k+1�����2*��10��k�η���
		 */
		int sum=0;
		int tmp=num;
		for(int i=1;i<=count;i++) {
			//System.out.println(num);
			sum+=num;
			num=num+tmp*(int)Math.pow(10, i);			
		}
		return sum;
	}
}
