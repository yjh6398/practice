package com.itheima.test;
import java.util.concurrent.locks.ReentrantLock;
public class ReenterLock implements Runnable {
    public static ReentrantLock lock=new ReentrantLock();
    private static int i=0;
	@Override
	public void run() {
		// TODO Auto-generated method stub
        for(int j=0;j<=10000;j++)
        {
        	lock.lock();
        	try{
        		i++;
        	}
        	catch(Exception e)
        	{
        		
        	}
        	finally{
        	 lock.unlock();
        	}
        }
	}
    public static void main(String[] args) throws InterruptedException
    {
    	ReenterLock t=new ReenterLock();
    	Thread t1=new Thread(t);
    	Thread t2=new Thread(t);
    	t1.start();
    	t2.start();
    	t1.join();
    	t2.join();
    	System.out.println(i);
    }
}
