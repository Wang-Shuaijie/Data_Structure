package com.java.��ָoffer;

public class Solution04 {
	/**
	 * ��һ���ַ����еĿո��滻�ɡ�%20����
���磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���ΪWe%20Are%20Happy
	 */
	public String replaceSpace(String str) {
		if(str==null || str.length()==0) return str;
		StringBuilder sb=new StringBuilder();
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==' ') {
				sb.append("%20");
			}else {
				sb.append(str.charAt(i));
			}
		}
		return sb.toString();
	}
}
