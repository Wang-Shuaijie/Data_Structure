package com.java.javaSE��ѡ50��;

import java.util.Scanner;

/**
 * ��Ŀ������һ���ַ����ֱ�ͳ�Ƴ���Ӣ����ĸ���ո����ֺ������ַ��ĸ�����
 * @author WangShuaiJie
 *
 */
public class Main06 {
//1����ȡһ���ַ�����nextLine����
//2�����ַ�����ÿһ���ַ���ֵ��һ����ֵ��
//3���Ա�ÿһ����ֵ��ASK��ķ�Χ���Ϳ���ȷ�������ŵ����
//4��char�ַ�ASK��ķ�Χ
//     ��1������0��9�� 48~57
//     ��2����ĸA��Z��65��90 a��z��97��122
//     ��3���ո���32
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String input=sc.nextLine();
		int num=0;//���ָ���
		int letter=0;//��ĸ����
		int space=0;//�ո����
		int others=0;//��������
		for(char c:input.toCharArray()) {
			if(c>=48 && c<=57) num++;
			else if((c>=65 && c<=90) || (c>=97 && c<=122)) letter++;
			else if(c==32) space++;
			else others++;	
		}
		System.out.println("���֣�"+num+"������ĸ��"+letter+"�����ո�"+space+"����������"+others+"��");         
		sc.close();
	}
}
