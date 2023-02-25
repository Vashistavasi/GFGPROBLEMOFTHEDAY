//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            String T = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.checkCompressed(S,T));
        }
    }
}
// } Driver Code Ends


//User function Template for Java


//User function Template for Java

class Solution {
    static int checkCompressed(String S, String T) {
        // code here
    	int len=T.length();
    	int org=S.length();
    	int cur=0;
    	for(int i=0;i<len;i++) {
    		if(isChar(T.charAt(i))) {
    		    if(cur>org)
    		    return 0;
    			if(S.charAt(cur)!=T.charAt(i)) {
    				return 0;
    			}
    			else {
    				cur++;
    			}
    		}
    		else {
    			String sb="";
    			while(i<len && !isChar(T.charAt(i))){
    				sb+=T.charAt(i);
    				i++;
    			}
    			i--;
    			int next=Integer.parseInt(sb);
    			cur+=next;
    		}
    	}
    	if(cur==org)
    	return 1;
    	else return 0;
    }
   static boolean isChar(char a) {
    	if(a-'0'<0 || a-'0'>9)
    		return true;
    	else
    		return false;
    }
}