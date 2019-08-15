package com.java.campus;

import java.util.Scanner;

/**
 * ���ַ���string��ʼ����ƥ���Ӵ�sub������ƥ�䵽���ַ������� sub���������'?'��ʾ����ƥ��һ��������'\0'����������ַ���
 * ���sub�����Ҳ���ƥ����ַ�����˵����������ƥ�䡣
 * ���������ƥ�䣬����ƥ�䵽���ַ�����������ж���ƥ�䷽ʽ������ƥ���ַ������ٵ��Ǹ��������������ƥ�䣬����-1
 * 
 * ��������: ��һ�������ַ���string������С��10000 �ڶ��������Ӵ�sub������С��100
 * 
 * 
 * �������: ��string��ͷλ������ƥ��sub��ƥ�䵽���ַ�������
 * 
 * ��������1: abcdefg a?c
 * 
 * �������1: 3
 * 
 * ��������2: aabcddefg a?c
 * 
 * �������2: 4
 * 
 * ��������3: aabcddefg b?e
 * 
 * �������3: -1
 * 
 * ��������4: aabcddefg a?d
 * 
 * �������4: 5
 * 
 * @author WangShuaiJie
 *
 */
public class Solution25 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String sub = sc.nextLine();
		System.out.println(getIndex(str, sub));
	}

	private static int getIndex(String str, String sub) {
		if (sub.charAt(0) != str.charAt(0))
			return -1;
		int count = 0;
		int i = 1;
		int j = i;
		while (i < sub.length() && j < str.length()) {
			if (sub.charAt(i) != '?') {
				if (sub.charAt(i) != str.charAt(j)) {
					return -1;
				}
			} else {
				for (; j <= i + 3 && j < str.length(); j++) {
					if (str.charAt(j) == sub.charAt(i + 1)) {
						break;
					}
				}
				if (str.charAt(j) != sub.charAt(i + 1))
					return -1;
				j = j - 1;
				
			}
			i++;
			j++;
		}
		if (i != sub.length())
			return -1;
		return j;
	}
}
