package com.java.leetcode;

public class RepeatedSubstringPattern {
	/**
	 * ����һ���ǿյ��ַ������ж����Ƿ����������һ���Ӵ��ظ���ι��ɡ��������ַ���ֻ����СдӢ����ĸ�����ҳ��Ȳ�����10000��

ʾ�� 1:

����: "abab"

���: True

����: �������ַ��� "ab" �ظ����ι��ɡ�

	 */
	
	public boolean repeatedSubstringPattern(String s) {
		//˼·����ô��Ȼ�ܲ�ֳɶ���Ӵ�����ôÿ���Ӵ��ĳ��ȿ϶����ܴ���ԭ�ַ������ȵ�һ�룬
		//��ô���ǿ��Դ�ԭ�ַ������ȵ�һ�������1�������ǰ�����ܱ��ܳ���������˵�����Էֳ����ɸ����ַ�����
		//���ǽ���Щ���ַ���ƴ����������ԭ�ַ����Ƿ���ȡ� ��������˶�����ȣ�����false��
		int n=s.length();
		for(int i=n/2;i>=1;i--) {
			if(n%i==0) {
				int c=n/i;
				String t="";
				for(int j=0;j<c;j++) {
					t+=s.substring(0, i);
				}
				if(t.equals(s)) return true;
			}
		}
		return false;
	}
}
