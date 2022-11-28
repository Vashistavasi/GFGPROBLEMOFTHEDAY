//{ Driver Code Starts
//Initial Template for Java

//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GFG
{
    public static void main(String args[])throws IOException
    {
        
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String input_line[] = read.readLine().trim().split("\\s+");
            long  N = Long.parseLong(input_line[0]);
            Solution ob = new Solution();
            System.out.println(ob.count(N));
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
	 public static java.math.BigInteger factorial(long n){
	        java.math.BigInteger fact=java.math.BigInteger.ONE;
	        for(Long i=2l;i<=n;i++){
	            fact=fact.multiply(new java.math.BigInteger(i.toString()));
	        }
	        return fact;
	    }
	 long setBitCount(long n) {
		 long temp=n;
		 long ans=0;
		 while(temp>0) {
			 long rsb=temp&-temp;
			 temp-=rsb;
			 ans++;
		 }
		 return ans;
	 }
	 long ncr(long n,long r) {
		 if(n<r)
			 return 0;
		 long res=1l;
		 for(int i=0;i<r;i++) {
			 res*=(n-i);
			 res/=(i+1);
		 }
		 return res;
	 }
	 long solve(long setbits,long n,long i) {
		 if(i==0)
			 return 0;
		 long ans=0;
		 long mask=1l<<i;
		 long res0=0,res1=0;
		 if((n&mask)==0) {
			 res0=solve(setbits,n,i-1);
		 }
		 else {
			 res1=solve(setbits-1,n,i-1);
			 res0=ncr(i,setbits);
		 }
		 ans=res1+res0;
		 return ans;
		 
	 }
    long count(long n)
    {
        // Code Here
    	long setbits=setBitCount(n);
    	long ans=solve(setbits,n,63);
    	return ans;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}