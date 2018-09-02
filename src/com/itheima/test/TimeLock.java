package com.itheima.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class TimeLock implements Runnable {
    /*
     * 限时等待锁的使用
     * 
     */
	public ReentrantLock lock=new ReentrantLock();
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try{
			if(lock.tryLock(5,TimeUnit.SECONDS))
			{
				Thread.sleep(6000);
			}
			else{
				System.out.println("get lock failed");
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			if(lock.isHeldByCurrentThread())
				lock.unlock();
		}
	}
    public static void main(String[] args)
    {
    	TimeLock t=new TimeLock();
    	Thread t1=new Thread(t);
    	Thread t2=new Thread(t);
    	t1.start();
    	t2.start();
    	
    	
    }
}
