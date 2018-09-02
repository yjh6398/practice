package com.itheima.test;


import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

public class Test1 {
	public static void main(String[] args) throws IOException
	{
		Process p=Runtime.getRuntime().exec("java ReadStandard");
		PrintStream ps=new PrintStream(p.getOutputStream());
		ps.print("dsfhd");
		ps.println(new Test1());
		
	}
 }
