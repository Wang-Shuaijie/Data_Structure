package com.demo.offer;

public class Solution54 {
	/**
	 * ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С����
	 * 
true

"+100"
"5e2"
"-123"
"3.1416"
"-1E-16"

false

"12e"
"1a3.14"
"1.2.3"
"+-5"
"12e+4.3"
	 */
	public boolean isNumeric1(char[] str) { 
		//1  ��������ʽ   �ж����Ƿ������� 
		String res=String.valueOf(str); 
		return res.matches("[\\+-]?[0-9]*(\\.[0-9])?([eE][\\+-]?[0-9]+)?"); 
		/**
        * ������ʽ˵��:
        * [\+-]?  + -�ſɳ���Ҳ�ɲ�����
        * [0-9]*  ���������Ƿ����    [0-9]������\\d����
        * (\.[0-9])?  ����С���������������
        * ([eE][\+-]?[0-9]+)  ����ָ������E��e�϶����� + -���Բ�����
        *                      �����ſ��Ը���������Ҳ����ʲô��û��
        */ 
	}
	
	
	public boolean isNumeric(char[] str) { 
		if (str == null) return false; 
		int index = 0; 
		int ecount = 0; 
		int point = 0; 
		// �����һ���ַ��Ƿ��ž����� 
		if (str[0] == '-' || str[0] == '+') index++; 
		for (int i = index; i < str.length; i++) { 
			if (str[i] == '-' || str[i] == '+') { 
				if (str[i-1] != 'e' && str[i-1] != 'E') 
					return false; 
				continue; 
			} 
			if (str[i] == 'e' || str[i] == 'E') { 
				ecount++; 
				if (ecount > 1) return false; 
				if (i == 0 || str[i-1] < 48 || str[i-1] > 57 || i == str.length-1) return false; 
				point++; 
				continue; 
			} 
			if (str[i] == '.') { 
				point++; 
				if (point > 1) return false; 
				continue; 
			} 
			// ���ַ������Ҳ���e/E�򷵻�false��С����ͷ�����continue�����ˣ�
			if ((str[i] < 48 || str[i] > 57) && (str[i] != 'e') && (str[i] != 'E')) return false; 
		} 
		return true;
	}
}
