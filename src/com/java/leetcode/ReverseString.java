package com.java.leetcode;

public class ReverseString {
	/**
	 * ��дһ���������������ǽ�������ַ�����ת�����������ַ������ַ����� char[] ����ʽ������

��Ҫ�����������������Ŀռ䣬�����ԭ���޸��������顢ʹ�� O(1) �Ķ���ռ�����һ���⡣

����Լ��������е������ַ����� ASCII ����еĿɴ�ӡ�ַ���
ʾ�� 1��

���룺["h","e","l","l","o"]
�����["o","l","l","e","h"]

	 */
	public void reverseString(char[] s) {
		if(s==null || s.length==0) return ;
		for(int i=0;i<s.length/2;i++) {
			char temp=s[i];
			s[i]=s[s.length-i-1];
			s[s.length-i-1]=temp;
		}
	}
	
}
