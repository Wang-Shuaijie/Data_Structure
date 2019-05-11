package com.demo.LeetCode;

public class ImplementstrStr {
	/**
	 * ʵ�� strStr() ������
	 * ����һ�� haystack �ַ�����һ�� needle �ַ������� haystack �ַ������ҳ� needle �ַ���
	 * ���ֵĵ�һ��λ�� (��0��ʼ)����������ڣ��򷵻�  -1��
	 * ʾ�� 1:
	 * ����: haystack = "hello", needle = "ll" ���: 2
	 */
	 public int strStr(String haystack, String needle) {
	        if(needle==null || needle.length()==0) return -1;
	        for(int i=0;i<=haystack.length();i++) {
	        	//substring(beginindex,endindex) beginIndex -- ��ʼ������������, ������ 0 ��ʼ��endIndex -- ������������������
	        	if(haystack.substring(i, i+needle.length()).equals(needle)){
	        		return i;
	        	}
	        }
	        return -1;
	 }
}
