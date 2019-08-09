package com.java.campus;
/**
 * 22娘和33娘接到了小电视君的扭蛋任务：
一共有两台扭蛋机，编号分别为扭蛋机2号和扭蛋机3号，22娘使用扭蛋机2号，33娘使用扭蛋机3号。
扭蛋机都不需要投币，但有一项特殊能力：
扭蛋机2号：如果塞x（x范围为>=0正整数）个扭蛋进去，然后就可以扭到2x+1个
扭蛋机3号：如果塞x（x范围为>=0正整数）个扭蛋进去，然后就可以扭到2x+2个
22娘和33娘手中没有扭蛋，需要你帮她们设计一个方案，
两人“轮流扭”（谁先开始不限，扭到的蛋可以交给对方使用），
用“最少”的次数，使她们能够最后恰好扭到N个交给小电视君。

输入
输入一个正整数，表示小电视君需要的N个扭蛋。   10

输出
输出一个字符串，每个字符表示扭蛋机，字符只能包含"2"和"3"。 233

输入：10

输出：233
--------------------- 
 * @author WangShuaiJie
 *
 */
public class Solution10 {
	/*
	 * 思路：正向向上加到 N，比较难办到；但是倒着想，就好办多了；
首先肯定是优先3号机，N减小得快；
10 =  2 * 4 + 2;   3
4 = 2 * 1 + 2；3 
1 = 2 * 0 + 1； 2 
11 = 2 * 5 + 1； 2
5 = 2 * 2 + 1； 2
2 = 2 * 0 + 2； 3
	 */
	public static void main(String[] args) {
		int n=10;
		StringBuilder res=new StringBuilder();
		help(n, res);
		System.out.println(res.reverse().toString());
	}
	
	private static void help(int n, StringBuilder sb) {
		if(n<=0) return ;
		if(n%2==0) {
			sb.append("3");
			help((n-2)/2, sb);
		}else {
			sb.append("2");
			help((n-1)/2, sb);
		}
	}
	
}
