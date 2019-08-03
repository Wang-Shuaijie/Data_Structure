package com.java.leetcode;

public class LowestCommonAncestorofaBinaryTree {
	/**
	 * ����һ��������, �ҵ�����������ָ���ڵ������������ȡ�

�ٶȰٿ�������������ȵĶ���Ϊ���������и��� T ��������� p��q������������ȱ�ʾΪһ����� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����

���磬�������¶�����:  root = [3,5,1,6,2,0,8,null,null,7,4]
       3
      / \
     5   1 
    / \ / \
   6  2 0  8
     / \
    7   4
ʾ�� 1:

����: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
���: 3
����: �ڵ� 5 �ͽڵ� 1 ��������������ǽڵ� 3��

	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		/*
		 * ��p��qҪô�ֱ�λ�����������У���ô�������ӽ����õݹ麯������ֱ𷵻�p��q����λ�ã�����ǰ������þ���p��q����С��ͬ����㣬ֱ�ӷ��ص�ǰ��㼴�ɣ��������Ŀ�е�����1�������

��p��qͬʱλ�������������������������һ�������left�᷵��p��q�нϸߵ��Ǹ�λ�ã���right�᷵�ؿգ������������շ��طǿյ�left���ɣ��������Ŀ�е�����2�����������һ������ǻ᷵��p��q����С����㣬����˵��ǰ�����������е�ĳ��������p��q����С����㣬�ᱻ���ء�

��p��qͬʱλ����������ͬ�����������������һ�������right�᷵��p��q�нϸߵ��Ǹ�λ�ã���left�᷵�ؿգ������������շ��طǿյ�right���ɣ�����һ������ǻ᷵��p��q����С����㣬����˵��ǰ�����������е�ĳ��������p��q����С����㣬�ᱻ����
		 */
		if(root==null || p==root || q==root) return root;
		TreeNode left=lowestCommonAncestor(root.left, p, q);
		TreeNode right=lowestCommonAncestor(root.right, p, q);
		
		return left==null?right:right==null?left:root;
		
	}

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x){
		val=x;
	}
}

}


