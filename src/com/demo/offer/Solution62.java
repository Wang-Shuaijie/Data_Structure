package com.demo.offer;

public class Solution62 {
	/**
	 * ��ʵ�������������ֱ��������л��ͷ����л�������
	 * ���л���ǰ����������������ַ����У������л�������ǰ������ؽ���������
	 */
	public String serialize(TreeNode root) {
		StringBuilder sb=new StringBuilder();
		if(root==null) {
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val+",");
		sb.append(serialize(root.left));
		sb.append(serialize(root.right));
		return sb.toString();
	}
	
	private int index=-1;
	public TreeNode deserialize(String s) {
		index++;
		if(s==null || s.length()==0) return null;
		if(index>=s.length()) return null;
		String[] str=s.split(",");
		TreeNode root=null;
		if(!str[index].equals("#")) {
			root = new TreeNode(Integer.valueOf(str[index]));
			root.left=deserialize(s);
			root.right=deserialize(s);
		}
		return root;
	}
	
	
	
	
	//����CyC2018�ⷨ
	private String deserializeStr;

	public String Serialize(TreeNode root) {
	    if (root == null)
	        return "#";
	    return root.val + " " + Serialize(root.left) + " " + Serialize(root.right);
	}

	public TreeNode Deserialize(String str) {
	    deserializeStr = str;
	    return Deserialize();
	}

	private TreeNode Deserialize() {
	    if (deserializeStr.length() == 0)
	        return null;
	    int index = deserializeStr.indexOf(" ");
	    String node = index == -1 ? deserializeStr : deserializeStr.substring(0, index);
	    deserializeStr = index == -1 ? "" : deserializeStr.substring(index + 1);
	    if (node.equals("#"))
	        return null;
	    int val = Integer.valueOf(node);
	    TreeNode t = new TreeNode(val);
	    t.left = Deserialize();
	    t.right = Deserialize();
	    return t;
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
