//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java

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
            String input_line[] = read.readLine().trim().split("\\s+");
            int  N = Integer.parseInt(input_line[0]);
            int  M = Integer.parseInt(input_line[1]);
            
            Solution ob = new Solution();
            int ans = ob.steppingNumbers(N, M);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    static int count;
   static HashSet<Integer> hs;
    int steppingNumbers(int n, int m){
        // code here
        count=0;
        hs=new HashSet<Integer> ();
        for(int i=0;i<10;i++)
        dfs(n,m,i);
        return hs.size();
    }
    public static void dfs(int n,int m,int num){
    	if(num>m || num==0)return ;
        if(num>=n && num<=m) {
        	if(!hs.contains(num))
        	System.out.print(num);
        	System.out.println();
           hs.add(num);
        	count++;
        }
        
        int x=num%10;
        int y=num*10+(x-1);
        int z=num*10+(x+1);
        if(x==0)
        dfs(n,m,z);
        else if(x==9)
        dfs(n,m,y);
        else{
            dfs(n,m,y);
            dfs(n,m,z);
        }
    }
}


