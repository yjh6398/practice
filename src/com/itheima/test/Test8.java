package com.itheima.test;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/*
 * 线程练习
 */ 
public class Test8 implements Callable<Integer>
{
	int count=0;
	public Integer call()
	{
		for(int i=0;i<10000;i++)
		{
		    count++;
	     	System.out.println(Thread.currentThread().getName()+":"+count+new Date());
	     	try {
				Thread.currentThread().sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return count;
	}
	public static void main(String[] args) throws InterruptedException, ExecutionException
	{
		Test8 t=new Test8();
		FutureTask<Integer> f=new FutureTask<Integer>(t);
		Thread t1=new Thread(f,"后台线程");
		t1.setDaemon(true);
		t1.start();
		for(int i=0;i<10;i++)
		{
			System.out.println(Thread.currentThread().getName()+":"+i+new Date());
			Thread.sleep(1000);
		}
	}
}