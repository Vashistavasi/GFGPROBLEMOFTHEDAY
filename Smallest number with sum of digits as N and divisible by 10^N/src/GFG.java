//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            String ans = ob.digitsNum(n);
            System.out.println(ans);           
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public String digitsNum(int N)
    {
        if(N==1)
        	return Integer.toString(N);
        String n=Integer.toString(N);
  
        StringBuffer power=new StringBuffer();
        power.append("1");
        
        for(int i=1;i<=N;i++)
        	power.append("0");
      
     
     
      {
    	  int num=Integer.parseInt(n);
    	  int div=num/9;
    	  int mod=num%9;
    	  
    	  StringBuilder sb=new StringBuilder();
    	  if(mod!=0)
    		  sb.append(mod);
    	  for(int i=0;i<div;i++)
    		  sb.append("9");
    	  sb.append(power.toString().substring(1, power.toString().length())) ;
    	  return new String (sb);
    	  
      }
    }
}