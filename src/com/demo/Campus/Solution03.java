package com.demo.Campus;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，
 * 对于每个小朋友i，当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，
 * 他才会上去表演节目。老师的目标是将巧克力分发给孩子们，使得最多的小孩上台表演。
 * 可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。
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
