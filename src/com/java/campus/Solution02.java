package com.java.campus;

import java.util.Scanner;

/**
 * 有两个用字符串表示的非常大的大整数,算出他们的乘积，也是用字符串表示。不能用系统自带的大整数类型
 * @author WangShuaiJie
 *
 */
public class Solution02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String str1 = sc.nextBigDecimal().toString();
			String str2 = sc.nextBigDecimal().toString();
			int len1 = str1.length();
			int len2 = str2.length();
			int[] num = new int[len1+len2];
			for(int i=len1-1;i>=0;i--){
				int x = str1.charAt(i)-'0';
				for(int j=len2-1;j>=0;j--){
					int y = str2.charAt(j)-'0';
					num[i+j] += (num[i+j+1]+x*y)/10;
					num[i+j+1] = (num[i+j+1]+x*y)%10;
				}
			}
			String s = "";
			for(int i=0;i<num.length;i++){
				if(i==0 && num[i]==0)
					continue;
				s+=num[i];
			}
			System.out.println(s);
		}
	}
}
