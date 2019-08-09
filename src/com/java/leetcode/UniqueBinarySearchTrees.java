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
	 * 递推公式:
f(n)=f(n-1)f(0)+f(n-2)f(1)+……….+f(1)f(n-2)+f(0)f(n-1) 
或者使用 Catalan 数 C(N, 2N) / (N+1)
	 * 由卡特兰数的递推式还可以推导出其通项公式，即 C(2n,n)/(n+1)，
	 * 表示在 2n 个数字中任取n个数的方法再除以 n+1，
	 * 只要你还没有忘记高中的排列组合的知识，就不难写出下面的代码，注意在相乘的时候为了防止整型数溢出，要将结果 res 定义为长整型
	 */
	public long numTrees(int n) {
		long res=1;
		for (int i = n + 1; i <= 2 * n; ++i) {
            res = res * i / (i - n);
        }
        return res / (n + 1);
	}
}
