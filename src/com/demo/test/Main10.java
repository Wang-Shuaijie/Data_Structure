package com.demo.test;
/**
 * ���������ַ���A��B�������һ����Ч�㷨���ҵ�B��A�е�һ�γ��ֵ���ʼλ�á�
 * ��Bδ��A�г��֣��򷵻�-1�� ���������ַ���A��B�������ǵĳ���lena��lenb��
 * �뷵����Ŀ����Ĵ𰸡� ���������� "acbc",4,"bc",2 ���أ�2 
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
