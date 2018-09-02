package com.itheima.test;

import java.util.concurrent.locks.ReentrantLock;

public class FairLock implements Runnable {
    public static ReentrantLock fairLock=new ReentrantLock();
    
	@Override
	public void run()
	{
		// TODO Auto-generated method stub
		while(true)
		{
			try
			{
			fairLock.lock();
			System.out.println(Thread.currentThread().getId()+":"+"»ñµÃËø");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				fairLock.unlock();
			}
		}
	}
    public static void main(String[] args)
    {
    	FairLock t=new FairLock();
    	Thread t1=new Thread(t);
    	Thread t2=new Thread(t);
    	t1.start();
    	t2.start();
    }
}
