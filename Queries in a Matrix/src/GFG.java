//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int q = Integer.parseInt(s[1]);
            int[][] Queries = new int[q][4];
            for (int i = 0; i < q; i++) {
                String[] s1 = br.readLine().trim().split(" ");
                for (int j = 0; j < 4; j++)
                    Queries[i][j] = Integer.parseInt(s1[j]);
            }
            Solution obj = new Solution();
            int[][] ans = obj.solveQueries(n, Queries);
            for (int i = 0; i < ans.length; i++) {
                for (int j = 0; j < ans[i].length; j++) {
                    out.print(ans[i][j] + " ");
                }
                out.println();
            }
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int[][] solveQueries(int n, int[][] Queries) {
        // Code here
    	int slope[][]=new int[n][n];
    	int len=Queries.length;
    	for(int i=0;i<len;i++) {
    		int[] curr=Queries[i];
    		int startx=curr[0];
    		int starty=curr[1];
    		int endx=curr[2];
    		int endy=curr[3];
    		int count=endx-startx+1;
    		int temp=startx;
    		while(count-->0) {
    			slope[temp][starty]+=1;
    			temp++;
    		}
    		if(endy+1<n) {
    			count=endx-startx+1;
    			temp=startx;
    			while(count-->0) {
    				slope[temp][endy+1]+=-1;
    				temp++;
    			}
    		}
    	}
    	
    	for(int i=0;i<n;i++) {
    		for(int j=1;j<n;j++) {
    			slope[i][j]+=slope[i][j-1];
    		}
    	}
    	return slope;
	
    }
}