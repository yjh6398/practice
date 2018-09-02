package com.itheima.test;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
	public static void main(String[] args)
	{
		String serverIP="127.0.0.1";
		int port=50000;
		Socket socket=null;
		InputStream is=null;
		OutputStream os=null;
		String[] data=new String[]{"Hello","����","how are you"};
		byte[] b =new byte[1024];
		try
		{
		    socket=new Socket(serverIP,port);
		    is=socket.getInputStream();
		    os=socket.getOutputStream();
		    for(int i=0;i<data.length;i++)
		    {
		    	//��������
		    	os.write(data[i].getBytes());
		    	//��������
		    	int n=is.read(b);
		    	//�����̨��ӡ����
		    	System.out.println(new String(b,0,n));
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
				os.close();
				is.close();
				socket.close();
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
	}
}
