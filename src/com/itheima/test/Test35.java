package com.itheima.test;
import java.util.Scanner;
/*
 * Levenshtein ���룬�ֳƱ༭���룬
 * ָ���������ַ���֮�䣬��һ��ת������һ����������ٱ༭����������
 * ��ɵı༭����������һ���ַ��滻����һ���ַ�������һ���ַ���ɾ��һ���ַ���
 * �༭������㷨�������ɶ����ѧ��Levenshtein����ģ����ֽ�Levenshtein Distance��
 */
public class Test35
{
   public static void main(String[] args)
   {
	  Scanner sc=new Scanner(System.in);
	  while(sc.hasNext())
	  {
		  String strA=sc.next();
		  String strB=sc.next();
		  int ic=1,dc=1,rc=1;
		  int cost=strEditCost(strA,strB,ic,dc,rc);
		  System.out.println(cost);
	  }
   }
   /* �ַ���֮��ľ��룬�༭���룬��strA�༭��strB�������С����
    * �༭������������һ���ַ���ɾ��һ���ַ����滻һ���ַ�
    * �ֱ��Ӧ�Ĵ�����ic��dc��rc��insert cost��delete cost��replace cost
    * strA[x-1]����strA�ĵ�x���ַ���ע���±��Ǵ�0��ʼ��,strA[y-1]����strA�ĵ�y���ַ�
    * ����һ�����۾���Ϊ(N+1)*(M+1)��M N ��ʾstrA strB�ĳ���
    * dp[x][y]��ʾstrA��ǰx���ַ����༭�� strB��ǰy���ַ������ѵĴ���
    * dp[x][y]�����漸��ֵ����Сֵ��
        * 1��dp[x][y] = dp[x-1][y] + dc
        * dp[x-1][y]��strA��ǰx-1���ַ��༭��strB��ǰy���ַ��Ĵ�����֪��
        * ��ô����strA��ǰx���ַ��༭��strB��ǰy���ַ��Ĵ���dp[x][y]����dp[x-1][y] + dc
        * �൱��strA��ǰx-1���ַ��༭��strB��ǰy���ַ������ڱ����strA��ǰx���ַ���������һ���ַ���Ҫ����ɾ������
        * 2��dp[x][y] = dp[x][y-1] + ic
        * dp[x][y-1]��strA��ǰx���ַ��༭��strB��ǰy-1���ַ��Ĵ�����֪��
        * ���ڱ�ΪstrB��ǰy���ַ�����Ӧ����strAǰx���������۵Ļ����ϲ���һ���ַ�
        * 3��dp[x][y] = dp[x-1][y-1]
        * dp[x-1][y-1]��strA��ǰx-1���ַ��༭��strB��ǰy-1���ַ��Ĵ�����֪��
        * strA�ĵ�x���ַ���strB�ĵ�y���ַ���ͬ��strA[x-1] == strB[y-1]��û���������
        * 4��dp[x][y] = dp[x-1][y-1] + rc
        * strA�ĵ�x���ַ���strB�ĵ�y���ַ�����ͬ��strA[x-1] ��= strB[y-1]��
        * ��strA��ǰx-1���ַ��༭��strB��ǰy-1���ַ��Ĵ�����֪������£�
        * ������strA��ǰx�ַ��༭��strB��ǰy���ַ��Ĵ�����Ҫ�����滻һ���ַ��Ĵ���
    * */
   public static int strEditCost(String strA,String strB,int ic,int dc,int rc)
   {
	   int m=strA.length();
	   int n=strB.length();
	   int[][] dp=new int[m+1][n+1];
	   for(int i=1;i<=n;i++)
	   {
		   dp[0][i]=i*ic;
	   }
	   for(int i=1;i<=m;i++)
	   {
		   dp[i][0]=i*dc;
	   }
	   for(int x=1;x<=m;x++)
	   {
		   for(int y=1;y<=n; y++)
		   {
			   int cost1=dp[x-1][y]+dc;
			   int cost2=dp[x][y-1]+ic;
			   int cost3=0;
			   if(strA.charAt(x-1)==strB.charAt(y-1))
				   cost3=dp[x-1][y-1];
			   else
				   cost3=dp[x-1][y-1]+rc;
			   dp[x][y]=Math.min(cost1, cost2);
			   dp[x][y]=Math.min(dp[x][y],cost3);
		   }
	   }
	   return dp[m][n];
   }
}
