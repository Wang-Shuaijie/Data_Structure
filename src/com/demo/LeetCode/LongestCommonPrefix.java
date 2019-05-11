package com.demo.LeetCode;

public class LongestCommonPrefix {
	/**
	 * 编写一个函数来查找字符串数组中的最长公共前缀。
	 * 如果不存在公共前缀，返回空字符串 ""。
	 * 输入: ["flower","flow","flight"] 输出: "fl"
	 */
	public static String longestCommonPrefix(String[] strs) {
		if(strs==null || strs.length==0) return "";
		String res=strs[0];
		//从1开始比较
		for(int i=1;i<strs.length;i++) {
			/*
			 * indexOf返回某个指定的字符串值在字符串中首次出现的位置，没有返回-1
			 * 如flow indexOf("fl") return 0;
			 * 
			 * 先找flower，没有截取字符
			 * 找flowe 没有截取字符
			 * ....
			 * 找fl
			 */
			while(strs[i].indexOf(res)!=0) {
				res=res.substring(0, res.length()-1);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		String[] strs=new String[] {"flowers","flight","flow"};
		System.out.println(longestCommonPrefix(strs));
	}
}
