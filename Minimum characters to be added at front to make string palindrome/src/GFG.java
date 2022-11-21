//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    public static boolean isPalindrome(String a){
        for(int i=0;i<a.length()/2;i++){
            if(a.charAt(i)!=a.charAt(a.length()-i-1))
            return false;
        }
        return true;
    }
//    public static int minChar(String str) {
//       //Write your code here
//       str=str.toLowerCase();
//       int len=str.length();
//       while(!isPalindrome(str)) {
//    	   str=str.substring(0,str.length()-1);
//       }
//       return len-str.length();
//    
//    }
    public static int minChar(String str) {
    	//Write your code here
    	str=str.toLowerCase();
    	int len=str.length();
    	while(!isPalindrome(str)) {
    		int end=str.length()-2;
    		while(str.charAt(0)!=str.charAt(end))
    			end--;
    		str=str.substring(0,end+1);
    	}
    	return len-str.length();
}
 
}
//{ Driver Code Starts.

class GFG {
	public static void main(String[] args) throws IOException
	{
	    var sc = new FastReader();
	    int test = sc.nextInt();
	    while(test-->0){
    		String s = sc.nextString();
    		System.out.println(Solution.minChar(s));
	    }
	}
    
    public static class FastReader
	{
		BufferedReader br;
		StringTokenizer st;

		public FastReader()
		{
			br = new BufferedReader(new InputStreamReader(System.in));
			st = new StringTokenizer("");
		}

		private void read() throws IOException
		{
			st = new StringTokenizer(br.readLine());
		}

		public String nextString() throws IOException
		{
			while(!st.hasMoreTokens())
				read();
			return st.nextToken();
		}

		public int nextInt() throws IOException
		{
			return Integer.parseInt(nextString());
		}

		public long nextLong() throws IOException
		{
			return Long.parseLong(nextString());
		}
	}
}
// } Driver Code Ends