package com.java.���Ծ�ѡ;
/**
ũ����nֻ��Ѽ��Ϊһ�����飬���á�C����ʾ��Ѽ�á�D����ʾ������Ѽ����ʱ�����ì�ܡ���Ҫ�����ŵĶ�����е�����ʹ��Ѽ����һ�ߡ�ÿ�ε���ֻ�������ڵļ���Ѽ����λ�ã�������Ҫ������ɶ������������Ҫ�����������Ҫ�������ٴο���������������١����磺CCDCC->CCCDC->CCCCD��������ʹ֮ǰ��������Ѽ���ڱ�Ϊһ����Ѽ���ڣ���Ҫ�����������Ρ�
��������:
����һ������ΪN����ֻ����C��D�ķǿ��ַ�����

�������:
ʹ��������һ�Լ�Ѽ���ڣ����ٵĽ�������

ʾ��1
����
CCDCC

���
2
 * @author WangShuaiJie
 *
 */

import java.util.Scanner;

public class Main15 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		int result = 0;

		input = scanner.nextLine();
		String[] s = input.split("");

		int l = 0;
		for (int i = 0; i < s.length; i++) {
			if (s[i].equals("C")) {
				result += i - l;
				l++;
			}
		}

		System.out.println(result);
	}
}
