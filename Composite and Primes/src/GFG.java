//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().split(" ");
            int L = Integer.parseInt(S[0]);
            int R = Integer.parseInt(S[1]);
            Solution ob = new Solution();
            int ans = ob.Count(L, R);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
	   boolean[] sieveOfEratosthenes(int n)
	    {
	      
	        boolean prime[] = new boolean[n + 1];
	        for (int i = 0; i <= n; i++)
	            prime[i] = true;
	 
	        for (int p = 2; p * p <= n; p++) {
	         
	            if (prime[p] == true) {
	             
	                for (int i = p * p; i <= n; i += p)
	                    prime[i] = false;
	            }
	        }
	        prime[1]=false;
	        return prime;
	    }
	 
    public int Count(int L, int R)
    {
        // code here
    	int primes=0;
    	boolean p[]=sieveOfEratosthenes(R);
    	for(int i=L;i<=R;i++) {
    		if(p[i])
    			primes++;
    	}
    	int composites=R-L+1-primes;
    	System.out.println(composites+" "+primes);
    	return composites-primes;
    	
    }
}