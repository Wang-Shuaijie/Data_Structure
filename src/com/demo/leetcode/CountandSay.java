package com.demo.leetcode;

public class CountandSay {
	/**
	 * ����������һ���������У��������е�������˳����б������õ���һ��������ǰ�������£�
	 * 1.     1
	 * 2.     11
	 * 3.     21
	 * 4.     1211
	 * 5.     111221
	 * 1 ������  "one 1"  ("һ��һ") , �� 11��
	 * 11 ������ "two 1s" ("����һ"��, �� 21��
	 * 21 ������ "one 2",  "one 1" ��"һ����" ,  "һ��һ") , �� 1211��
	 * ����һ�������� n��1 �� n �� 30��������������еĵ� n �
	 * ע�⣺����˳�򽫱�ʾΪһ���ַ�����
	 * ʾ�� 1:
	 * ����: 1 ���: "1"
	 * ʾ�� 2:
	 * ����: 4 ���: "1211"
	 * 
	 */
	public static String countAndSay(int n) {
        //������
		/*
		 * ˼·��
		 * ���Ƕ���ǰһ�������ҳ���ͬԪ�صĸ�����
		 * �Ѹ����͸�Ԫ�ش浽�µ�string��
		 * ������n=1ʱ����ַ���1��n=2ʱ��
		 * ���ϴ��ַ����е���ֵ��������Ϊ�ϴ��ַ�����1��1��
		 * �������11��n=3ʱ�������ϴ��ַ���11����2��1���������21��
		 * n=4ʱ�������ϴ��ַ�����21����1��2��1��1
		 * i=1 count=0 c=1
		 * j=0 count++; sb=11
		 * res="11" i=2
		 * count=0 c="1"
		 * j=0 count=1
		 * j=1 count=2
		 * j=2 res="21"
		 * ...
		 */
		int i=1;
		String res="1";
		while(i<n) {
			int count=0;
			StringBuilder sb=new StringBuilder();
			char c=res.charAt(0);
			//�������=�������Խ�磬�ж���ȥ��=res.length�����
			for(int j=0;j<=res.length();j++) {
				if(j!=res.length() && res.charAt(j)==c) {
					count++;
				}else {
					sb.append(count);
					sb.append(c);
					//System.out.println(sb.toString());
					if(j!=res.length()) {
						count=1;
						c=res.charAt(j);
					}
				}
			}
			res=sb.toString();
			i++;
		}
		return res;
    }
	
	
	public static void main(String[] args) {
		int n=4;
		System.out.println(countAndSay(n));
	}
}
