package com.java.leetcode;

public class IntegertoRoman {
	/**
	 * �������� 2 д�� II ����Ϊ�������е� 1��
	 * 12 д�� XII ����Ϊ X + II �� 
	 * 27 д��  XXVII, ��Ϊ XX + V + II
	 */
	public String intToRoman(int num) {
		int[] values=new int[] {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		String[] strs=new String[] {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb=new StringBuilder();
        
        for(int i=0;i<values.length;i++) {
        	while(num>=values[i]) {
        		num -= values[i];
        		sb.append(strs[i]);
        	}
        }
        return sb.toString();
    }
}
