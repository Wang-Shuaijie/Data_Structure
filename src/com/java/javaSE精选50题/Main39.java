package com.java.javaSE��ѡ50��;

import java.util.Scanner;

/**
 * ��Ŀ����дһ��������
 * ����nΪż��ʱ�����ú�����1/2+1/4+��+1/n,
 * ������nΪ����ʱ�����ú���1/1+1/3+��+1/n(����ָ�뺯��)
 * @author WangShuaiJie
 *
 */
public class Main39 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		double sum=0;
		if(n%2==0) {
			for(int i=2;i<=n;i+=2) {
				sum+=1/i;	
			}
		}else {
			for(int i=1;i<=n;i+=2) {
				sum+=1/i;
			}
		}
		System.out.println(sum);
	}
}
