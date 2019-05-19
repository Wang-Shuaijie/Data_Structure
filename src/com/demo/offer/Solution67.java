package com.demo.offer;

public class Solution67 {
	/**
	 * 地上有一个m行和n列的方格。一个机器人从坐标0,0的格子开始移动，
	 * 每一次只能向左，右，上，下四个方向移动一格，
	 * 但是不能进入行坐标和列坐标的数位之和大于k的格子
	 * 
	 * 思路：思路：利用递归实现，每次只能走上下左右四个点，
	 * 进行判断点的位置是否越界，点数之和是否大于K，是否已经走过了。
	 */
	
	private static final int[][] next = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
	private int cnt = 0;
	private int rows;
	private int cols;
	private int threshold;
	private int[][] digitSum;

	public int movingCount(int threshold, int rows, int cols) {
	    this.rows = rows;
	    this.cols = cols;
	    this.threshold = threshold;
	    initDigitSum();
	    boolean[][] marked = new boolean[rows][cols];
	    dfs(marked, 0, 0);
	    return cnt;
	}

	private void dfs(boolean[][] marked, int r, int c) {
	    if (r < 0 || r >= rows || c < 0 || c >= cols || marked[r][c])
	        return;
	    marked[r][c] = true;
	    if (this.digitSum[r][c] > this.threshold)
	        return;
	    cnt++;
	    for (int[] n : next)
	        dfs(marked, r + n[0], c + n[1]);
	}

	private void initDigitSum() {
	    int[] digitSumOne = new int[Math.max(rows, cols)];
	    for (int i = 0; i < digitSumOne.length; i++) {
	        int n = i;
	        while (n > 0) {
	            digitSumOne[i] += n % 10;
	            n /= 10;
	        }
	    }
	    this.digitSum = new int[rows][cols];
	    for (int i = 0; i < this.rows; i++)
	        for (int j = 0; j < this.cols; j++)
	            this.digitSum[i][j] = digitSumOne[i] + digitSumOne[j];
	}
}
