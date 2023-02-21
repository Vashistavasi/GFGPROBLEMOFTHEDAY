//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java

class Solution
{
	static int count;
	public static int minIteration(int N, int M, int x, int y){
		//code here
		count=0;
		bfs(N,M,x-1,y-1);
		return count;
	}
	private static void bfs(int n, int m, int x, int y) {
		// TODO Auto-generated method stub
		int dirs[][]= {{-1,0},{0,1},{1,0},{0,-1}};
		ArrayDeque<Pair> ad=new ArrayDeque<Pair>();
		boolean visited[][]=new boolean[n][m];
		ad.add(new Pair(x,y));
		visited[x][y]=true;
		while(ad.size()>0) {
		    int size=ad.size();
		    for(int i=0;i<size;i++){
			Pair p=ad.poll();
			int curx=p.x,cury=p.y; 
			for(int [] dir:dirs) {
				int adjx=curx+dir[0],adjy=cury+dir[1];
				if(adjx>-1 && adjy>-1 && adjx<n && adjy<m) {
					if(!visited[adjx][adjy]) {
						ad.add(new Pair(adjx,adjy));
						visited[adjx][adjy]=true;
					}
				}
			}
		    }
			
			if(ad.size()>0)
				count++;
		}
	}
	
}
class Pair{
	int x,y;

	public Pair(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "Pair [x=" + x + ", y=" + y + "]";
	}
	
}

//{ Driver Code Starts.

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
        	String input[]=read.readLine().trim().split(" ");
            int N = Integer.parseInt(input[0]);
            int M=Integer.parseInt(input[1]);
           	input=read.readLine().trim().split(" ");
            int x = Integer.parseInt(input[0]);
            int y = Integer.parseInt(input[1]);
            Solution ob = new Solution();
            System.out.println(ob.minIteration(N, M, x, y));
        }
        
    }
}
// } Driver Code Ends