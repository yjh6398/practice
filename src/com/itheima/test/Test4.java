package com.itheima.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Reader;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.util.ArrayList;
import java.util.SortedMap;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/*
 * 编写两个线程，其中一个线程打印1—52，另外一个线程打印A-Z，打印顺序为12A34B....
 */
public class Test4
{
	public static void main(String[] args)
	   {
		
		   Lock lock=new ReentrantLock();
		   Condition con=lock.newCondition();
		   Object obj=new Object();
		   FutureTask<Object> fs=new FutureTask<Object>(new Shuzi(obj));
		   FutureTask<Object> fz=new FutureTask<Object>(new Zimu(obj));
		   System.out.println("第一种线程通信方式");
//		   new Thread(fs).start();
//		   new Thread(fz).start();
		   System.out.println("第二种通讯方式");
	       new Thread(new Shuzi1(lock,con)).start();
	       new Thread(new Zimu1(lock,con)).start();
	   }
}

	class Shuzi implements Callable
	{
		public Object obj;
		public Shuzi(Object obj)
		{
			this.obj=obj;
		}
		public Object call()
		{
			synchronized(obj)
			{
				for(int i=1;i<53;i++)
				{
					System.out.print(i);
					if(i%2==0)
					{
						obj.notifyAll();
						try
						{
							obj.wait();
						}
						catch(InterruptedException e)
						{
							e.printStackTrace();
						}
					}
				}
				return null;
			}
		}
	}
	class Zimu implements Callable
	{
		public Object obj;
		public Zimu(Object obj)
		{
			this.obj=obj;
		}
		public Object call()
		{
			synchronized(obj)
			{
				for(int i=0;i<26;i++)
				{
					System.out.print((char)(i+'A'));
					obj.notifyAll();
					try
					{
						obj.wait();
					}
					catch(InterruptedException e)
					{
						e.printStackTrace();
					}
				}
				return null;
			}
		}
	}
    class Shuzi1 implements Runnable
    {
    	Lock lock;
    	Condition con;
    	public Shuzi1(Lock lock,Condition con)
    	{
    		this.lock=lock;
    		this.con=con;
    	}
    	public void run()
    	{
    		lock.lock();
    		for(int i=1;i<53;i++)
    		{
    			System.out.println(i);
    			if(i%2==0)
    			{
    				con.signalAll();
    				try
    				{
    					con.await();
    				}
    				catch(InterruptedException e)
    				{
    					e.printStackTrace();
    				}
    			}
    		}
		    lock.unlock();
    	}
    }
    class Zimu1 implements Runnable
    {
    	Lock lock;
    	Condition con;
    	public Zimu1(Lock lock,Condition con)
    	{
    		this.con=con;
    		this.lock=lock;
    	}
    	public void run()
    	{
    		lock.lock();
    		for(int i=0;i<26;i++)
    		{
    			System.out.println((char)(i+'A'));
    			con.signalAll();
    			try
    			{
    				con.await();
    			}
    			catch(InterruptedException e)
    			{
    			     e.printStackTrace();
    			}
    		}
    		lock.unlock();
    	}
    }