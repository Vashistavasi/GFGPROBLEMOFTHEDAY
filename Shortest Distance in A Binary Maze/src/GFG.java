//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < m; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            int[] source = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                source[i] = x;
            }
            int[] dest = new int[2];
            for (int i = 0; i < 2; i++) {
                int x = sc.nextInt();
                dest[i] = x;
            }
            Solution ob = new Solution();
            int ans = ob.shortestPath(grid, source, dest);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Node{
	int x,y;
    int dis=0;
	public Node(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Node(int x, int y,int dis) {
		super();
		this.x = x;
		this.y = y;
		this.dis=dis;
	}
	
}

class Solution {
    static int count;
 	static int dirx[]= {0,0,-1,1};
	static int diry[]= {-1,1,0,0};
	static boolean flag=false;
    int shortestPath(int[][] grid, int[] source, int[] destination) {

        // Your code here
    	count=0;
    	flag=false;
    	if(source[0]==destination[0] && source[1]==destination[1])
    		return 0;
    	
    	//bfs(grid, source[0], source[1], destination);
    	int ans=djk(grid, source, destination);
    	if(ans==Integer.MAX_VALUE)
    		return -1;
    	else
    		return ans;
    }
    public static boolean check(int grid[][],int x,int y) {
    	if(x>-1 && x<grid.length && y>-1 && y<grid[0].length && grid[x][y]==1)
    		return true;
    	else
    		return false;
    }
    /**
     * @param grid
     * @param source
     * @param dest
     * @return
     */
    public static int djk(int[][]grid,int [] source, int[]dest) {
    	int n=grid.length;
    	int m=grid[0].length;
    	int dist[][]=new int[n][m];
    	for(int [] i: dist)
    		Arrays.fill(i, Integer.MAX_VALUE);
    	dist[source[0]][source[1]]=0;
    	boolean visited[][]=new boolean[n][m];
    	visited[source[0]][source[1]]=true;
    	PriorityQueue<Node> pq=new PriorityQueue<>((p1,p2)->p1.dis-p2.dis);
    	Node start=new Node(source[0],source[1],0);
    	pq.add(start);
    	while(!pq.isEmpty()) {
    		Node curr=pq.poll();
    		int d=curr.dis;
    		int x=curr.x;
    		int y=curr.y;
    		visited[x][y]=true;
    		for(int i=0;i<4;i++) {
    			int adjx=x+dirx[i];
    			int adjy=y+diry[i];
    			if(check(grid,adjx,adjy) &&!visited[adjx][adjy]&& 1+d<dist[adjx][adjy] ) {
    				dist[adjx][adjy]=1+d;
    				pq.add(new Node(adjx,adjy,1+d));
    			}
    			
    		}
    	}
    	return dist[dest[0]][dest[1]];
    }
    public static void bfs(int [][]grid,int x,int y,int []destination) {
 
    	boolean visited[][]=new boolean[grid.length] [grid[0].length];
    	ArrayDeque<Node> st=new ArrayDeque<Node>();
    	st.push(new Node(x,y));
    	visited[x][y]=true;
    	while(!st.isEmpty()) {
    		Node curr=st.pop();
    		
    		count++;
    		boolean flag2=false;
    		for(int i=0;i<4;i++) {
    		  int adjx=curr.x+dirx[i];
    		  int adjy=curr.y+diry[i];
    		  if(check(grid,adjx,adjy)  && !visited[adjx][adjy]) {
    			  visited[adjx][adjy]=true;
    			  if(destination[0]==adjx && destination[1]==adjy) {
    				  flag=true;
    				  return;
    			  }
    			  else {
       			  st.push(new Node(adjx,adjy));
       			  flag2=true;
    			  }
    		  }
    		}
    		if(!flag2)
        		count--;  
    	}
    	
    }
}
