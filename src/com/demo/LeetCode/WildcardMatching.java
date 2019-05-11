package com.demo.LeetCode;

public class WildcardMatching {
	/**
	 * ����һ���ַ��� (s) ��һ���ַ�ģʽ (p) ��ʵ��һ��֧�� '?' �� '*' ��ͨ���ƥ�䡣
	 * '?' ����ƥ���κε����ַ���
	 * '*' ����ƥ�������ַ������������ַ�������
	 * �����ַ�����ȫƥ�����ƥ��ɹ���
˵��:
    s ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ��
    p ����Ϊ�գ���ֻ������ a-z ��Сд��ĸ���Լ��ַ� ? �� *��
    ʾ�� 1:
    ����:s = "aa"  p = "a*" ���: true
	 */
	
	public static boolean isMath(String s,String p) {
		
		int sp=0;//�ַ���s���±�
		int pp=0;//�ַ���p���±�
		int match=0;//�ַ���s��һ��ƥ��(* . ?)��λ��
		int star=-1;//*��λ��
		while(sp<s.length()) {
			if(pp<p.length() && (s.charAt(sp)==p.charAt(pp)||p.charAt(pp)=='?')) {
				sp++;
				pp++;
			}else if(pp<p.length() && p.charAt(pp)=='*') {
				star=pp;
				match=sp;
				pp++;
			}else if(star!=-1) {
				pp=star+1;
				match++;
				sp=match;
			}else {
				return false;
			}
		}
		while(pp<p.length() && p.charAt(pp)=='*') {
			pp++;
		}
		return pp==p.length();
	}
	
	
	public static void main(String[] args) {
		System.out.println(isMath("aa", "a?"));
	}
}
