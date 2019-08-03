package com.java.��ָoffer;

public class Solution58 {
	/**
	 * ����������һ���ڵ�
	 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�
	 * ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ��
	 */
	public TreeLinkNode getNext(TreeLinkNode node) {
		if(node==null) return null;
		if(node.right!=null) {
			node=node.right;
			while(node.left!=null) {
				node=node.left;
			}
			return node;
		}
		while(node.next!=null) {
			// �ҵ�һ����ǰ�ڵ��Ǹ��ڵ����� �Ľڵ�
			TreeLinkNode parent=node.next;
			if(parent.left==node) {
				return parent;
			}
			node=node.next;
		}
		return null;
	}
	
	class TreeLinkNode{
		int val;
		TreeLinkNode left;
		TreeLinkNode right;
        // nextָ�򸸽�㣬��Ŀ�и�����
		TreeLinkNode next;
		public TreeLinkNode(int x) {
			val=x;
		}
	}
}
