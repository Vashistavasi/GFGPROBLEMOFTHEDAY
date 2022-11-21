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
            int N = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            int ans = ob.NthTerm(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public static boolean prime[];
    public void sieve(int n){
    	
       
        
   

		for (int p = 2; p * p <= n; p++) {

			if (prime[p] == false) {
		
				for (int i = p * p; i <= n; i += p)
					prime[i] = true;
			}
    }
    }
    public int NthTerm(int N)
    {
        // code here
    	 prime=new boolean[2*N];
    	 prime[1]=true;
        sieve(2*N-100);
          if(!prime[N])
          return 0;
        int back=N-1;
        while(prime[back])
        back--;
        int forward=N+1;
        while(prime[forward])
        forward++;
        System.out.println(forward+" "+ back);
        int ans=(forward-N)>(N-back)?N-back:forward-N;
        return ans;
    }
}