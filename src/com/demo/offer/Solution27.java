package com.demo.offer;

public class Solution27 {
	/**
	 * ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
���罫��Ԫ������
                                            10
                                          /    \
                                        6      14
                                      /   \   /   \
                                     4     8 12   16
ǰ�����ת����˫������
4=6=8=10=12=14=16��
˼·������һ�������β�ڵ㣬�ݹ鴦��������������󷵻������ͷ�ڵ�
	 */
	public TreeNode convert(TreeNode root) {
		if(root==null) return null;
		TreeNode head=null, pre=null;
		inorder(root,pre,head);
		pre.right=head;
		head.left=pre;
		return head;
	}
	private void inorder(TreeNode node, TreeNode pre, TreeNode head) {
		if(node==null) return ;
		inorder(node.left, pre, head);
		if(head==null) {
			head=node;
			pre=node;
		}else {
			pre.right=node;
			node.left=pre;
			//����
			pre=node;
		}
		inorder(node.right, pre, head);
	}
	
	class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode(int x) {
			x=val;
		}
	}
}
