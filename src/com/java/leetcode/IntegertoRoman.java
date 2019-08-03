package com.java.leetcode;

public class IntegertoRoman {
	/**
	 * 罗马数字 2 写做 II ，即为两个并列的 1。
	 * 12 写做 XII ，即为 X + II 。 
	 * 27 写做  XXVII, 即为 XX + V + II
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
