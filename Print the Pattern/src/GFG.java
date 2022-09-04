//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            List<String> ans = ob.pattern(n);
            for(int i = 0;i < n;i++)
                System.out.println(ans.get(i));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static List<String> pattern(int n){
    	
    	int k=2*n;
    	int ele=k;
    	List<String> al=new ArrayList<String>();
    	int forward=1;
    	int backward=n*(n+1);
    	while(k>=2) {
    		int count=k/2;
    		StringBuffer sb=new StringBuffer();
    		int dash=ele-k;
    		while(dash-->0)
    			sb.append("-");
    		while(count-->0) {
    			sb.append(forward++);
    			sb.append("*");
    		}
    		count=k/2;
    		int backForward=backward-count+1;
    		
    		backward=backForward-1;
    		while(count-->0) {
    			sb.append(backForward++);
    			sb.append("*");
    		}
    		sb.deleteCharAt(sb.length()-1);
    		al.add(new String(sb));
    		k=k-2;
    	}
    	return al;

    }
}