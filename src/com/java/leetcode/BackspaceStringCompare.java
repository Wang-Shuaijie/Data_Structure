package com.java.leetcode;

import java.util.Stack;

public class BackspaceStringCompare {
	/**
	 * 退格字符串比较
	 * Example 1:

Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".

Example 2:

Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".

Example 3:

Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".

Example 4:

Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".

Note:

    1 <= S.length <= 200
    1 <= T.length <= 200
    S and T only contain lowercase letters and '#' characters.

	 */
	public boolean backspaceCompare(String S, String T) {
		//利用stack
		Stack<Character> s1=new Stack<>();
		Stack<Character> s2=new Stack<>();
		for(Character c:S.toCharArray()) {
			if(c=='#') {
				if(!s1.isEmpty()) {
					s1.pop();
				}
			}else {
				s1.push(c);
			}
		}
		
		for(Character c:T.toCharArray()) {
			if(c=='#') {
				if(!s2.isEmpty()) {
					s2.pop();
				}
			}else {
				s2.push(c);
			}
		}
		
		return s1==s2;
	}
	
	public boolean backspaceCompare2(String S, String T) {
		//不能新建空的字符串来保存处理之后的结果,在遍历的过程中同时进行比较
		int cnt1=0, cnt2=0;
		for(int i=S.length()-1, j=T.length()-1; i>=0 || j>=0; i--,j--) {
			while(i>=0 && (S.charAt(i)=='#' || cnt1>0)) {
				if(S.charAt(i)=='#') cnt1++;
				else cnt1--;
				i--;
			}
			while(j>=0 && (S.charAt(j)=='#' || cnt2>0)) {
				if(S.charAt(j)=='#') cnt2++;
				else cnt2--;
				j--;
			}
			if(i<0 && j<0) return true;
			if(i<0 || j<0) return false;
			if(S.charAt(i)!=toString().charAt(j)) return false;
		}
		return true;
	}
	
	
	public boolean backspaceCompare3(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        while (true) {
            for (int back = 0; i >= 0 && (back > 0 || S.charAt(i) == '#'); --i)
                back += S.charAt(i) == '#' ? 1 : -1;
            for (int back = 0; j >= 0 && (back > 0 || T.charAt(j) == '#'); --j)
                back += T.charAt(j) == '#' ? 1 : -1;
            if (i >= 0 && j >= 0 && S.charAt(i) == T.charAt(j)) {
                i--; j--;
            } else
                return i == -1 && j == -1;
        }
    }
}
