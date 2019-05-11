package com.demo.LeetCode;

import java.util.Stack;

public class BasicCalculatorIII {
	/**
	 * Some examples:

"1 + 1" = 2
" 6-4 / 2 " = 4
"2*(5+5*2)/3+(6/2+8)" = 21
"(2+6* 3+5- (3*14/7+2)*5)+3"=-12

	 */
	public static int calculate(String s) {
		if(s==null || s.length()==0) return 0;
		int n=s.length(), num=0, curRes=0, res=0;
		char op='+';
		for(int i=0;i<n;i++) {
			char c=s.charAt(i);
			if(c>='0' && c<='9') {
				num=num*10+c-'0';
			}else if(c=='(') {
				int j=0,count=0;
				for(;i<n;i++) {
					if(s.charAt(i)=='(') count++;
					if(s.charAt(i)==')') count--;
					if(count==0) break;
				}
				num=calculate(s.substring(j+1, i-j-1));
			}
			if (c == '+' || c == '-' || c == '*' || c == '/' || i == n - 1) {
				switch (op) {
				case '+':
					curRes+=num;
					break;

				case '-':
					curRes-=num;
					break;
				
				case '*':
					curRes*=num;
					break;
				
				case '/':
					curRes/=num;
					break;
				}
				if (c == '+' || c == '-' || i == n - 1) {
                    res += curRes;
                    curRes = 0;
                }
                op = c;
                num = 0;
			}
		}
		return res;
	}
}
