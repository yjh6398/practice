package com.itheima.test;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/*
 * 数据表记录包含表索引和数值，请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出
 */
public class Test14
{
	public static void main(String[] args)
	{
		TreeMap<Integer,Integer> map=new TreeMap<Integer,Integer>();
		Scanner sc=new Scanner(System.in);
		int n=Integer.parseInt(sc.nextLine());
		for(int i=0;i<n;i++)
		{
			String[] strArr=sc.nextLine().split(" ");
			addPare(map,strArr);
		}
		for(Integer key:map.keySet())
		{
			System.out.println(key+" "+map.get(key));
		}
	}
	public static void addPare(TreeMap<Integer,Integer> map,String[] strArr)
	{
		int key=Integer.parseInt(strArr[0]);
		int value=Integer.parseInt(strArr[1]);
		if(map.containsKey(key))
		{
			map.put(key, map.get(key)+value);
		}
		else
		{
			map.put(key, value);
		}
	}
}
