package com.itheima.test;

/*
 * 题目要求，设计四个线程，其中两个线程每次对j增加1，另外两个线程每次对j减少1
 */
public class Test3 {
	private int j;
	  public static void main(String[] args)
	  {
		 Test3 t=new Test3();
		 Inc inc=t.new Inc();
		 Dec dec=t.new Dec();
		 for(int i=0;i<2;i++)
		 {
			 Thread tt=new Thread(inc);
			 tt.start();
			 tt=new Thread(dec);
			 tt.start();
		 }
	  }
	  //实现自增运算
	  private synchronized void inc()
	  {
		  j++;
		  System.out.println(Thread.currentThread().getName()+":"+"-inc-"+j);
	  }
	  //实现自碱运算
	  private synchronized void dec()
	  {
		  j--;
		  System.out.println(Thread.currentThread().getName()+":"+"'-dec-"+j);
	  }
	  //内部类1
	  class Inc implements Runnable
	  {
		@Override
		public void run()
		{
			// TODO Auto-generated method stub
			for(int i=0;i<100;i++)
			{
				inc();
			}
		}
	  }
	  //内部类2
	  class Dec implements Runnable
	  {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=0;i<100;i++)
			{
				dec();
			}
		}
	  }
}