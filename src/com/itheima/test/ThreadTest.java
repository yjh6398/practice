package com.itheima.test;

public class ThreadTest extends Thread { 
    public int i=0;
	public void run()
	{
		for(i=0;i<=1000;i++){
			
		}
	}
	public static void main(String[] args) throws InterruptedException
	{
		ThreadTest tt=new ThreadTest();
		tt.start();
		tt.join();
		System.out.println(tt.i);
	}
}
