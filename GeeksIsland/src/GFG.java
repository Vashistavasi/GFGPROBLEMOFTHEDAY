//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class GFG{
	public static void main(String [] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int test = Integer.parseInt(br.readLine());
		while(test-- > 0) {
			String [] str = br.readLine().trim().split(" ");
			int N = Integer.parseInt(str[0]);
			int M = Integer.parseInt(str[1]);
			int [][] mat = new int[N][M];
			for(int i = 0; i < N; i++) {
				str = br.readLine().trim().split(" ");
				for(int j = 0; j < M; j++) {
					mat[i][j] = Integer.parseInt(str[j]);
				}
			}
			Solution obj = new Solution();
			out.println(obj.water_flow(mat, N, M));
		}
		out.close();
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution{
	int water_flow(int [][] mat, int N, int M) {
		//Write your code here
		int count=0;
		boolean [][]indianOcean=new boolean[N][M];
		boolean [][]arabianSea=new boolean[N][M];
		for(int i=0;i<N;i++) {
			dfs(mat,indianOcean,i,0);
			dfs(mat,arabianSea,i,M-1);
		}
		for(int i=0;i<M;i++) {
			dfs(mat,indianOcean,0,i);
			dfs(mat,arabianSea,N-1,i);
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(indianOcean[i][j]&&arabianSea[i][j])
					count++;
			}
		}
		return count;
	}

	private void dfs(int[][] mat, boolean[][] visited, int i, int j) {
		// TODO Auto-generated method stub
		visited[i][j]=true;
		int dirs[][]= {{0,1},{1,0},{-1,0},{0,-1}};
		int row=mat.length;
		int col=mat[0].length;
		for(int[] dir : dirs) {
			int x=i+dir[0]; int y=j+dir[1];
			if(x>=0 && x<row && y>=0 && y<col && !visited[x][y] && mat[i][j]<=mat[x][y]) {
				dfs(mat,visited,x,y);
			}
		}
	}
}