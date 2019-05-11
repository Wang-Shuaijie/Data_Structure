package com.demo.LeetCode;

public class FirstUniqueCharacterinaString {
	/**
	 * ����һ���ַ������ҵ����ĵ�һ�����ظ����ַ���������������������������ڣ��򷵻� -1��

����:

s = "leetcode"
���� 0.

s = "loveleetcode",
���� 2.

	 */
	public int firstUniqChar(String s) {
		//��һ��������ÿ���ַ����ֵĴ���
		int[] nums=new int[256];
		for(int i=0;i<s.length();i++) {
			nums[s.charAt(i)-'a']++;
		}
		for(int i=0;i<s.length();i++) {
			if(nums[s.charAt(i)-'a']==1) {
				return i;
			}
		}
		return -1;
	}
}
