package com.java.leetcode;
/**
 * Example:

Input: 3
Output: 5
Explanation:
Given n = 3, there are a total of 5 unique BST's:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * @author WangShuaiJie
 *
 */
public class UniqueBinarySearchTrees {
	/*
	 * ���ƹ�ʽ:
f(n)=f(n-1)f(0)+f(n-2)f(1)+������.+f(1)f(n-2)+f(0)f(n-1) 
����ʹ�� Catalan �� C(N, 2N) / (N+1)
	 * �ɿ��������ĵ���ʽ�������Ƶ�����ͨ�ʽ���� C(2n,n)/(n+1)��
	 * ��ʾ�� 2n ����������ȡn�����ķ����ٳ��� n+1��
	 * ֻҪ�㻹û�����Ǹ��е�������ϵ�֪ʶ���Ͳ���д������Ĵ��룬ע������˵�ʱ��Ϊ�˷�ֹ�����������Ҫ����� res ����Ϊ������
	 */
	public long numTrees(int n) {
		long res=1;
		for (int i = n + 1; i <= 2 * n; ++i) {
            res = res * i / (i - n);
        }
        return res / (n + 1);
	}
}
