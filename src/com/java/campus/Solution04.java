package com.java.campus;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Ѱ�ҺϷ��ַ���
����һ��������n����������еİ���n��'('��n��')'���ַ�����ʹ��'('��')'������ȫƥ�䡣
���磺
'(())()'��'()()()' ���ǺϷ��ģ�
'())()('�ǲ��Ϸ��ġ�
�밴��__�ֵ���__�������кϷ����ַ���
 * @author WangShuaiJie
 *
 */
public class Solution04 {
	public static List<String> findLegalString(int n){
		List<String> res=new ArrayList<String>();
		helper(0, n, n, "", res, n);
		return res;
	}
	
	/**
	 * 
	 * @param len:��ǰ�ַ����ĳ���
	 * @param left:��ǰ�����ŵĸ���
	 * @param right:��ǰ�����ŵĸ���
	 * @param str:��ǰ�ַ���
	 * @param res:��ǰ�ַ�������
	 * @param n:��Ҫ�������ź������ŵĸ���
	 */
	private static void helper(int len, int left, int right, String str, List<String> res, int n) {
		if(len==2*n) {
			res.add(str);
			return ;
		}
		// ֻҪ���������ž��������������
		if(left>0) {
			helper(len+1, left-1, right, str+"(", res, n);
		}
		// ֻ�е������ŵĸ������������ŵ�ʱ������뵱ǰ�ַ��������������
		if(right>left) {
			helper(len+1, left, right-1, str+")", res, n);
		}
	}
	
	  public static void main(String[] args) {
	        Scanner input = new Scanner(System.in);
	        while(input.hasNext()) {
	            int num = input.nextInt();
	            List<String> res = findLegalString(num);
	            for (int i = 0; i < res.size(); i ++) {
	                System.out.print(res.get(i));
	                if (i != res.size() - 1)
	                    System.out.print(",");
	            }
	            System.out.println();

	        }
	    }
}
