package com.java.���Ծ�ѡ;

import java.util.Scanner;

/**
 * 

����һ���ַ���������һ��Ա���Ŀ��ڼ�¼�������¼���������������ַ���
'A' : Absent��ȱ��
'P' : Present������
���һ��Ա���Ŀ��ڼ�¼�в���������'A'(ȱ��),��ô���Ա���ᱻ���͡�
�������Ϊһ��Ա������������N��Ŀ��������л�ý��ͣ������ж����ֿ��ڵ�����ܹ�����Ҫ��

��������:
�������ڵ�����N����������

�������:
��N�����ܻ�ý��͵Ŀ��������

��������1:
3

�������1:
7

˼·���������C(2,n)+C(1,n)+C(0,n)=1 + n + n * (n - 1) / 2
 * @author WangShuaiJie
 *
 */
public class Main05 {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(1 + n + n * (n - 1) / 2);
    }
}
