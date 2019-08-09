package com.java.campus;

import java.util.Scanner;
import java.util.Stack;

/**
 *  ����һ���Ϸ��ı��ʽ�ַ���������ֻ�����Ǹ��������ӷ��������Լ��˷����ţ����������ţ�������7+3*4*5+2+4-3-1����д�������ñ��ʽ�Ľ��������� 
 * @author WangShuaiJie
 *
 */
public class Solution13 {
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String str=sc.nextLine();
             
            if(!"END".equals(str)){
                System.out.println(calculate(str));
            }
        }
    }
     
    private static int calculate(String s){
        if (s == null || (s.length()) == 0)
            return 0;
        Stack<Integer> stack = new Stack<Integer>();
        int num = 0;
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = num * 10 + s.charAt(i) - '0';
            }
            if ((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == s.length() - 1) {
                if (sign == '-') {
                    stack.push(-num);
                }
                if (sign == '+') {
                    stack.push(num);
                }
                if (sign == '*') {
                    stack.push(stack.pop() * num);
                }
                if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
                sign = s.charAt(i);
                num = 0;
            }
        }
 
        int re = 0;
        for (int i : stack) {
            re += i;
        }
        return re;
 
    }
}
