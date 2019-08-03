package com.demo.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Solution60 {
	/**
	 * ��ʵ��һ����������֮���δ�ӡ��������
	 * ��һ�а��մ����ҵ�˳���ӡ��
	 * �ڶ��㰴�մ��������˳���ӡ��
	 * �����а��մ����ҵ�˳���ӡ���������ơ�
	 */
	
	//���
	public List<List<Integer>> print(TreeNode root){
		List<List<Integer>> res=new ArrayList<>();
		if(root==null) return res;
		Queue<TreeNode> q1=new LinkedList<>();
		q1.add(root);
		int level=1;
		while(!q1.isEmpty()) {
			List<Integer> list=new ArrayList<>();
			for(int i=q1.size();i>0;i--) {
				TreeNode temp=q1.poll();
				list.add(temp.val);
				if(level%2==0) {
					if(temp.left!=null) q1.add(temp.left);
					if(temp.right!=null) q1.add(temp.right);
				}else {
					if(temp.right!=null) q1.add(temp.right);
					if(temp.left!=null) q1.add(temp.left);
				}
			}
			res.add(list);
			level++;
		}
		return res;
	}
	
	//������������ջ,һ��ջ�����ұ���Ԫ�أ�һ��ջ���ҵ��󱣴�Ԫ�ء�Ȼ�����ջ��Ԫ��,��ջ��ֱ������ջͬʱΪ�ա�
	public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
        if( pRoot == null ){
            return arrayList;
        }
        
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        s1.add( pRoot );
        Stack<TreeNode> s2 = new Stack<TreeNode>();
        while( !s1.empty() || !s2.empty()){
            if(!s1.empty()){
                ArrayList<Integer> list = new ArrayList<Integer>();
                while(!s1.empty()){
                    TreeNode node = s1.pop();
                    list.add(node.val);
                    if(node.left != null){
                        s2.add(node.left);
                    }
                    if(node.right != null){
                        s2.add(node.right);
                    }
                }
                arrayList.add(list);
            }else{
                ArrayList<Integer> list = new ArrayList<Integer>();
                while(!s2.empty()){
                
                    TreeNode node = s2.pop();
                    list.add(node.val);
                
                    if(node.right != null){
                        s1.add(node.right);
                    }
                    if(node.left != null){
                        s1.add(node.left);
                    }
                }
                arrayList.add(list);
            }
        }
       return arrayList;
        
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
