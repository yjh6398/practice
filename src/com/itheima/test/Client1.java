package com.itheima.test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client1 {
	public static void main(String[] args)
	{
		Socket socket=null;
		InputStream is=null;
		OutputStream os=null;
		String serverIP="127.0.0.1";
		int port=20000;
		String[] data={"first_1","second+1","third_1"};
		byte[] b=new byte[1024];
		try {
			socket=new Socket(serverIP,port);
			is=socket.getInputStream();
			os=socket.getOutputStream();
			for(int i=0;i<data.length;i++)
			{
				//发送数据
				os.write(data[i].getBytes());
				//接收数据
				int n=is.read(b);
				//输出数据
				System.out.println(new String(b,0,n));
			}
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
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
}
