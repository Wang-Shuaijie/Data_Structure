package com.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {
	/*
	 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
	 * 例如，给出 n = 3，生成结果为：
	 * [
	 * "((()))",
	 * "(()())",
	 * "(())()",
	 * "()(())",
	 * "()()()"
	 * ]
	 * 
	 * 卡特兰数
	 * [(0,n-1),(1,n-2),(3,n-3,....(n-1,n))]
	 * 由于字符串只有左括号和右括号两种字符，而且最终结果必定是左括号3个，右括号3个，
	 * 所以我们定义两个变量left和right分别表示剩余左右括号的个数，如果在某次递归时，左括号的个数大于右括号的个数，
	 * 说明此时生成的字符串中右括号的个数大于左括号的个数，即会出现')('这样的非法串，所以这种情况直接返回，不继续处理。
	 * 如果left和right都为0，则说明此时生成的字符串已有3个左括号和3个右括号，且字符串合法，则存入结果中后返回。
	 * 如果以上两种情况都不满足，若此时left大于0，则调用递归函数，注意参数的更新，若right大于0，则调用递归函数，同样要更新参数
	 */
	public static List<String> generateParenthesis(int n){
		List<String> res=new ArrayList<>();
		if(n==0) return res;
		helper(res, "", n, n);
		return res;
	}
	
	public static void helper(List<String> res,String s,int left,int right) {
		if(left>right) {
			return;
		}
		if(left==0 && right==0) {
			res.add(s);
			return;
		}
		if(left>0) {
			helper(res, s+"(", left-1, right);
		}
		if(right>0) {
			helper(res, s+")", left, right-1);
		}
	}
	
	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
	}
}
