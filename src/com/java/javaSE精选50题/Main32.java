package com.java.javaSE��ѡ50��;

import java.util.Scanner;

/**
 * ��Ŀ��ȡһ������a���Ҷ˿�ʼ��4��7λ��
 * @author WangShuaiJie
 *
 */
public class Main32 {
	public static void main(String[] args) {
		System.out.println("����һ��������");
	    Scanner scanner=new Scanner(System.in);
	    long num=scanner.nextLong();//��ȡ����
	    String str=Long.toString(num);//������ת��ΪString���͵�
	    char[]ch=str.toCharArray();//��String���͵��ַ���ת��Ϊchar���ͣ�ÿһ�����ָ�ֵ���ַ���������
	    int n=ch.length;//�ַ�������ĳ���
	    System.out.println("���������Ҷ˿�ʼ��4-7λΪ��"+ch[n-7]+ch[n-6]+ch[n-5]+ch[n-4]);//������
	    scanner.close();//�ر�������

	}
}
