package com.java.leetcode;

public class ReverseInteger {
	/**
	 * 321 --- 123
	 * -123 --- -321 
	 * ע���±�Խ��
	 * int (2^32-1,-2^32)
	 */
	
	public static int reverse(int x) {
		//int���͵��������п���Խ��,������long
		long res=0;
		while(x != 0) {
			/*
			 * res=0*10+3=3 3*10+2=32
			 * x=12  1
			 */
			res=res*10+x%10; //ȡ����Сλ3  
			x /= 10; //ȡ��12
			if(res>Integer.MAX_VALUE || res< Integer.MIN_VALUE) return 0;
		}
		return (int)res;
	}
	
	//�ַ�����ת
	public static String reverseString(String s) {
		String res="";
		if(s==null || s.length()==0) return s;
		for(int i=0;i<s.length();i++) {			
			res=s.charAt(i)+res;
		}
		return res;
	}
	
	public static void main(String[] args) {
		int x=54321;
		System.out.println(reverse(x));
		System.out.println(reverseString("ABCD"));
	}
}
