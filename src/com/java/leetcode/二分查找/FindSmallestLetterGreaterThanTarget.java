package com.java.leetcode.二分查找;
/**
 * Input:
letters = ["c", "f", "j"]
target = "d"
Output: "f"

Input:
letters = ["c", "f", "j"]
target = "k"
Output: "c"

题目描述：给定一个有序的字符数组 letters 和一个字符 target，
要求找出 letters 中大于 target 的最小字符，如果找不到就返回第 1 个字符。
 * @author WangShuaiJie
 *
 */
public class FindSmallestLetterGreaterThanTarget {
	public char nextGreatestLetter(char[] letters, char target) {
		int l=0, h=letters.length-1;
		while(l<=h) {
			int m=l+(h-l)/2;
			if(letters[m]<=target) {
				l=m+1;
			}else {
				h=m-1;
			}
		}
		return l<letters.length-1?letters[l]:letters[0];
	}
}
