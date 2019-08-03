package com.java.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class ValidAnagram {
	/**
	 * ���������ַ��� s �� t ����дһ���������ж� t �Ƿ��� s ��һ����ĸ��λ�ʡ�

ʾ�� 1:

����: s = "anagram", t = "nagaram"
���: true

ʾ�� 2:

����: s = "rat", t = "car"
���: false
	 */
	public boolean isAnagram(String s, String t) {
		//���ж�s,t�ĳ����Ƿ����
		if(s.length()!=t.length()) return false;
		char[] s_arr=s.toCharArray();
		Arrays.sort(s_arr);
		char[] t_arr=t.toCharArray();
		Arrays.sort(t_arr);
		for(int i=0;i<s.length();i++) {
			if(s_arr[i]!=t_arr[i]) {
				return false;
			}
		}
		return true;
	}
}
