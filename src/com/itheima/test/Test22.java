package com.itheima.test;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

/*
 * 观察者模式
 */
public class Test22
{
   public static void main(String[] args)
   {
	   //测试，被观察者对象，被观察者对象中维系着一个观察者队列
	   MyObservable m=new MyObservable("yyy");
	   //观察者
	   MyObserver observer=new MyObserver();
	   //往被观察者队列中加入观察者对象
	   m.addObserver(observer);
	   //事件发生
	   m.setName("ghj");
   }
}
/*
 * 观察者实现Observer接口
 */
class MyObserver implements Observer 
{
	@Override
	public void update(Observable o, Object value)
	{
	   System.out.println("观察者："+o+"值已经改变为："+value);
	}
}
/*
 * 被观察者继承Observable类
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
