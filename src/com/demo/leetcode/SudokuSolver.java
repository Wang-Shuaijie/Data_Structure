package com.demo.leetcode;

public class SudokuSolver {
	/**
	 * ��дһ������ͨ�������Ŀո�������������⡣
	 * һ�������Ľⷨ����ѭ���¹���
	 *  ���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
	 *  ���� 1-9 ��ÿһ��ֻ�ܳ���һ�Ρ�
	 *  ���� 1-9 ��ÿһ���Դ�ʵ�߷ָ��� 3x3 ����ֻ�ܳ���һ�Ρ�
	 *  �հ׸��� '.' ��ʾ��
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
