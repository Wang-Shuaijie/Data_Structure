package com.demo.exercise;

import java.util.Scanner;

/**
 * ����ĳ��ĳ��ĳ�գ��ж���һ���������еĵڼ���
 * @author WangShuaiJie
 *
 */
public class Main14 {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		int year=scanner.nextInt();//��ȡ���
		int month=scanner.nextInt();//��ȡ�·�
		int day=scanner.nextInt();//��ȡ����
		System.out.println(getDays(year, month, day));
	}
	private static int getDays(int year, int month, int day) {
		int res=0;
		int[] arr=new int[] {31,28,31,30,31,30,31,31,30,31,30,31};
		res=day;//����������϶���Ҫ�ӵ�
		for(int i=0;i<month-1;i++) {
			res+=arr[i];
		}
		if(isLeapYear(year) && month > 2) {
			res=res+1;//�����һ��
		}
		return res;
	}
	
	//�ж��Ƿ�������
	private static boolean isLeapYear(int n) {
		if((n%4==0 && n%100!=0) || n%400==0) return true;
		return  false;
	}
}
