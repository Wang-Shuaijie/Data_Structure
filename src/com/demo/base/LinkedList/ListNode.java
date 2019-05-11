package com.demo.base.LinkedList;
/**
 * ��������
 * @author WangShuaiJie
 *
 */
public class ListNode {
	//�ڵ�����
	int data;
	//��һ�ڵ�
	ListNode next;
	
	public ListNode(int data) {
		this.data=data;
	}
	
	//Ϊ�ڵ�׷�ӽڵ�
	public ListNode append(ListNode node) {
		//this.next=node;ֻ��׷��һ��
		ListNode currentNode=this;
		//ѭ������һ�ڵ�
		while(true) {
			//ȡ����ǰ�ڵ����һ���ڵ�
			ListNode nextNode=currentNode.next;
			if(nextNode==null) {
				break;
			}
			//������ǰ�ڵ�
			currentNode=nextNode;
		}
		//����Ҫ׷�ӵĽڵ�׷��Ϊ�ҵ��ĵ�ǰ�ڵ����һ���ڵ�
		currentNode.next=node;
		return this;
	}
	
	//ɾ����ǰ�ڵ����һ���ڵ�
	public void removeNode() {
		//ȡ�����¸��ڵ�
		ListNode nextNode=this.next.next;
		//�����¸��ڵ�����Ϊ��ǰ�ڵ����һ���ڵ�
		this.next=nextNode;
	}
	
	//����ڵ���Ϊ��ǰ�ڵ����һ���ڵ�
	public void insertNode(ListNode node) {
		//ȡ����ǰ�ڵ����һ���ڵ㣬��Ϊ���½ڵ�
		ListNode nextNode = this.next;
		//���½ڵ���Ϊ��ǰ�ڵ����һ���ڵ�
		this.next=node;
		node.next=nextNode;
	}
	
	//��ȡ��һ���ڵ�
	public ListNode next() {
		return this.next;
	}
	
	//��ȡ�ڵ�����
	public int getData() {
		return this.data;
	}
	
	//��ǰ�ڵ��Ƿ�Ϊ���һ���ڵ�
	public boolean isLast() {
		return this.next==null;
	}
	
	//��ʾ���нڵ���Ϣ
	public void show() {
		ListNode currentNode=this;
		while(true) {
			if(currentNode==null) {
				break;
			}
			System.out.print(currentNode.data+"-");
			currentNode=currentNode.next;
		}
	}
}
