package com.itheima.test;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
public class Test15
{
    public static void main(String[] args)
    {
    	Scanner sc=new Scanner(System.in);
    	int n=sc.nextInt();
    	int m=0;
    	String str=String.valueOf(n);
    	System.out.println(str);
    	char[] arr=str.toCharArray();
    	Set<Character> s=new LinkedHashSet<Character>();
    	for(int i=arr.length-1;i>=0;i--)
    	{
    		s.add(arr[i]);
    	}
    	for(Character obj:s)
    	{
    		System.out.print(obj);
    	}
    }
}
