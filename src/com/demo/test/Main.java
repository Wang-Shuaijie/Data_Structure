package com.demo.test;

import java.util.Scanner;

public class Main {
	/**
	 * ���һ���ַ�����������ͬ�ַ������Ӷ���,�ͳ�����ַ�����ż��������"xyzxyz"��"aaaaaa"��ż��,����"ababab"��"xyzxy"ȴ���ǡ�
ţţ���ڸ���һ��ֻ����Сд��ĸ��ż��s,����Դ��ַ���s��ĩβɾ��1�ͻ��߶���ַ�,��֤ɾ��֮����ַ�������һ��ż��,ţţ��֪��ɾ��֮��õ��ż�������Ƕ��١�
	 */
	public static void main(String[] args) {
		//˼·����ż����ĩβ��ʼ���μ��������ַ�����ʣ�µ��ַ����ֳ������֣��ж��Ƿ���ȣ�
		//�Ǿ�����ѭ���õ����ȣ�����ٽ���
		Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        StringBuffer sb1=new StringBuffer(s);
        StringBuffer sb2=new StringBuffer();
        StringBuffer sb3=new StringBuffer();
        for(int i=s.length()-2;i>0;i--) {
        	 sb1.delete(i, s.length());
             sb2.append(sb1, 0, sb1.length()/2);//ǰһ���ַ�
             sb3.append(sb1, sb1.length()/2, sb1.length());//��һ���ַ�
             if((sb2.toString()).equals(sb3.toString())){
                 break;
             }
             i--;//Ϊ��ʵ��ÿ����2���ַ�����Ϊż���϶���ż�����ַ�
             sb2.delete(0, sb2.length());
             sb3.delete(0, sb3.length());
         }
         System.out.println(sb1.length());
         sc.close();
	}
}
