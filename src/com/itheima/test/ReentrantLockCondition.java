package com.itheima.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCondition implements Runnable {
    public static ReentrantLock lock=new ReentrantLock();
    public static Condition condition=lock.newCondition();
	@Override
	public void run() 
	{
		lock.lock();
        try 
        {
			condition.await();
			System.out.println("Thread is going on");
		} 
        catch (InterruptedException e)
		{
		  e.printStackTrace();
		}
        finally
        {
          lock.unlock();
        }
    }
   public static void main(String[] args) throws InterruptedException
   {
	   ReentrantLockCondition t=new ReentrantLockCondition();
	   Thread t1=new Thread(t);
	   t1.start();
	   Thread.sleep(6000);
	   lock.lock();
	   condition.signal();
	   lock.unlock();
   }
}
