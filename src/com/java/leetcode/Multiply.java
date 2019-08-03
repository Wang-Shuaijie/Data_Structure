package com.java.leetcode;

public class Multiply {
	/**
	 * 给定两个以字符串形式表示的非负整数 num1 和 num2，
	 * 返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
示例 1:

输入: num1 = "2", num2 = "3"
输出: "6"
	 */
	
	public static String multiply(String num1,String num2) {
		//不能使用int num=Integer.parseInt(num1);
		/**
		 * 这道题让我们求两个字符串数字的相乘，
		 * 输入的两个数和返回的数都是以字符串格式储存的，
		 * 这样做的原因可能是这样可以计算超大数相乘，
		 * 可以不受int或long的数值范围的约束，那么我们该如何来计算乘法呢，
		 * 我们小时候都学过多位数的乘法过程，都是每位相乘然后错位相加，
		 * 把错位相加后的结果保存到一个一维数组中，然后分别每位上算进位，
		 * 最后每个数字都变成一位，然后要做的是去除掉首位0，
		 * 最后把每位上的数字按顺序保存到结果中即可
		 */
		if(num1==null || num2==null) return "0";
		int[] digits=new int[num1.length()+num2.length()];
		for(int i=num1.length()-1;i>=0;i--) {
			for(int j=num2.length()-1;j>=0;j--) {
				int product=(num1.charAt(i)-'0')*(num2.charAt(j)-'0');
				
				int p1=i+j,p2=i+j+1;
				int sum=product+digits[p2];
				digits[p1]+=sum/10;
				digits[p2]=sum%10;
				
			}
		}
		StringBuilder res=new StringBuilder();
		for(int digit:digits) {
			if(!(digit==0 && res.length()==0)) {
				res.append(digit);
			}
		}
		return res.length()==0?"0":res.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(multiply("12", "5"));
	}
}
