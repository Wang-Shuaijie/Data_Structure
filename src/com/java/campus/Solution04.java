package com.java.campus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 寻找合法字符串
给出一个正整数n，请给出所有的包含n个'('和n个')'的字符串，使得'('和')'可以完全匹配。
例如：
'(())()'，'()()()' 都是合法的；
'())()('是不合法的。
请按照__字典序__给出所有合法的字符串
 * @author WangShuaiJie
 *
 */
public class Solution04 {
	public static List<String> findLegalString(int n){
		List<String> res=new ArrayList<String>();
		helper(0, n, n, "", res, n);
		return res;
	}
	
	/**
	 * 
	 * @param len:当前字符串的长度
	 * @param left:当前左括号的个数
	 * @param right:当前右括号的个数
	 * @param str:当前字符串
	 * @param res:当前字符串的组
	 * @param n:需要的左括号和右括号的个数
	 */
	private static void helper(int len, int left, int right, String str, List<String> res, int n) {
		if(len==2*n) {
			res.add(str);
			return ;
		}
		// 只要还有左括号就能先添加左括号
		if(left>0) {
			helper(len+1, left-1, right, str+"(", res, n);
		}
		// 只有当右括号的个数大于左括号的时候才能想当前字符串中添加右括号
		if(right>left) {
			helper(len+1, left, right-1, str+")", res, n);
		}
	}
	
	  public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        while(input.hasNext()) {
	            int num = input.nextInt();
	            List<String> res = findLegalString(num);
	            for (int i = 0; i < res.size(); i ++) {
	                System.out.print(res.get(i));
	                if (i != res.size() - 1)
	                    System.out.print(",");
	            }
	            System.out.println();

	        }
	    }
}
