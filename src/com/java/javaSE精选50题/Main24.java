package com.java.javaSE��ѡ50��;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ��Ŀ����һ��������5λ����������
 * Ҫ��һ�������Ǽ�λ�������������ӡ����λ����
 * @author WangShuaiJie
 *
 */
public class Main24 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int num=sc.nextInt();
		int[] arr=new int[5];
		int i=0;
		while(num!=0) {
			arr[i]=num%10;
			num=num/10;
			i++;
		}
		System.out.println(Arrays.toString(arr));
	}
}
