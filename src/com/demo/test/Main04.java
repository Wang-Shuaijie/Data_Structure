package com.demo.test;

import java.util.Scanner;

/**
 * ��������
������дһ����������һ���ַ��������Ȳ�����20����Ȼ�������ַ����ڵ�ÿһ���ַ����д�Сд�任��������д��ĸ���Сд��Сд��ĸ��ɴ�д��Ȼ�������µ��ַ��������
���������ʽ������һ���ַ�������������ַ�������ֻ����Ӣ����ĸ���������������͵��ַ���Ҳû�пո�
���������ʽ���������ת������ַ�����
�����������
��������
AeDb
�������
aEdB
 *
 */
public class Main04 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String str=sc.nextLine();
		for(char c:str.toCharArray()) {
			if(c>=65 && c<=90) {
				System.out.print((char)(c+32));
			}
			if(c>=97 && c<=122) {
				System.out.print((char)(c-32));
			}
		}
		sc.close();
	}
}
