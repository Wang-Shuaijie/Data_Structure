package com.java.leetcode;

public class LowestCommonAncestorofaBinarySearchTree {
	/**
	 * ����һ������������, �ҵ�����������ָ���ڵ������������ȡ�

�ٶȰٿ�������������ȵĶ���Ϊ���������и��� T ��������� p��q������������ȱ�ʾΪһ����� x������ x �� p��q �������� x ����Ⱦ����ܴ�һ���ڵ�Ҳ���������Լ������ȣ�����

���磬�������¶���������:  root = [6,2,8,0,4,7,9,null,null,3,5]
       6
      / \
     2   8 
    / \ / \
   0  4 7  9
     / \
    3   5
 

ʾ�� 1:

����: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
���: 6 
����: �ڵ� 2 �ͽڵ� 8 ��������������� 6��

	 */
	
	//�������������ص���<��<��
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        /*
         * ���Ը��ڵ��ֵһֱ�����м�ֵ�����������������нڵ�ֵ��С�������������нڵ�ֵ����ô���ǿ��������µ��жϣ�������ڵ��ֵ����p��q֮��Ľϴ�ֵ��˵��p��q�����������У���ô��ʱ���Ǿͽ�����ڵ�����ӽڵ�����ݹ飬������ڵ�С��p��q֮��Ľ�Сֵ��˵��p��q�����������У���ô��ʱ���Ǿͽ�����ڵ�����ӽڵ�����ݹ飬��������ǣ���˵����ǰ���ڵ������С��ͬ���ڵ㣬ֱ�ӷ��ؼ���
         */
		if(root==null) return null;
		//��������
		if(root.val>Math.max(p.val, q.val)) {
			return lowestCommonAncestor(root.left, p, q);
		}
		//��������
		else if(root.val<Math.min(p.val, q.val)) {
			return lowestCommonAncestor(root.right, p, q);
		}else {
			return root;
		}
    }
	
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		val=x;
	}
}
}
