package com.demo.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
	/**
	 * ����һ���ַ���S��T����S���ҵ�һ����С���Ӵ�����T�е������ַ���ʱ�临�Ӷ�ΪO(n)��
	 * ����,
S = "ADOBECODEBANC"
T = "ABC"
��С�Ӵ���"BANC".
	 */
	
	public static String minWindow(String s, String t) {
//�����ʼ��ɨ��һ��T���Ѷ�Ӧ���ַ�������ֵĴ����浽HashMap�С�
//Ȼ��ʼ����S���Ͱѱ���������ĸ��Ӧ��HashMap�е�value��һ�������1���Դ��ڵ���0��cnt����1��
//���cnt����T������ʱ����ʼѭ������¼һ���ִ���������С�ִ�ֵ��Ȼ���Ӵ��ڵ���߽������ƣ����ĳ���Ƴ�������ĸ��T���в���ȱ�ٵ���ĸ����ôcnt�Լ�1����ʾ��ʱT����û����ȫƥ�䡣
		if(s==null || t==null) return "";
		Map<Character, Integer> map=new HashMap<>();
		int left=0,right=0,min=Integer.MAX_VALUE,start=-1,count=0;
		
		for(int i=0;i<t.length();i++) {
			if(map.containsKey(t.charAt(i))) {
				map.put(t.charAt(i), map.get(t.charAt(i))+1);
			}else{
				map.put(t.charAt(i), 1);
			}
		}
		
		while(right<s.length()) {
			if(!map.containsKey(s.charAt(right))) {
				right++;
				continue;
			}
			map.put(s.charAt(right), map.get(s.charAt(right))-1);
			if(map.get(s.charAt(right))==0) count++;
			while(count==map.size()) {
				int curlen=right-left+1;
				if(curlen<min) {
					start=left;
					min=curlen;
				}
				if(map.containsKey(s.charAt(left))) {
					map.put(s.charAt(left), map.get(s.charAt(left))+1);
					if(map.get(s.charAt(left))>0) {
						count--;
					}
				}
				left++;
			}
			right++;
		}
		if(start==-1) return "";
		return s.substring(start, start+min);
	}
	
	public static void main(String[] args) {
		String s="ADOBECODEBANC";
		String t="ABC";
		System.out.println(minWindow(s, t));
	}
}
