//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            String W = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.numberOfSubsequences(S,W));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int numberOfSubsequences(String S, String W){
        // code here
    	int idx=0;
    	int count=0;
    	int curr=0;
    	while(idx<S.length()) {
    		for(int i=0;i<W.length();i++) {
    			curr=S.indexOf(W.charAt(i), idx);
    			if(curr==-1)
    				return count;
    			idx=curr;
    		}
    		count++;
    	}
    	return count;
    }
}