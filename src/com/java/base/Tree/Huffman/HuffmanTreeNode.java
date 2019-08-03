package com.java.base.Tree.Huffman;

import java.util.LinkedList;
import java.util.Queue;

/**
 * �շ������ڵ�
 * @author WangShuaiJie
 *
 */
public class HuffmanTreeNode implements Comparable<HuffmanTreeNode>{
	int value;
	HuffmanTreeNode left;
	HuffmanTreeNode right;
	
	public HuffmanTreeNode(int value) {
		this.value=value;
	}
	
	public void levelOrder() {
		HuffmanTreeNode root=this;
		if(root==null) return;
		Queue<HuffmanTreeNode> queue=new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			HuffmanTreeNode temp=queue.poll();
			System.out.print(temp.value+" ");
			if(temp.left!=null) queue.add(temp.left);
			if(temp.right!=null) queue.add(temp.right);
		}
	}
	
	@Override
	public int compareTo(HuffmanTreeNode o) {
		//��С����
		//return this.value-o.value;
		//�Ӵ�С
		return -(this.value-o.value);
	}

	@Override
	public String toString() {
		return "Node [value=" + value + "]";
	}
	

}
