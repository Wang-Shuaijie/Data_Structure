package com.demo.offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution35 {
	/**
	 * ��һ���ַ���(1<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��
	 */
	public int firstCharacterAppearOnce(String str) {
		if(str==null || str.length()==0) return -1;
		char[] c=str.toCharArray();
		Map<Character,Integer> map=new LinkedHashMap<>();
		for(char item:c) {
			if(map.containsKey(item)) {
				map.put(item,map.get(item)+1);
			}else {
				map.put(item, 1);
			}
		}
		for(int i=0;i<str.length();i++) {
			if(map.get(str.charAt(i))==1) {
				return i;
			}
		}
		return -1;
	}
}
