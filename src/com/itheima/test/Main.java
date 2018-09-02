package com.itheima.test;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class Main {
     public static void main(String[] args)
     {
    	 Executor pool=Executors.newCachedThreadPool();
         Pos pos=new Pos();
         for(int i=1;i<=10;i++)
         {
        	 pool.execute(new Car(i,pos));
         }
     }
}
class Pos
{
	boolean[] wei=new boolean[3];
	public Pos()
	{
		for(int i=0;i<wei.length;i++)
		{
			wei[i]=true;
		}
	}
	public int tiche(Car car)
	{
		while(true)
		{
			synchronized(Pos.class)
			{
				for(int i=0;i<wei.length;i++)
				{
					if(wei[i])
					{
						wei[i]=false;
						System.out.println("³µÍ£ÔÚ"+i+"ºÅ¿â");
						return i;
					}
				}
			}
		}
	}
	public void out(Car car)
	{
		while(true)
		{
			synchronized(Pos.class)
			{
				wei[car.num]=true;
				System.out.println(car.num+"Àë¿ª"+car.num+"ºÅ¿â");
				return;
			}
		}
	}
}
class Car implements Runnable
{
	int name;
	int num;
	Pos pos;
	public Car(int name,Pos pos)
	{
		super();
		this.name=name;
		this.pos=pos;
	}
	public void run()
	{
		this.num=pos.tiche(this);
		try
		{
			Thread.sleep(Math.abs(new Random().nextInt()%10000));
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
		pos.out(this);
	}
}
