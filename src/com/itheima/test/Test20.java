package com.itheima.test;

import java.util.Scanner;

public class Test20
{
    public static void main(String[] args)
    {
    	Scanner sc=new Scanner(System.in);
    	while(sc.hasNext())
    	{
    		String str=sc.nextLine();
    		if(isLength(str)&&isContains(str)&&isContainsSubstr(str))
    		{
    			System.out.println("OK");
    		}
    		else
    		{
    			System.out.println("NG");
    		}
    	}
    }
    public static boolean isLength(String str)
    {
    	if(str.length()>8)
    		return true;
    	else
    		return false;
    }
    public static boolean isContains(String str)
    {
    	int count=0;
    	char[] arr=new char[4];
    	for(int i=0;i<str.length();i++)
    	{
    		if(str.charAt(i)<='9'&&str.charAt(i)>='0')
    			arr[0]='1';
    		else if(str.charAt(i)<='z'&&str.charAt(i)>='a')
    			arr[1]='1';
    		else if(str.charAt(i)<='Z'&&str.charAt(i)>='A')
    			arr[2]='1';
    		else
    			arr[3]='1';
    	}
    	for(char obj:arr)
    	{
    		if(obj=='1')
    			count++;
    	}
    	if(count>=3)
    		return true;
    	else
    		return false;
    }
    public static boolean isContainsSubstr(String str)
    {
    	for(int i=0;i<str.length()-3;i++)
    	{
    		String str1=str.substring(i,i+3);
    		String str2=str.substring(i+3);
    		if(str2.contains(str1))
    			return false;
    	}
    	return true;
    }
}
