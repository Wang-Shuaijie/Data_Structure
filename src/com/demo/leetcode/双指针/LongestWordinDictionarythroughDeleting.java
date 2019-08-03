package com.demo.leetcode.˫ָ��;

import java.util.List;

/**
 * Input:s = "abpcplea", d = ["ale","apple","monkey","plea"]
 * Output:"apple"
 * ��Ŀ������ɾ�� s �е�һЩ�ַ���ʹ���������ַ����б� d �е�һ���ַ������ҳ��ܹ��ɵ���ַ���������ж����ͬ���ȵĽ���������ֵ������С�ַ�����
 * @author WangShuaiJie
 *
 */

//ͨ��ɾ���ַ��� s �е�һ���ַ��ܵõ��ַ��� t��������Ϊ t �� s �������У����ǿ���ʹ��˫ָ�����ж�һ���ַ����Ƿ�Ϊ��һ���ַ����������С�
public class LongestWordinDictionarythroughDeleting {
	public String findLongestWord(String s, List<String> d) {
		String longestWord="";
		for(String target:d) {
			int l1=longestWord.length(), l2=target.length();
			if(l1>l2 || (l1 == l2 && longestWord.compareTo(target) < 0)) continue;
			if(isSubstr(s,target)) {
				longestWord=target;
			}
		}
		return longestWord;
	}

	private boolean isSubstr(String s, String target) {
		
		int i = 0, j = 0;
	    while (i < s.length() && j < target.length()) {
	        if (s.charAt(i) == target.charAt(j)) {
	            j++;
	        }
	        i++;
	    }
	    return j == target.length();
	}
}
