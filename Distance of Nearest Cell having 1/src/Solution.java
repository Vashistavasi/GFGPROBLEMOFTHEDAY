//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int m = Integer.parseInt(s[1]);
            int[][] grid = new int[n][m];
            for(int i = 0; i < n; i++){
                String[] S = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    grid[i][j] = Integer.parseInt(S[j]);
                }
            }
            Solution obj = new Solution();
            int[][] ans = obj.nearest(grid);
            for(int i = 0; i < ans.length; i++){
                for(int j = 0; j < ans[i].length; j++){
                    System.out.print(ans[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


class Node {
	int x, y,d;

	public Node(int x, int y,int d) {
		super();
		this.x = x;
		this.y = y;
		this.d=d;
	}

	public int diff(Node a) {
		return Math.abs(this.x - a.x) + Math.abs(this.y - a.y);
	}

}

class Solution {
	// Function to find distance of nearest 1 in the grid for each cell.
	public int[][] nearest(int[][] grid) {
		// Code here
      int row=grid.length;
      int col=grid[0].length;
      int dis[][]=new int[row][col];
      for(int i=0;i<row;i++){
          Arrays.fill(dis[i],Integer.MAX_VALUE);
      }
      Queue<Node> que=new LinkedList<Node>();
      for(int i=0;i<row;i++){
          for(int j=0;j<col;j++){
              if(grid[i][j]==1){
                  que.add(new Node(i,j,0));
                  dis[i][j]=0;
              }
          }
      }
      BFS(que,dis,row,col);
      return dis;
	}
	private void BFS(Queue<Node> que,int [][] dis,int row,int col){
	    int dirx[]={1,-1,0,0},diry[]={0,0,-1,1};
	    while(!que.isEmpty()){
	        Node node=que.poll();
	        int x=node.x,y=node.y,d=node.d;
	        for(int i=0;i<4;i++){
	            int curx=x+dirx[i],cury=y+diry[i];
	            if(check(curx,cury,row,col) && dis[curx][cury]>d+1){
	                dis[curx][cury]=d+1;
	                que.add(new Node(curx,cury,dis[curx][cury]));
	            }
	        }
	        
	    }
	}
	public boolean check(int x,int y, int row, int col){
	    return (x<row && y<col && x>-1 && y>-1);
	}
}




//
////{ Driver Code Starts
//import java.util.*;
//import java.lang.*;
//import java.io.*;
//
//class GFG {
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int T = Integer.parseInt(br.readLine().trim());
//		while (T-- > 0) {
//			String[] s = br.readLine().trim().split(" ");
//			int n = Integer.parseInt(s[0]);
//			int m = Integer.parseInt(s[1]);
//			int[][] grid = new int[n][m];
//			for (int i = 0; i < n; i++) {
//				String[] S = br.readLine().trim().split(" ");
//				for (int j = 0; j < m; j++) {
//					grid[i][j] = Integer.parseInt(S[j]);
//				}
//			}
//			Solution obj = new Solution();
//			int[][] ans = obj.nearest(grid);
//			for (int i = 0; i < ans.length; i++) {
//				for (int j = 0; j < ans[i].length; j++) {
//					System.out.print(ans[i][j] + " ");
//				}
//				System.out.println();
//			}
//		}
//	}
//}
//
//// } Driver Code Ends
//class Node {
//	int x, y;
//
//	public Node(int x, int y) {
//		super();
//		this.x = x;
//		this.y = y;
//	}
//
//	public int diff(Node a) {
//		return Math.abs(this.x - a.x) + Math.abs(this.y - a.y);
//	}
//
//}
//
//class Solution {
//	// Function to find distance of nearest 1 in the grid for each cell.
//	public int[][] nearest(int[][] grid) {
//		// Code here
//		ArrayList<Node> al = new ArrayList<>();
//		ArrayList<Node> bl = new ArrayList<>();
//		int row = grid.length, col = grid[0].length;
//		for (int i = 0; i < row; i++) {
//			for (int j = 0; j < col; j++) {
//				Node curr = new Node(i, j);
//				if (grid[i][j] == 1) {
//					al.add(curr);
//				} else {
//					bl.add(curr);
//				}
//			}
//		}
//		int[][] a=new int[row][col];
//		for(int i=0;i<bl.size();i++) {
//			int ans=Integer.MAX_VALUE;
//			Node zero=bl.get(i);
//			for(int j=0;j<al.size();j++) {
//				ans=Math.min(ans, zero.diff(al.get(j)));
//			}
//			a[zero.x][zero.y]=ans;
//		}
//		return a;
//	}
//}