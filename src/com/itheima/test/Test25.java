package com.itheima.test;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Test25
{
   public static void main(String[] args) throws InterruptedException, ExecutionException
   {
	   char[] chaArr=new char[10320];
	   FutureTask<Character> f_A=new FutureTask<Character>(new Thread_A());
	   FutureTask<Character> f_B=new FutureTask<Character>(new Thread_B());
	   FutureTask<Character> f_C=new FutureTask<Character>(new Thread_C());
	   FutureTask<Character> f_D=new FutureTask<Character>(new Thread_D());
	   Scanner sc=new Scanner(System.in);
	   int n=sc.nextInt();
	   for(int i=0;i<n;i++)
	   {
		   new Thread(f_A).start();
		   chaArr[i*4]=f_A.get();
		   new Thread(f_B).start();
		   chaArr[i*4+1]=f_B.get();
		   new Thread(f_C).start();
		   chaArr[i*4+2]=f_C.get();
		   new Thread(f_D).start();
		   chaArr[i*4+3]=f_D.get();
	   }
	   for(char obj:chaArr)
	   {
		   System.out.print(obj+"");
	   }
   }
}
class Thread_A implements Callable<Character>
{
	public Character call()
	{
		return 'A';
	}
}
class Thread_B implements Callable<Character>
{
	public Character call()
	{
		return 'B';
	}
}
class Thread_C implements Callable<Character>
{
	public Character call()
	{
		return 'C';
	}
}
class Thread_D implements Callable<Character>
{
	public Character call()
	{
		return 'D';
	}
}
