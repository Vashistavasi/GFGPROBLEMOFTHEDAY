//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;


// } Driver Code Ends
//User function Template for Java

class Solution {
    static boolean visited[][];
    static int count;
    public List<Integer> numOfIslands(int rows, int cols, int[][] operators) {
        //Your code here
    	
        	int arr[][]=new int [rows][cols];
    	
       List <Integer> ans=new ArrayList<>();
       int count=0;
    	int len=operators.length;
    	for(int i=0;i<len;i++) {
    		int x=operators[i][0];
    		int y=operators[i][1];
    		arr[x][y]=1;
    	  count=0;
    	  visited=new boolean[rows][cols];
    		for(int idx=0;idx<rows;idx++) {
    			for(int jdx=0;jdx<cols;jdx++) {
    				if(!visited[idx][jdx] && arr[idx][jdx]==1) {
    					dfs(idx,jdx,arr);
    					count++;
    				}
    				
    				
    			}
    		}
    		
    		
    		ans.add(count);
    	
    }
    	return ans;
}
    public static void dfs(int x,int y,int arr[][]) {
    	int rows=arr.length;
    	int cols=arr[0].length;
    	int dirx[]= {0,0,-1,1};
    	int diry[]= {-1,1,0,0};
    	if(visited[x][y] )
    		return;
    	else {
    		visited[x][y]=true;
    		for(int j=0;j<4;j++) {
    			{
    				int xidx=x+dirx[j];
    				int yidx=y+diry[j];
    		if(xidx>-1 && yidx>-1 && xidx<rows && yidx < cols && arr[xidx][yidx]==1) {
    					dfs(xidx,yidx,arr);
    				}
    			}
    		}
    	}
    	
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int  k= sc.nextInt();
            int[][] a = new int[k][2];
            for(int i=0;i<k;i++){
            
                a[i][0] = sc.nextInt();
                a[i][1] = sc.nextInt();
            }
            
            Solution obj = new Solution();
            List<Integer> ans = obj.numOfIslands(n,m,a);
           
            for(int i:ans){
                System.out.print(i+" ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends