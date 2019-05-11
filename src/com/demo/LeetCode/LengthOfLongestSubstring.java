package com.demo.LeetCode;

import java.util.HashMap;
import java.util.HashSet;

public class LengthOfLongestSubstring {
	/**
	 * ����һ���ַ����������ҳ����в������ظ��ַ��� ��Ӵ� �ĳ��ȡ�
	 * ����: "abcabcbb"���: 3 
	 * ����: ��Ϊ���ظ��ַ�����Ӵ��� "abc"�������䳤��Ϊ 3��
	 */

	public int lengthOfLongestSubstring(String s) {
		//�ж��ַ����Ƿ�Ϊ��
		if(s == null || s.length() == 0) return 0;
		HashMap<Character, Integer> map=new HashMap<>();
		int res=0;
		//i�Ǳ�������j��ʾ�ظ������
		/*
		 * a b c a b c 
		 * i=0,j=0
		 * i=1,j=0
		 * i=2,j=0
		 * i=3,j=1
		 * i=4,j=2
		 * i=5,j=3
		 */
		for (int i=0,j=0;i<s.length();i++) {
			//������ҵ���ͬԪ�أ�ȡ����Ԫ�������±꣬��+1
			if(map.containsKey(s.charAt(i))) {
				j=Math.max(j, map.get(s.charAt(i))+1);
			}
			//�ѱ��������ַ�����hashmap��
			map.put(s.charAt(i), i);	
			res=Math.max(res, i-j+1);
		}
		return res;
	}
	
	//HashSet<E>д��
	public static int lengthOfLongestSubstring2(String s) {
		//�ж��ַ����Ƿ�Ϊ��
		if(s == null || s.length() == 0) return 0;
		int res=0;
		HashSet<Character> set=new HashSet<>();
		
		int i=0,j=0;
		/*�ѳ��ֹ����ַ�������set�У�����set��û�е��ַ��ͼ���set�в����½��res��
		 * ��������ظ��ģ������߿�ʼɾ�ַ���ֱ��ɾ���ظ����ַ�ֹͣ
		 */
		while(i<s.length()&&j<s.length()) {
			if(set.contains(s.charAt(i))) {
				set.remove(s.charAt(j));
				j++;
			}else {
				set.add(s.charAt(i));
				i++;
				res=Math.max(res,set.size());
			}
		}
		
		return res;
	}
	

	public static void main(String[] args) {
		String s="abcbb";
		System.out.println(lengthOfLongestSubstring2(s));
	}

}
