package com.java.javaSE50��;
/**
 * ��Ŀ����5��������һ���ʵ�����˶����ꣿ��˵�ȵ�4���˴�2�ꡣ
 * �ʵ�4������������˵�ȵ�3���˴�2�ꡣ�ʵ������ˣ���˵�ȵ�2�˴����ꡣ
 * �ʵ�2���ˣ�˵�ȵ�һ���˴����ꡣ����ʵ�һ���ˣ���˵��10�ꡣ���ʵ�����˶��
 * @author WangShuaiJie
 *
 */
public class Main23 {
	public static void main(String[] args) {
		System.out.println(getAge(5));
	}
	
	private static int getAge(int n) {
		if(n==1) return 10;
		return getAge(n-1)+2;
	}
}
