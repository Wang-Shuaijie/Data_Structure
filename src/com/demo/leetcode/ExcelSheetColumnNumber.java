package com.demo.leetcode;

public class ExcelSheetColumnNumber {
	/**
	 * ����һ��Excel����е������ƣ���������Ӧ������š�

���磬

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...

ʾ�� 1:

����: "A"
���: 1

ʾ�� 2:

����: "AB"
���: 28

	 */
	public static int titleToNumber(String s) {
		//����ʵ�����൱��һ�ֶ�ʮ������תʮ���Ƶ����⣬�����ѣ�ֻҪһλһλ��ת������
		if(s.length()==0 || s==null) return 0;
		int res=0;
		for(int i=0;i<s.length();i++) {
			res=res*26;
			res+=s.charAt(i)-'A'+1;
		}
		return res;
	}
	
	public static void main(String[] args) {
		String s="AB";
		System.out.println(titleToNumber(s));
	}
}
