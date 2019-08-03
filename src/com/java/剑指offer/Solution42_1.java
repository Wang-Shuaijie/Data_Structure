package com.java.��ָoffer;

public class Solution42_1 {
	/**
	 * ����һ���������ַ�����S���������ѭ������Kλ����������
	 * ���磬�ַ�����S=��abcXYZdef��,Ҫ�����ѭ������3λ��Ľ����
 * ����XYZdefabc����
	 */
	public static String leftRotateString(String str,int k) {
		//ƴ�ӻ�ת�����ַ���
		if(str.length()==0 || str==null) return null;
		String s1=str.substring(0, k);
		String s2=str.substring(k, str.length());
		return s2+s1;
	}
	
	public static String leftRotateString2(String str,int k) {
		//ƴ�ӻ�ת�����ַ���
		if(str.length()==0 || str==null) return null;
		char[] chars=str.toCharArray();
		for(int i=0;i<chars.length;i++) {
			chars[i]=str.charAt((i+k)%str.length());
		}
		return String.valueOf(chars);
	}
	
	public static void main(String[] args) {
		String str="abcXYZdef";
		System.out.println(leftRotateString2(str, 3));
	}
}
