package com.java.javaSE��ѡ50��;

import java.util.Scanner;

/**
 * ��Ŀ��
 * ��n��������ʹ��ǰ�����˳�������m��λ�ã�
 * ���m���������ǰ���m����
 * �����������ԭ������Ļ����ϻ�Ҫ����һ����ԭ�������Сһ��������
 * @author WangShuaiJie
 *
 */
public class Main36 {
	public static void main(String[] args) {
		System.out.print("������10����������: ");
		Scanner sc = new Scanner(System.in);
		int count = 0;
		int[] array = new int[10];
		for (int i=0; i<array.length; i++) {
			array[count++] = sc.nextInt();
		}
	    System.out.print("������һ��С��10����: ");
		int number = sc.nextInt();
		sc.close();
	}
	
	private static void arrayHandler(int[] array, int m) {
		int[] temp=new int[m];
		for(int i=0;i<m;i++) {
			temp[i]=array[array.length-m+i];
		}
		for(int i=array.length-m-1;i>=0;i--) {
			array[i+m]=array[i];
		}
		for(int i=0;i<m;i++) {
			array[i]=temp[i];
		}
	}	
}
