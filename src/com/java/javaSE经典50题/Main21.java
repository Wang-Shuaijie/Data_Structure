package com.java.javaSE����50��;
/**
 * ��Ŀ����1+2!+3!+��+20!�ĺ�
 * @author WangShuaiJie
 *
 */
public class Main21 {
	public static void main(String[] args) {
		float sum=0;
		for(int i=1;i<=20;i++) {
			sum+=getFactorial(i);
		}
		System.out.println(sum);
	}
	private static int getFactorial(int n) {
		if(n==1) return 1;
		return n*getFactorial(n-1);
/*		//��׳�
		int mult=1;
		for (int j=1 ; j <= i;j++) {
			mult*=j;
		}
		return mult;//���ؽ׳˽��
*/	}
}
