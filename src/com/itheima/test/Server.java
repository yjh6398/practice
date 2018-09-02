package com.itheima.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.*;
import java.nio.Buffer;

public class Server
{
   public static void main(String[] args)
   {
	   Socket socket=null;
	   ServerSocket serverSocket=null;
	   int port=50000;
	   try
	   {
		   serverSocket=new ServerSocket(port);
		   while(true)
		   {
			   socket=serverSocket.accept();
			   new LogicThread(socket);
		   }
	   }
	   catch(Exception e)
	   {
		  e.printStackTrace(); 
	   }
	   finally
	   {
		   try
		   {
			   serverSocket.close();
		   }
		   catch(Exception e)
		   {
			   e.printStackTrace();
		   }
	   }
   }
}
class LogicThread extends Thread
{
	byte[] b=new byte[1024];
	InputStream is=null;
	OutputStream os=null;
	Socket socket=null;
	public LogicThread(Socket socket)
	{
		this.socket=socket;
		this.start();
	}
	public void run()
	{
		try
		{
		   is=socket.getInputStream();
		   os=socket.getOutputStream();
		   for(int i=0;i<3;i++)
		   {
			   //接收数据
			   int n=is.read(b);
			   //控制台打印数据
			   System.out.println(new String(b,0,n));
			   //发送数据
			   os.write(b, 0, n);
		   }
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			close();
		}
	}
	public void close()
	{
		try
		{
			is.close();
			os.close();
			socket.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
