package com.demo.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaystoAddparentheses {
	/**
	 * ����һ���������ֺ���������ַ�����Ϊ���ʽ������ţ��ı����������ȼ��������ͬ�Ľ��������Ҫ�������п��ܵ���ϵĽ������Ч��������Ű��� +, - �Լ� * ��

ʾ�� 1:

����: "2-1-1"
���: [0, 2]
����: 
((2-1)-1) = 0 
(2-(1-1)) = 2

ʾ�� 2:

����: "2*3-4*5"
���: [-34, -14, -10, -10, 10]
����: 
(2*(3-(4*5))) = -34 
((2*3)-(4*5)) = -14 
((2*(3-4))*5) = -10 
(2*((3-4)*5)) = -10 
(((2*3)-4)*5) = 10


	 */
	
	public static List<Integer> diffWaysToCompute(String input){
		List<Integer> res = new ArrayList<Integer>();
        for (int i=0; i<input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*') {
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1,input.length()));
                for (int l : left) {
                    for (int r : right) {
                        switch(ch) {
                        case '+' :
                            res.add(l+r);
                            break;
                        case '-' :
                            res.add(l-r);
                            break;
                        case '*' :
                            res.add(l*r);
                            break;
                        }
                    }
                }
            }
        }
        if (res.size() == 0) res.add(Integer.valueOf(input));
        return res;

	}
	
	
	public static void main(String[] args) {
		String input="2*3-4*5";
		List<Integer> res=diffWaysToCompute(input);
		System.out.println(res.toString());
	}
}
