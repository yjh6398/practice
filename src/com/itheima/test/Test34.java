package com.itheima.test;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
/*
 * 给出一个名字，该名字有26个字符串组成，定义这个字符串的“漂亮度”是其所有字母“漂亮度”的总和。 
 * 每个字母都有一个“漂亮度”，范围在1到26之间。没有任何两个字母拥有相同的“漂亮度”。字母忽略大小写。 
 * 给出多个名字，计算每个名字最大可能的“漂亮度
 */
public class Test34
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		String[] str=new String[n];
		for(int i=0;i<n;i++)
		{
			str[i]=sc.next();
		}
		for(int i=0;i<n;i++)
		{
			System.out.println(getMax(str[i]));
		}
	}
    public static int getMax(String str)
    {
    	int index=0;
    	int num=26;
    	int max=0;
    	char[] arr=str.toCharArray();
    	Map<Character,Integer> map=new HashMap<Character,Integer>();
    	for(char obj:arr)
    	{
    		map.put(obj, !map.containsKey(obj)?1:map.get(obj)+1);
    	}
    	int[] intArr=new int[map.size()];
    	for(Character key:map.keySet())
    	{
    		intArr[index]=map.get(key);
    		index++;
    	}
    	intArr=order(intArr);
    	for(int i=0;i<intArr.length;i++)
    	{
    		max+=num*intArr[i];
    		num--;
    	}
    	return max;
    }
    public static int[] order(int[] arr)
    {
    	int temp;
    	for(int i=0;i<arr.length;i++)
    	{
    		for(int j=0;j<arr.length;j++)
    		{
    			if(arr[i]>arr[j])
    			{
    				temp=arr[i];
    				arr[i]=arr[j];
    				arr[j]=temp;
    			}
    		}
    	}
    	return arr;
    }
}
