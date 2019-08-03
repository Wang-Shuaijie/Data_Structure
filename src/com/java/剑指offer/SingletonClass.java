package com.java.剑指offer;

public class SingletonClass {
	//线程安全,效率高
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
	
	/*//饿汉式
	private static final SingletonClass instance=new SingletonClass();
	public static SingletonClass getInstance() {
		return instance;
	}*/
	
	/*//饱汉式
	private static SingletonClass instance=new SingletonClass();
	public static SingletonClass getInstance() {
		if(instance==null) {
			instance=new SingletonClass();
		}
		return instance;
	}*/
}
