package com.java.base.LinkedList;
/**
 * ˫��ѭ������
 * @author WangShuaiJie
 *
 */
public class DoubleNode {
	//��һ���ڵ�
	DoubleNode pre=this;
	//��һ���ڵ�
	DoubleNode next=this;
	//�ڵ�����
	int data;
	
	public DoubleNode(int data) {
		this.data=data;
	}
	
	//��ӽڵ�
	public void after(DoubleNode node) {
		//ԭ������һ���ڵ�
		DoubleNode nextNode = this.next;
		//���½ڵ���Ϊ��ǰ�ڵ����һ���ڵ�
		this.next=node;
		//��ǰ�ڵ�Ϊ�½ڵ����һ���ڵ�
		node.pre=this;
		//�½ڵ����һ���ڵ�Ϊԭ�ڵ����һ�ڵ�
		node.next=nextNode;
		//ԭ�ڵ����һ�ڵ����һ�ڵ�Ϊ�½ڵ�
		nextNode.pre=node;
	}
	
	//��һ�ڵ�
	public DoubleNode pre() {
		return this.pre;
	}
	
	//��һ�ڵ�
	public DoubleNode next() {
		return this.next;
	}
	
	//��ȡ����
	public int getData() {
		return this.data;
	}
}
