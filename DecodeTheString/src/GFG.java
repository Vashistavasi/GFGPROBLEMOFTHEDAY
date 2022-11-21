//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            
            Solution ob = new Solution();
            out.println(ob.decodedString(s));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static String decodedString(String s){
        // code here
    	ArrayDeque<String> result=new ArrayDeque<>();
    	ArrayDeque<Integer> freq = new ArrayDeque<Integer>();
        String res="";
        int idx=0;
        while(idx<s.length()) {
        	if(Character.isDigit(s.charAt(idx))){
        		int count=0;
        		while((Character.isDigit(s.charAt(idx)))) {
        			count=10*count+(s.charAt(idx)-'0');
        			idx++;
        		}
        		freq.push(count);
        	}
        	else if(s.charAt(idx)=='[') {
        		result.push(res);
        		res="";
        		idx++;
        	}
        	else if(s.charAt(idx)==']') {
        		StringBuffer sb=new StringBuffer(result.pop());
        		int count=freq.pop();
        		for(int i=0;i<count;i++)
        			sb.append(res);
        	
        	res=new String(sb);
        	idx++;
        }
        else {
        	res+=s.charAt(idx);
        	idx++;
        }
    }
        return res;
}
}