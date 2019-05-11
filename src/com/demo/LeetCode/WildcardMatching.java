package com.demo.LeetCode;

public class WildcardMatching {
	/**
	 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
	 * '?' 可以匹配任何单个字符。
	 * '*' 可以匹配任意字符串（包括空字符串）。
	 * 两个字符串完全匹配才算匹配成功。
说明:
    s 可能为空，且只包含从 a-z 的小写字母。
    p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
    示例 1:
    输入:s = "aa"  p = "a*" 输出: true
	 */
	
	public static boolean isMath(String s,String p) {
		
		int sp=0;//字符串s的下标
		int pp=0;//字符串p的下标
		int match=0;//字符串s第一次匹配(* . ?)的位置
		int star=-1;//*的位置
		while(sp<s.length()) {
			if(pp<p.length() && (s.charAt(sp)==p.charAt(pp)||p.charAt(pp)=='?')) {
				sp++;
				pp++;
			}else if(pp<p.length() && p.charAt(pp)=='*') {
				star=pp;
				match=sp;
				pp++;
			}else if(star!=-1) {
				pp=star+1;
				match++;
				sp=match;
			}else {
				return false;
			}
		}
		while(pp<p.length() && p.charAt(pp)=='*') {
			pp++;
		}
		return pp==p.length();
	}
	
	
	public static void main(String[] args) {
		System.out.println(isMath("aa", "a?"));
	}
}
