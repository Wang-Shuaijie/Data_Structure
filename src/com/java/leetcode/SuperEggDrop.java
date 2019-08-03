package com.java.leetcode;

public class SuperEggDrop {
	/**
	 * 你将获得 K 个鸡蛋，并可以使用一栋从 1 到 N  共有 N 层楼的建筑。

每个蛋的功能都是一样的，如果一个蛋碎了，你就不能再把它掉下去。

你知道存在楼层 F ，满足 0 <= F <= N 任何从高于 F 的楼层落下的鸡蛋都会碎，从 F 楼层或比它低的楼层落下的鸡蛋都不会破。

每次移动，你可以取一个鸡蛋（如果你有完整的鸡蛋）并把它从任一楼层 X 扔下（满足 1 <= X <= N）。

你的目标是确切地知道 F 的值是多少。

无论 F 的初始值如何，你确定 F 的值的最小移动次数是多少？

 

示例 1：

输入：K = 1, N = 2
输出：2
解释：
鸡蛋从 1 楼掉落。如果它碎了，我们肯定知道 F = 0 。
否则，鸡蛋从 2 楼掉落。如果它碎了，我们肯定知道 F = 1 。
如果它没碎，那么我们肯定知道 F = 2 。
因此，在最坏的情况下我们需要移动 2 次以确定 F 是多少。

	 */
	
	public static int superEggDrop(int K, int N) {
		/*
		 * 可以转化为一个求二叉树最小层数的问题，即找到每一层可容纳的最大节点数；

规则1：最顶层节点值为K；

规则2：当节点值为1时，只能存在左子节点；

规则3：当节点值不为1时，若存在左子节点，则左子节点值为k；若存在右子节点，则右子节点值为k-1；

按照以上规则，找出在根节点值为 K 的树中。前 i -1 层的最大节点数 < N     且     前 i 层的最大节点数 >= N，则 i 为所求的值。

		 */
		 // i 记录了层数信息
        // m 第 i 层的最大节点数
        // s 前 i 层最大节点数之和
        int m=1,i,sum=0;
        //前 K 层情况
        for(i=0;i<K;++i){
            sum += m;
            if(N<=sum) return ++i;
            m *= 2;
        }
     // temp 是辅助值
        int temp = m;
        // K 层以后的情况
        while(true){
            m = temp - C(i,i-K);
            sum += m;
            if(N<=sum) break;
            temp += m;
            ++i;
        }
        return ++i;
	}
	
	//定义组合函数 C(m,n)
    public static int C(int m,int n){
        if(n>m/2) n = m - n;
        int max=1,k=0;
        while(n-->0) max = max*(m--)/(++k);
        return max;
    }

    public static void main(String[] args) {
		int K=3,N=14;
		System.out.println(superEggDrop(K, N));
	}
}
