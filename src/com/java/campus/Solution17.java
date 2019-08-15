package com.java.campus;

import java.util.Scanner;

/**
 * 从业 666 年的 BILIBILI 网络安全工程师 KindMo 最近很困惑，公司有一个业务总是受到 SSRF 攻击。
 * 请帮他写一个程序，判断输入的字符串是否属于内网IP，用于防御该漏洞。
我们知道常见的内网IP有，127.0.0.1，192.168.0.1 等

输入描述:
每次输入仅包含一个IP字符串，即一个测试样例

输出描述:
对于每个测试实例输出整数1或0，1代表True，即输入属于内网IP，0代表False，即输入不属于内网IP或不是IP字符串。

示例1
输入
42.96.146.169

输出
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
