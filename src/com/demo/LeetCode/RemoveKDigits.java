package com.demo.LeetCode;

public class RemoveKDigits {
	/**
	 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。

注意:

    num 的长度小于 10002 且 ≥ k。
    num 不会包含任何前导零。

示例 1 :

输入: num = "1432219", k = 3
输出: "1219"
解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。

示例 2 :

输入: num = "10200", k = 1
输出: "200"
解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。

示例 3 :

输入: num = "10", k = 2
输出: "0"
解释: 从原数字移除所有的数字，剩余为空就是0。

	 */
	public static String removeKdigits(String num,int k) {
		//思路：124682385  K=1 12462385  k=2 1242385  k=3 122385
		//最优解永远是移除第一次出现的   左边的数>右边的数
		//即将连续递增的最大数移除
		if(num==null || num.length()==0) return "0";
		//将String类型转换为StringBuilder类型
		StringBuilder res=new StringBuilder(num);
		for(int i=0;i<k;i++) {
			int j=0;
			while(j<res.length()-1 && res.charAt(j)<=res.charAt(j+1)) {
				j++;			
			}
			//移除末尾的情况	
			if(j==res.length()-1) {
				res.deleteCharAt(j);
			}else {
				res.delete(j, j+1);//移除res.charAt(j);			
			}
		}
		//首位是0的情况
		while(res.length()>1 && res.charAt(0)=='0') res.delete(0, 1);
		//全部移除的情况
		while(res.length()==0) return "0";
		
		return res.toString();
	}
	
	public static void main(String[] args) {
		String num="124682385";
		System.out.println(removeKdigits(num, 3));
	}
}
