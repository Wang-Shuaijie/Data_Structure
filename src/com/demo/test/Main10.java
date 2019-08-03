package com.demo.test;
/**
 * 对于两个字符串A，B。请设计一个高效算法，找到B在A中第一次出现的起始位置。
 * 若B未在A中出现，则返回-1。 给定两个字符串A和B，及它们的长度lena和lenb，
 * 请返回题目所求的答案。 测试样例： "acbc",4,"bc",2 返回：2 
 * @author WangShuaiJie
 *
 */
public class Main10 {
	public int findAppearance(String A, String B) {
		String [] result = A.split(B, 2);
        if(result.length==1)
            return -1;
        return result[0].length(); 
	}
}
