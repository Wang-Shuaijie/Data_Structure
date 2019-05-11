package com.demo.LeetCode;

public class ImplementstrStr {
	/**
	 * 实现 strStr() 函数。
	 * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串
	 * 出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
	 * 示例 1:
	 * 输入: haystack = "hello", needle = "ll" 输出: 2
	 */
	 public int strStr(String haystack, String needle) {
	        if(needle==null || needle.length()==0) return -1;
	        for(int i=0;i<=haystack.length();i++) {
	        	//substring(beginindex,endindex) beginIndex -- 起始索引（包括）, 索引从 0 开始。endIndex -- 结束索引（不包括）
	        	if(haystack.substring(i, i+needle.length()).equals(needle)){
	        		return i;
	        	}
	        }
	        return -1;
	 }
}
