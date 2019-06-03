package com.demo.leetcode;

import java.util.Arrays;
import java.util.Collections;

public class ReverseWordsinaString {
	/**
	 * 反转字符串中的单词
	 * For example,
Given s = "the sky is blue",
return "blue is sky the". 
	 */
	
	public static String reverseWords(String s) {
		if(s.trim().equals("")){
            return s;
        }
		//利用split分割
		String res="";
		//原字符串调用trim()来去除冗余空格，然后调用split()来分隔，分隔符设为"\\s+"，这其实是一个正则表达式，\\s表示空格字符，+表示可以有一个或多个空格字符
		String[] words=s.trim().split("\\s+");
		for(int i=0;i<words.length;i++) {
			res=" "+words[i]+res;
		}
		return res.trim();
	}
	
	public static String reverseWords2(String s) {
		if(s.trim().equals("")){
            return s;
        }
		String[] words = s.trim().split(" +");
		Collections.reverse(Arrays.asList(words));
		return String.join(" ", words);
	}
	
	public static String reverseWords3(String s) {
		if(s.trim().equals("")){
            return s;
        }
		int storeIndex=0, n=s.length();
		//先将整个字符串翻转，然后将每个单词翻转
		StringBuilder sb=new StringBuilder(s).reverse();
		for(int i=0;i<n;i++) {
			if(sb.charAt(i)!=' ') {
				if(storeIndex!=0) sb.setCharAt(storeIndex++, ' ');
				int j=i;
				while(j<n && sb.charAt(j)!=' ') sb.setCharAt(storeIndex++, sb.charAt(j++));
				String t=new StringBuilder(sb.substring(storeIndex - (j - i), storeIndex)).reverse().toString();
				sb.replace(storeIndex - (j - i), storeIndex, t);
				i=j;
			}
		}
		sb.setLength(storeIndex);
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String s="the sky is blue";
		System.out.println(reverseWords3(s));
	}
}
