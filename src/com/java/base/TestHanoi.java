package com.java.base;
/**
 * 汉诺塔问题
 * @author WangShuaiJie
 *
 */
public class TestHanoi {
	/**
	 * 
	 * @param n共有几个盘子
	 * @param from开始柱子
	 * @param in中间的柱子
	 * @param to目标柱子
	 */
	public static void hanoi(int n ,char from, char in, char to) {
		//只有一个
		if(n == 1) {
			System.out.println("第一个盘子从"+from+"移到"+to);
		//无论有多少个盘子，都认为只有两个，上面所有盘子和最下面的盘子
		}else {
			//移动上面所有盘子到中间位置
			hanoi(n-1, from, to, in);
			//移动下面的盘子
			System.out.println("第"+n+"个盘子从"+from+"移到"+to);
			//把上面所有盘子从中间位置移到目标位置
			hanoi(n-1, in, from, to);
		}
	}
	
	
	
	public static void main(String[] args) {
		hanoi(3, 'A', 'B', 'C');
	}
}
