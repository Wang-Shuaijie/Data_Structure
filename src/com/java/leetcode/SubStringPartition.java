package com.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SubStringPartition {
	/**
	 *  ����һ���ַ���s����s�ָ��һЩ�Ӵ���ʹÿ���Ӵ����ǻ��Ĵ���

����s���п��ܵĻ��Ĵ��ָ����

������

���� s = "aab"������

    [
      ["aa", "b"],
      ["a", "a", "b"]
    ]
	 */
	public static List<List<String>> partition(String s){
		List<List<String>> res=new ArrayList<>();
		if(s.length()==0 || s==null) return res;
		helper(res,new ArrayList<>(),s,0);
	    return res;      
	}
	
	public static void helper(List<List<String>> res, List<String> list, String s,int start) {
		if(start==s.length()) {
			res.add(new ArrayList<>(list));
			return ;
		}
		for(int i=start;i<s.length();i++) {
			if(isPartition(s.substring(start, i+1))) {
				list.add(s.substring(start, i+1));
				helper(res, list, s, i+1);
				list.remove(list.size()-1);
			}
			
		}
	}
	
	public static boolean isPartition(String s) {
		if(s==null || s.length()==0) return true;
		int i=0;
		int j=s.length()-1;
		while(i<j) {
			if(s.charAt(i) != s.charAt(j)) {
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
	
	public static void main(String[] args) {
		String s="aab";
		List<List<String>> res=partition(s);
		System.out.println(res.toString());
	}
}
