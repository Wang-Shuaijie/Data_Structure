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
	//����huffman��
	private static HuffmanTreeNode createHuffmanTree(int[] arr) {
		//��ʹ������������Ԫ�ش������ɸ�������
		List<HuffmanTreeNode> nodes=new ArrayList<>();
		for(int value:arr) {
			nodes.add(new HuffmanTreeNode(value));
		}
		//ѭ������
		while(nodes.size()>1) {	
			//����(�Ӵ�С)
			Collections.sort(nodes);
			//ȡ��Ȩֵ��С������������
			HuffmanTreeNode left=nodes.get(nodes.size()-1);
			HuffmanTreeNode right=nodes.get(nodes.size()-2);
			//����һ���µĶ�����
			HuffmanTreeNode parent=new HuffmanTreeNode(left.value+right.value);
			parent.left=left;
			parent.right=right;
			//��ȡ�����������������Ƴ�
			nodes.remove(left);
			nodes.remove(right);
			//����ԭ���Ķ���������
			nodes.add(parent);
		}
		return nodes.get(0);
	}
}
