package com.java.��ָoffer;

public class SingletonClass {
	//�̰߳�ȫ,Ч�ʸ�
	private static volatile SingletonClass instace=null;
	private SingletonClass() { }
	public static SingletonClass getInstace() {
		if(instace==null) {
			synchronized(SingletonClass.class) {
				if(instace==null) {
					instace=new SingletonClass();
				}
			}
		}
		return instace;
	}
	
	/*//����ʽ
	private static final SingletonClass instance=new SingletonClass();
	public static SingletonClass getInstance() {
		return instance;
	}*/
	
	/*//����ʽ
	private static SingletonClass instance=new SingletonClass();
	public static SingletonClass getInstance() {
		if(instance==null) {
			instance=new SingletonClass();
		}
		return instance;
	}*/
}
