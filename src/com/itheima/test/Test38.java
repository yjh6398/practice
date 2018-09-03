package com.itheima.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
public class Test38
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		List<S> list=new ArrayList<S>();
		while(sc.hasNext())
		{
			int num=sc.nextInt();
			int option=sc.nextInt();
			for(int i=0;i<num;i++)
			{
				String name=sc.next();
				int score=sc.nextInt();
				list.add(new S(name,score));
			}
			if(option==0)
			{
				Collections.sort(list, new Comparator<S>()
				{
					public int compare(S o1,S o2)
					{
						return o2.score-o1.score;
					}
				});
			}
			if(option==1)
			{
				Collections.sort(list, new Comparator<S>()
				{
					public int compare(S o1,S o2)
					{
						return o1.score-o2.score;
					}
				});
			}
			for(S obj:list)
			{
				System.out.println(obj.name+" "+obj.score);
			}
		}
	}
}
class S
{
	String name;
	int score;
	public S(String name,int score)
	{
		this.name=name;
		this.score=score;
	}
}