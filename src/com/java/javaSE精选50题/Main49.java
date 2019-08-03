package com.java.javaSE精选50题;
/**
 * 题目：计算字符串中子串出现的次数

程序分析：把string类型的字符串的每个元素，转换为char数组里面的每个数组的值string.toCharArray()
 * @author WangShuaiJie
 *
 */
public class Main49 {
	//判断char数组中是否存在空格，存在的话子字符串数量加1
	private static int count(String str) {
		int count=0;
		for(char c:str.toCharArray()) {
			if(c==' ') {
				count++;
			}
		}
		return count;
	}
}
