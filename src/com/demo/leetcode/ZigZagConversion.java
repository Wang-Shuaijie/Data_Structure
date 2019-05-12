package com.demo.leetcode;

public class ZigZagConversion {
	/**
	 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
	 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
	 * L   C   I   R
	 * E T O E S I I G
	 * E   D   H   N
	 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
	 * (不重要,面试不出，数学规律)
	 * 思路:
	 * 当 n = 2 时：
	 * 0 2 4 6 8 
	 * 1 3 5 7 9 
	 * 当 n = 3 时：
	 * 0   4   8     
	 * 1 3 5 7 9 
	 * 2   6        
	 * 当 n = 4 时：
	 * 0     6      
	 * 1   5 7   
	 * 2 4   8 
	 * 3     9 
	 * 非中间位: 2*nRows - 2
	 */
	
	public static String convert(String s,int numRows) {
		if(numRows <= 1) return s;
		/*
		 * String(出生于JDK1.0时代)          不可变字符序列
		 * StringBuffer(出生于JDK1.0时代)    线程安全的可变字符序列
		 * StringBuilder(出生于JDK1.5时代)   非线程安全的可变字符序列
		 */
		StringBuilder[] sb=new StringBuilder[numRows];
		String res="";
		for(int i=0;i<sb.length;i++) {
			sb[i]=new StringBuilder("");
		}
		//转换
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
