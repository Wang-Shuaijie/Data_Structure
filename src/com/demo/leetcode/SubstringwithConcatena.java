package com.demo.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringwithConcatena {
	/**
	 * ����һ���ַ��� s ��һЩ������ͬ�ĵ��� words��
	 * �ҳ� s ��ǡ�ÿ����� words �����е��ʴ����γɵ��Ӵ�����ʼλ�á�
	 * ע���Ӵ�Ҫ�� words �еĵ�����ȫƥ�䣬�м䲻���������ַ���������Ҫ���� words �е��ʴ�����˳��
	 * ���룺s = "barfoothefoobarman",words = ["foo","bar"] 
	 * �����[0,9] ������ 0 �� 9 ��ʼ���Ӵ��ֱ��� "barfoor" �� "foobar" [9,0]Ҳ��Ч
	 */
	public static List<Integer> findSubstring(String s,String[] words){
		/**
		 * s="barfoothefoobarman"
		 * 	  i	
		 */
		if(s==null || s.length()==0) return new ArrayList<>();
		List<Integer> res=new ArrayList<>();
		int m=words[0].length();//���ʵĳ���
		int n=words.length;//�м�������
		
		HashMap<String, Integer> map=new HashMap<>();
		for(String str:words) {
			map.put(str, map.getOrDefault(str, 0)+1);
		}
		
		for(int i=0;i<=s.length()-n*m;i++) {
			HashMap<String, Integer> copy=new HashMap<>(map);
			int k=n;
			int j=i;
			while(k>0) {
				String str=s.substring(j, j+m);
				if(!copy.containsKey(str)||copy.get(str)<1) {
					break;
				}
				copy.put(str, copy.get(str)-1);
				k--;
				j+=m;
			}
			if(k==0) res.add(i);
		}
		return res;
	}
	
	
	public static void main(String[] args) {
		String s="barfoothefoobarman";
		String[] words=new String[] {"foo","bar"};
		System.out.println(findSubstring(s, words).toString());
	}
}
