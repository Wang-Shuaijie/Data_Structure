package com.java.leetcode;

public class RomantoInteger {
	/**
	 * ��������ת����
	 * ����: "LVIII"���: 58����: L = 50, V= 5, III = 3.
	 * ����:��ߵ��������С���ұߵ�����:��-��
	 */
	public static int romanToInt(String s) {
		if(s==null || s.length()==0)  return -1;
		int res=toNumber(s.charAt(0));
		for(int i=1;i<s.length();i++) {
			//�ұߵ����ִ������
			if(toNumber(s.charAt(i))>toNumber(s.charAt(i-1))) {
				/*
				 * IV  res=1+5-2
				 */
				res += toNumber(s.charAt(i)) -2*toNumber(s.charAt(i-1));
			}else {
				res += toNumber(s.charAt(i));
			}
		}
        return res;
    }
	
	public static int toNumber(char c) {
		//ת������
		int res=0;
		switch (c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		
		default:
			break;
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		String s="IV";
		System.out.println(romanToInt(s));
	}
}
