package com.itheima.test;

/*
 * ��ĿҪ������ĸ��̣߳����������߳�ÿ�ζ�j����1�����������߳�ÿ�ζ�j����1
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
	  //ʵ����������
	  private synchronized void inc()
	  {
		  j++;
		  System.out.println(Thread.currentThread().getName()+":"+"-inc-"+j);
	  }
	  //ʵ���Լ�����
	  private synchronized void dec()
	  {
		  j--;
		  System.out.println(Thread.currentThread().getName()+":"+"'-dec-"+j);
	  }
	  //�ڲ���1
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
	  //�ڲ���2
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