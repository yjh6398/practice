package com.itheima.test;

import java.util.Scanner;

public class Test19 {	
	 public static void main(String[] args)
	    {
	    	Scanner sc=new Scanner(System.in);
	    	while(sc.hasNext())
	    	{
	    		long l=sc.nextLong();
	        	System.out.println(getResult(l));
	    	}
	    }
	    public static String getResult(long ulDataInput)
	    {
	    	String str="";
	    	int divisor=2;
	    	while(ulDataInput!=1)
	    	{
	    		while(ulDataInput%divisor==0)
	    		{
	    			ulDataInput=ulDataInput/divisor;
	    			str+=divisor+" ";
	    		}
	    		divisor++;
	    	}
	    	return str;
	    }
}
