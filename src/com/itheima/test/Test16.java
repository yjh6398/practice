package com.itheima.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test16
{
    public static void main(String[] args)
    {
    	Map<Character,Integer> map=new HashMap<Character,Integer>();
    	Scanner sc=new Scanner(System.in);
    	char[] arr=sc.nextLine().toCharArray();
    	getCount(arr,map);
    	System.out.println(map.keySet().size());
    }
    public static void getCount(char[] arr,Map<Character,Integer> map)
    {
    	for(Character obj:arr)
    	{
    		map.put(obj, !map.containsKey(obj)?1:map.get(obj)+1);
    	}
    }
}
