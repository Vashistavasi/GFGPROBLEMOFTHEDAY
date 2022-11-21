//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.fillingBucket(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    static java.math.BigInteger fact[];
    static int dp[];
    static int mod=100000000;
    static java.math.BigInteger m=new java.math.BigInteger(Integer.toString(mod));
    static int fillingBucket(int N) {
    	
    	dp=new int[N+1];
    	dp[0]=dp[1]=1;
    	find(N);
    	return dp[N];
        // code here
     //fact=new java.math.BigInteger[N+1];
     

//   int ans=0;
//   factorial();
//   for(int i=0;i<=N/2;i++){
//	   int one=N-2*i;
//       ans+=fact[N-i].divide((fact[one].multiply(fact[i]))).mod(m).intValue();
//       ans%=mod;
//   }
//   System.out.println(find(N));
//   return ans;
        
    }
    public static void factorial(){
        
        fact[0]=fact[1]=java.math.BigInteger.ONE;
        for(int i=1;i<fact.length;i++)
        fact[i]=(fact[i-1].multiply(new java.math.BigInteger(Integer.toString(i))));
    }
    public static int find(int n) {
    	if(n==1)
    		return 1;
    	else if(n<0)
    		return 0;
    	else if(n==0)
    		return 1;
    	else if(dp[n]!=0)
    		return dp[n];
    	else  {
    		dp[n]=find(n-1)+find(n-2);
    		return dp[n]%mod;
    	}
    }
    
    
};