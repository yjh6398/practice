package com.itheima.test;

import java.util.Map;
import java.util.Scanner;
import java.util.SortedMap;
import java.util.TreeMap;

/*
 * ���ݱ��¼��������������ֵ����Ա�������ͬ�ļ�¼���кϲ���������ͬ��������ֵ����������㣬�������keyֵ����������
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
