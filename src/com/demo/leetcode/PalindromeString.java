package com.demo.leetcode;

public class PalindromeString {
	/**
	 * ����һ���ַ�������֤���Ƿ��ǻ��Ĵ���ֻ������ĸ�������ַ������Ժ�����ĸ�Ĵ�Сд��

˵���������У����ǽ����ַ�������Ϊ��Ч�Ļ��Ĵ���

ʾ�� 1:

����: "A man, a plan, a canal: Panama"
���: true

	 */
	public static boolean isPalindrome(String s) {
        if(s==null || s.length()==0 || s.length()==1) return true;
        int i=0,j=s.length()-1;
        while(i<j) {
        	while(i<j && !judge(s.charAt(i))) i++;
        	while(i<j && !judge(s.charAt(j))) j--;
        	if(i<j) {
        		if(uppercase(s.charAt(i))!=uppercase(s.charAt(j))) {
        			return false;
        		}
        		i++;
        		j--;
        	}
        }
		return true;
    }
	
	public static boolean judge(char c) {
		if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c>='0' && c<='9')) {
			return true;
		}
		return false;
	}
	
	public static char uppercase(char c) {
		if(c>='a' && c<='z') {
			return (char) (c-'a'+'A');
		}
		return c;
	}
	
	public static void main(String[] args) {
		String s="A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(s));
	}
}
