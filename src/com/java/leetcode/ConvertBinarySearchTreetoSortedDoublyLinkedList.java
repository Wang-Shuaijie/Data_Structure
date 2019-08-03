package com.java.leetcode;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList {
	/**
	 * ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
���罫��Ԫ������
                                            10
                                          /    \
                                        6      14
                                      /   \   /   \
                                     4     8 12   16
ת����˫������
4=6=8=10=12=14=16��
	 */
	public TreeNode treeToDoublyList(TreeNode root) {
		if(root==null) return null;
		TreeNode head=null, pre=null;
		inorder(root,pre,head);
		pre.right=head;
		head.left=pre;
		return head;
	}

	private void inorder(TreeNode root, TreeNode pre, TreeNode head) {
		if(root==null) return ;
		inorder(root.left, pre, head);
		if(head==null) {
			head=root;
			pre=root;
		}else {
			pre.right=root;
			root.left=pre;
			pre=root;
		}
		inorder(root.right, pre, head);
	}
}
