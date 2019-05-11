package com.demo.base.Tree.Huffman;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {
	public static void main(String[] args) {
		/*                    100
		 *                   /   \
		 * 		           42     58
		 * 			     /   \   /  \
		 * 				19   23 29  29 
		 *             /  \        /  \
		 *            8   11      14   15
		 *                            /  \
		 *                           7    8
		 *                               / \
		 *                              3   5 
		 */
		int[] arr= {3,7,8,29,5,11,23,14};
		HuffmanTreeNode node=createHuffmanTree(arr);
		System.out.println(node);
		node.levelOrder();
	}
	//创建huffman树
	private static HuffmanTreeNode createHuffmanTree(int[] arr) {
		//先使用数组中所有元素创建若干个二叉树
		List<HuffmanTreeNode> nodes=new ArrayList<>();
		for(int value:arr) {
			nodes.add(new HuffmanTreeNode(value));
		}
		//循环处理
		while(nodes.size()>1) {	
			//排序(从大到小)
			Collections.sort(nodes);
			//取出权值最小的两个二叉树
			HuffmanTreeNode left=nodes.get(nodes.size()-1);
			HuffmanTreeNode right=nodes.get(nodes.size()-2);
			//创建一个新的二叉树
			HuffmanTreeNode parent=new HuffmanTreeNode(left.value+right.value);
			parent.left=left;
			parent.right=right;
			//把取出来的两个二叉树移除
			nodes.remove(left);
			nodes.remove(right);
			//放入原来的二叉树集合
			nodes.add(parent);
		}
		return nodes.get(0);
	}
}
