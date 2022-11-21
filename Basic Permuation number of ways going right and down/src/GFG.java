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
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int m = Integer.parseInt(input[0]); 
            int n = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.numberOfPaths(m,n));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    public static java.math.BigInteger factorial(int n){
        java.math.BigInteger fact=java.math.BigInteger.ONE;
        for(Integer i=2;i<=n;i++){
            fact=fact.multiply(new java.math.BigInteger(i.toString()));
        }
        return fact;
    }
    long numberOfPaths(int m, int n)
    {
        // code here
        java.math.BigInteger numerator=factorial(m+n-2);
        java.math.BigInteger denominator1=factorial(m-1);
        java.math.BigInteger denominator2=factorial(n-1);
        numerator=numerator.divide(denominator1);
        numerator=numerator.divide(denominator2);
        numerator=numerator.mod(new java.math.BigInteger("1000000007"));
        return numerator.longValue();
    }
}