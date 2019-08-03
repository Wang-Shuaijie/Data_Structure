package com.demo.Campus;

import java.util.Arrays;
import java.util.Scanner;

/**
 * ��һ��ͯ�ڣ���ʦ���˺ܶ�óԵ��ɿ������׶�԰��ÿ���ɿ���j������Ϊw[j]��
 * ����ÿ��С����i�������ֵ����ɿ�����С�ﵽh[i] (��w[j]>=h[i])��
 * ���Ż���ȥ���ݽ�Ŀ����ʦ��Ŀ���ǽ��ɿ����ַ��������ǣ�ʹ������С����̨���ݡ�
 * ���Ա�֤ÿ��w[i]> 0�Ҳ��ܽ�����ɿ����ָ�һ�����ӻ�һ��ָ�������ӡ�
 * @author WangShuaiJie
 *
 */
public class Solution03 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int len1=sc.nextInt();
		int[] arr1=new int[len1];
		for(int i=0;i<len1;i++) {
			arr1[i]=sc.nextInt();
		}
		int len2=sc.nextInt();
		int[] arr2=new int[len2];
		for(int i=0;i<len2;i++) {
			arr2[i]=sc.nextInt();
		}
		System.out.println(findContentChildren(len1, arr1, len2, arr2));
	}
	private static int findContentChildren(int n, int[] h, int m, int[] w) {
		Arrays.sort(h);
		Arrays.sort(w);
		int i=0, j=0;
		while(i<n && j<m) {
			if(h[i]<=w[j]) {
				i++;
			}
			j++;
		}
		return i;
	}
}
