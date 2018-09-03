package com.itheima.test;
import java.util.Scanner;
public class Test37
{
   public static void main(String[] args)
   {
	  Scanner sc=new Scanner(System.in);
	  while(sc.hasNext())
	  {
		  String str=sc.next();
		  System.out.println(getRealCode(str));
	  }
   }
   public static String getRealCode(String str)
   {
	   StringBuilder sb=new StringBuilder();
	   for(int i=0;i<str.length();i++)
	   {
		   if(str.charAt(i)>='A'&&str.charAt(i)<='Z')
		   {
			   if(str.charAt(i)=='Z')
			   {
				   sb.append('a');
			   }
			   else
			   {
				   //Ð¡Ð´±ä´óÐ´
				   sb.append((char)(str.charAt(i)+32+1));
			   }
		   }
		   else if(str.charAt(i)>='0'&&str.charAt(i)<='9')
		   {
			   sb.append(str.charAt(i));
		   }
		   else
		   {
			   switch(str.charAt(i))
			   {
			      case 'a':
			      case 'b':
			      case 'c':
			    	  sb.append(2);
			    	  break;
			      case 'd':
			      case 'e':
			      case 'f':
			    	  sb.append(3);
			    	  break;
			      case 'g':
			      case 'h':
			      case 'i':
			    	  sb.append(4);
			    	  break;
			      case 'j':
			      case 'k':
			      case 'l':
			    	  sb.append(5);
			    	  break;
			      case 'm':
			      case 'n':
			      case 'o':
			    	  sb.append(6);
			    	  break;
			      case 'p':
			      case 'q':
			      case 'r':
			      case 's':
			    	  sb.append(7);
			    	  break;
			      case 't':
			      case 'u':
			      case 'v':
			    	  sb.append(8);
			    	  break; 
			      case 'w':
			      case 'x':
			      case 'y':
			      case 'z':
			    	  sb.append(9);
			    	  break; 
			   }
		   }
	   }
	   return sb.toString();
   }
}
