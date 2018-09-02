package com.itheima.test;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/*
 * �۲���ģʽ
 */
public class Test22
{
   public static void main(String[] args)
   {
	   //���ԣ����۲��߶��󣬱��۲��߶�����άϵ��һ���۲��߶���
	   MyObservable m=new MyObservable("yyy");
	   //�۲���
	   MyObserver observer=new MyObserver();
	   //�����۲��߶����м���۲��߶���
	   m.addObserver(observer);
	   //�¼�����
	   m.setName("ghj");
   }
}
/*
 * �۲���ʵ��Observer�ӿ�
 */
class MyObserver implements Observer 
{
	@Override
	public void update(Observable o, Object value)
	{
	   System.out.println("�۲��ߣ�"+o+"ֵ�Ѿ��ı�Ϊ��"+value);
	}
}
/*
 * ���۲��߼̳�Observable��
 */
class MyObservable extends Observable
{
	ArrayList<Observer> list=new ArrayList<Observer>();
	public void addObserver(Observer o)
	{
		list.add(o);
	}
	public void remove(Observer o)
	{
		list.remove(o);
	}
	public void notifyObserver(Object value)
	{
		for(Observer o:list)
		{
			o.update(this, value);
		}
	}
	public String name;
	public MyObservable(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name=name;
		notifyObserver(name);
	}
}
