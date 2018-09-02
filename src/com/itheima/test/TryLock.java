package com.itheima.test;

import java.util.concurrent.locks.ReentrantLock;

public class TryLock implements Runnable {
    public static ReentrantLock lock1=new ReentrantLock();
    public static ReentrantLock lock2=new ReentrantLock();
    int lock;
    public TryLock(int lock)
    {
    	this.lock=lock;
    }
	@Override
	public void run() {
		// TODO Auto-generated method stub
        if(lock==1)
        {
        	while(true)
        	{
        		if(lock1.tryLock())
        		{
        			try
        			{
        				try{
        					Thread.sleep(6000);
        				}
        				catch(Exception e)
        				{
        					e.printStackTrace();
        				}
        				if(lock2.tryLock())
        				{
        					System.out.println(Thread.currentThread().getId()+":"+"mission get done");
        					lock2.unlock();
        					return;
        				}
        			}
        			catch(Exception e){
        				e.printStackTrace();
        			}
        			finally
        			{
        				lock1.unlock();
        			}
        		}
        		
        	}
        }
        else
        {
        	while(true)
        	{
        		if(lock2.tryLock())
        		{
        			try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					} 
        			if(lock1.tryLock()){
        				System.out.println(Thread.currentThread().getId()+":"+"Mission get done");
        				lock2.unlock();
        				return;
        			}
        			lock2.unlock();
        		}
        	}
        }
	}
    public static void main(String[] args)
    {
    	TryLock t=new TryLock(1);
    	Thread t1=new Thread(t);
    	Thread t2=new Thread(t);
    	t1.start();
    	t2.start();
    	
    }
}
