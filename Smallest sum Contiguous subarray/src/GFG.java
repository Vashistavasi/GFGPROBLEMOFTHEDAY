//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().smallestSumSubarray(arr, n)); 
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
	
    static int smallestSumSubarray(int a[], int size)
    {
        // your code here
    	int sum[]=new int [size];
    	sum[0]=a[0];
   
    int	min=a[0];
    	for(int i=1;i<size;i++) {
    		sum[i]=a[i]+sum[i-1];
    		min=Math.min(a[i],min);
    	}
    	int max[]=new int [size];
    	int maxi=Integer.MIN_VALUE;
    	maxi=Math.max(sum[0], maxi);
    	max[0]=maxi;
    	for(int i=1;i<size;i++) {
    		max[i]=Math.max(max[i-1], sum[i]);
    	}
    	int ans=Integer.MAX_VALUE;
    	for(int i=0;i<size;i++) {
    		int diff=sum[i]-max[i];
    		ans=Math.min(ans, diff);
    	}
    	if(ans==0)
    		return min;
    	else
    	return ans;
    	
    	
    	
    	
    	
    	
    }
}