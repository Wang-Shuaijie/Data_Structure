package com.demo.leetcode;

public class ZigZagConversion {
	/**
	 * ��һ�������ַ������ݸ������������Դ������¡������ҽ��� Z �������С�
	 * ���������ַ���Ϊ "LEETCODEISHIRING" ����Ϊ 3 ʱ���������£�
	 * L   C   I   R
	 * E T O E S I I G
	 * E   D   H   N
	 * ֮����������Ҫ�����������ж�ȡ��������һ���µ��ַ��������磺"LCIRETOESIIGEDHN"��
	 * (����Ҫ,���Բ�������ѧ����)
	 * ˼·:
	 * �� n = 2 ʱ��
	 * 0 2 4 6 8 
	 * 1 3 5 7 9 
	 * �� n = 3 ʱ��
	 * 0   4   8     
	 * 1 3 5 7 9 
	 * 2   6        
	 * �� n = 4 ʱ��
	 * 0     6      
	 * 1   5 7   
	 * 2 4   8 
	 * 3     9 
	 * ���м�λ: 2*nRows - 2
	 */
	
	public static String convert(String s,int numRows) {
		if(numRows <= 1) return s;
		/*
		 * String(������JDK1.0ʱ��)          ���ɱ��ַ�����
		 * StringBuffer(������JDK1.0ʱ��)    �̰߳�ȫ�Ŀɱ��ַ�����
		 * StringBuilder(������JDK1.5ʱ��)   ���̰߳�ȫ�Ŀɱ��ַ�����
		 */
		StringBuilder[] sb=new StringBuilder[numRows];
		String res="";
		for(int i=0;i<sb.length;i++) {
			sb[i]=new StringBuilder("");
		}
		//ת��
		for(int i=0;i<s.length();i++) {
			int index=i % (2*numRows -2);
			index = index<numRows ? index:2*numRows-2-index;
			sb[index].append(s.charAt(i));
		}
		
		for(int i=1;i<sb.length;i++) {
			sb[0].append(sb[i]);
		}
		res=sb[0].toString();
		return res;
	}
	
	
	public static void main(String[] args) {
		String s="ABCDEFGHIJ";
		/*
		 * A     G     M
		 * B   F H   L N
		 * C E   I K
		 * D	 J
		 */
		System.out.println(convert(s, 4));
	}
}
