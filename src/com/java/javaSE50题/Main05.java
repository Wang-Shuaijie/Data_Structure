package com.java.javaSE50��;
/**
 * ��Ŀ����������������m��n���������Լ������С��������(�ص�)
 * @author WangShuaiJie
 *
 */
public class Main05 {
	public static void main(String[] args) {
		System.out.println(getGcd(319, 377));
	}
	//���Լ��
	private static int getGcd(int m, int n) {
		//շת�������һ��ȷ��m>n
		if(m<n) {
			m=m+n;
			n=m-n;
			m=m-n;
		}
		if(m%n == 0) {
			return n;
		}else {
			m=m%n;
			return getGcd(m, n);
		}
	}
	//��С������
	private static int getLcm(int m, int n) {
		return m*n/getGcd(m, n);
	}
}
