package com.demo.leetcode;

public class SudokuSolver {
	/**
	 * 编写一个程序，通过已填充的空格来解决数独问题。
	 * 一个数独的解法需遵循如下规则：
	 *  数字 1-9 在每一行只能出现一次。
	 *  数字 1-9 在每一列只能出现一次。
	 *  数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
	 *  空白格用 '.' 表示。
[
  ["5","3",".",".","7",".",".",".","."],
  ["6",".",".","1","9","5",".",".","."],
  [".","9","8",".",".",".",".","6","."],
  ["8",".",".",".","6",".",".",".","3"],
  ["4",".",".","8",".","3",".",".","1"],
  ["7",".",".",".","2",".",".",".","6"],
  [".","6",".",".",".",".","2","8","."],
  [".",".",".","4","1","9",".",".","5"],
  [".",".",".",".","8",".",".","7","9"]
]
	 */
	public static void solveSudoku(char[][] board) {
		if(board==null || board.length==0) return ;
		solve(board);
	}

	private static boolean solve(char[][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				if(board[i][j]=='.') {
					for(char c='1';c<='9';c++) {
						if(isValid(board,i,j,c)) {
							board[i][j]=c;
							//System.out.println(c);
							if(solve(board)) {
								return true;
							}else {
								return false;
							}
							
						}
					}
				}
			}
		}
		return true;
	}
	
	private static boolean isValid(char[][] board, int row, int col, char c) {
		for(int i=0;i<9;i++) {
			if(board[i][col]!='.' && board[i][col]==c) return false;
			if(board[row][i]!='.' && board[row][i]==c) return false;
			if(board[3*(row/3)+i/3][3*(col/3)+i/3]!='.'
					&& board[3*(row/3)+i/3][3*(col/3)+i/3]=='c') {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] board=new char[][] {
			{'5','3','.','.','7','.','.','.','.'},
			{'6','.','.','1','9','5','.','.','.'},
			{'.','9','8','.','.','.','.','6','.'},
			{'8','.','.','.','6','.','.','.','3'},
			{'4','.','.','8','.','3','.','.','1'},
			{'7','.','.','.','2','.','.','.','6'},
			{'.','6','.','.','.','.','2','8','.'},
			{'.','.','.','4','1','9','.','.','5'},
			{'.','.','.','.','8','.','.','7','9'}
		};
		solveSudoku(board);
	}
}
