package com.itheima.test;
import java.util.Scanner;
public class Test33
{
    public static void main(String[] args)
    {
	    Scanner sc=new Scanner(System.in);
	    int length = sc.nextInt();
	    int A = sc.nextInt();
	    int X = sc.nextInt();
	    int B = sc.nextInt();
	    int Y = sc.nextInt();
	    System.out.println(list(length, A, X, B, Y));
	}
	public static long list(int length, int A, int X, int B, int Y)
	{
	    long mod = 1000000007;
	    // ¹¹½¨Ñî»ÔÈý½Ç
	    int max = 101;
	    long[][] tri = new long[max][max];
	    tri[0][0] = 1;
	    for (int i = 1; i < max; i++)
	    {
	         tri[i][0] = 1;
	         for (int j = 1; j < max; j++)
	         {
	             tri[i][j] = (tri[i - 1][j - 1] + tri[i - 1][j]) % mod;
	         }
	    }
	        long sum = 0;
	        for(int value = 0; value <= length; value++)
	        {
	            if(value % A == 0 && (length - value) % B == 0 && value/A <= 100 && (length - value) / B <= 100)
	            {
	                sum += tri[X][value / A] * tri[Y][(length - value) / B] % mod;
	            }
	        }
	        return sum % mod;
	    }
	}

