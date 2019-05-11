package com.demo.offer;

public class Solution49 {
	/**
	 * ��һ���ַ���ת����һ��������Ҫ����ʹ���ַ���ת�������Ŀ⺯���� ��ֵΪ0�����ַ�������һ���Ϸ�����ֵ�򷵻�0
	 */
	public int strtoInt(String str) {
		if(str.length()==0 && str==null) return 0;
		int res=0;
		int sign=1;
		int i=0;
		if(str.charAt(0)=='-') {
			sign=1;
			i++;
		}
		if(str.charAt(0)=='+') {
			sign=1;
			i++;
		}
		for(;i<str.length();i++) {
			if(str.charAt(i)<'0' || str.charAt(i)>'9') {
				return 0;
			}else {
				res=res*10+str.charAt(i)-'0';
			}
		}
		return res*sign;
	}
}
