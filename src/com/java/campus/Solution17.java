package com.java.campus;

import java.util.Scanner;

/**
 * ��ҵ 666 ��� BILIBILI ���簲ȫ����ʦ KindMo ��������󣬹�˾��һ��ҵ�������ܵ� SSRF ������
 * �����дһ�������ж�������ַ����Ƿ���������IP�����ڷ�����©����
����֪������������IP�У�127.0.0.1��192.168.0.1 ��

��������:
ÿ�����������һ��IP�ַ�������һ����������

�������:
����ÿ������ʵ���������1��0��1����True����������������IP��0����False�������벻��������IP����IP�ַ�����

ʾ��1
����
42.96.146.169

���
0
 * @author WangShuaiJie
 *
 */
public class Solution17 {
	public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String ip=sc.nextLine();
        if(validIp(ip)){
            System.out.println(1);
        }else{
            System.out.println(0);
        }
    }
     
    private static boolean validIp(String ip){
        String[] str=ip.split("\\.");
        if(str.length!=4) return false;
        if(Integer.valueOf(str[0])==10) {
        	return true;
        }else if(Integer.valueOf(str[0])==172) {
        	if(Integer.valueOf(str[1]) >= 16 && Integer.valueOf(str[1]) <= 32) {
        		return true;
        	}else {
        		return false;
        	}
        }else if(Integer.valueOf(str[0])==192 && Integer.valueOf(str[1])==168) {
        	return true;
        }else {
            return false;
        }
    }
}
