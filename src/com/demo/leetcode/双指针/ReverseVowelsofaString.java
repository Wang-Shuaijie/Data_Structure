package com.demo.leetcode.双指针;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 题目描述：反转字符串中的元音字符
 * Given s = "leetcode", return "leotcede".
 * @author WangShuaiJie
 *
 */
public class ReverseVowelsofaString {
	private final HashSet<Character> vowels=new HashSet<>(
	        Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
	public String resverseVowels(String s) {
		int i=0, j=s.length()-1;
		char[] res=new char[s.length()];
		while(i<=j) {
			char ci=s.charAt(i);
			char cj=s.charAt(j);
			if(!vowels.contains(ci)) {
				res[i]=ci;
				i++;
			}else if(!vowels.contains(cj)) {
				res[j]=cj;
				j--;
			}else {
				res[i]=cj;
				res[j]=ci;
				i++;
				j--;
			}
		}
		return new String(res);
	}
}
