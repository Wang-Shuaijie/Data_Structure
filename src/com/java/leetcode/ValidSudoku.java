package com.java.leetcode;

import java.util.HashSet;

public class ValidSudoku {
	/**
	 * 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
	 *  数字 1-9 在每一行只能出现一次。
	 *  数字 1-9 在每一列只能出现一次。
	 *  数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
	 *  输入:
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
		输出: true
	 */
	public static boolean isValidSudoku(char[][] board) {
		//char[9][9] 9行9列
		for(int i=0;i<board.length;i++) {
			HashSet<Character> rows=new HashSet<>();
			HashSet<Character> cols=new HashSet<>();
			HashSet<Character> cube=new HashSet<>();
			
			for(int j=0;j<board[0].length;j++) {
				//判断横行内是否有数相同
				/*
				 * HashSet不能添加重复的元素，当调用add（Object）方法时候，
				 * 首先会调用Object的hashCode方法判hashCode是否已经存在，如不存在则直接插入元素；
				 * 如果已存在则调用Object对象的equals方法判断是否返回true，如果为true则说明元素已经存在，如为false则插入元素。
				 */
				if(board[i][j]!='.' && !rows.add(board[i][j])) return false;
				//判断一列
				if(board[j][i]!='.' && !cols.add(board[j][i])) return false;
				
				//判断3*3格
				/**
				 * i:       0 1 2 3 4 5 6 7 8 
				 * rowIndex:0 0 0 3 3 3 6 6 6
				 * colIndex:0 3 6 0 3 6 0 3 6
				 * 
				 * j/3:0 0 0 1 1 1 2 2 2
				 * j%3:0 1 2 0 1 2 0 1 2
				 * 
				 * rowIndex+j/3:0 0 0 1 1 1 2 2 2
				 * 				0 0 0 1 1 1 2 2 2
				 * 				0 0 0 1 1 1 2 2 2
				 * 		        3 3 3 4 4 4 5 5 5
				 * ...
				 * colIndex+j%3:0 1 2 0 1 2 0 1 2
				 * 				3 4 5 3 4 5 3 4 5
				 * 				6 7 8 6 7 8 6 7 8	
				 */
				int rowIndex=3*(i/3);
				int colIndex=3*(i%3);
				if(board[rowIndex+j/3][colIndex+j%3]!='.' && !cube.add(board[rowIndex+j/3][colIndex+j%3])) {
					return false;
				}
				
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
		System.out.println(isValidSudoku(board));

	}
}
