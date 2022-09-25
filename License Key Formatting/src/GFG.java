//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.ReFormatString(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static String ReFormatString(String S, int K){
        // code here
    	S=S.toUpperCase();
    	StringTokenizer st=new StringTokenizer(S,"-");
    	StringBuffer sb=new StringBuffer();
    	StringBuffer res=new StringBuffer();
    	while(st.hasMoreTokens()) {
    		sb.append(st.nextToken());
    	}
    	int mod=(sb.length())%K;
    	if(sb.length()==0)
    	return new String();
    	if(mod==0) {
    		for(int i=0;i<sb.length();i+=K ) {
    			res.append(sb.substring(i, i+K));
    			res.append("-");
    		}
    	}
    	else {
    		res.append(sb.substring(0,mod));
    		res.append("-");
    		for(int i=mod;i<sb.length();i+=K ) {
    			res.append(sb.substring(i, i+K));
    			res.append("-");
    		}
    	}
    	return new String(res.substring(0,res.length()-1));
    }
}