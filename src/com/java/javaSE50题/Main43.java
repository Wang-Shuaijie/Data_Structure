package com.java.javaSE50��;
/**
 * ��Ŀ����0��7������ɵ�����������
 * @author WangShuaiJie
 *
 */
public class Main43 {
	/*
	 * ����Ҳ��1λ������������8λ������ 
	 * ��һλ����Ϊ�㣬���һλ������ż��
	 */
	public static void main(String[] args) {
		 int count = 0;
	        //������������ɵ���
	        int n = 8;
	        //һλ��
	        count = n/2;
	        //��λ��
	        count += (n-1)*n/2;
	        //��λ��
	        count += (n-1)*n*n/2;
	        //��λ��
	        count += (n-1)*n*n*n/2;
	        //��λ��
	        count += (n-1)*n*n*n*n/2;
	        //��λ��
	        count += (n-1)*n*n*n*n*n/2;
	        //��λ��
	        count += (n-1)*n*n*n*n*n*n/2;
	        System.out.println("0-7������ɵ�����������"+count);
	}
}
