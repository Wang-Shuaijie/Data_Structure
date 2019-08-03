package com.demo.test;

import java.util.Scanner;

public class Main {
	/**
	 * 如果一个字符串由两个相同字符串连接而成,就称这个字符串是偶串。例如"xyzxyz"和"aaaaaa"是偶串,但是"ababab"和"xyzxy"却不是。
牛牛现在给你一个只包含小写字母的偶串s,你可以从字符串s的末尾删除1和或者多个字符,保证删除之后的字符串还是一个偶串,牛牛想知道删除之后得到最长偶串长度是多少。
	 */
	public static void main(String[] args) {
		//思路：从偶串的末尾开始依次减少两个字符，把剩下的字符串分成两部分，判断是否相等，
		//是就跳出循环得到长度，否就再进行
		Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        StringBuffer sb1=new StringBuffer(s);
        StringBuffer sb2=new StringBuffer();
        StringBuffer sb3=new StringBuffer();
        for(int i=s.length()-2;i>0;i--) {
        	 sb1.delete(i, s.length());
             sb2.append(sb1, 0, sb1.length()/2);//前一半字符
             sb3.append(sb1, sb1.length()/2, sb1.length());//后一半字符
             if((sb2.toString()).equals(sb3.toString())){
                 break;
             }
             i--;//为了实现每个减2个字符，因为偶串肯定是偶数个字符
             sb2.delete(0, sb2.length());
             sb3.delete(0, sb3.length());
         }
         System.out.println(sb1.length());
         sc.close();
	}
}
