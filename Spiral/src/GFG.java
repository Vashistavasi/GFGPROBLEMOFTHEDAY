//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            int R = Integer.parseInt(input[0]); 
            int C = Integer.parseInt(input[1]); 
            String s1[] = read.readLine().trim().split("\\s+");
            int a[][] = new int[R][C];
            for(int i = 0;i < R*C;i++)
                a[i/C][i%C] = Integer.parseInt(s1[i]);
            Solution ob = new Solution();
            int[] ans = ob.reverseSpiral(R,C,a);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution
{
	static boolean visited[][];
    public int[] reverseSpiral(int R, int C, int[][] a)
    {
        // code here
    	visited=new boolean[R][C];
    	ArrayList<Integer> al=new ArrayList<>();
    	int count=0;
    	int i=0,j=0;
    	while(count<R*C) {
    		//goright
    		while(j<C && visited[i][j]==false) {
    			visited[i][j]=true;
    			al.add(a[i][j]);
    			count++;
    			j++;
    		}
    		
    		//godown
    		i++;
    		j--;
    			while(i<R && visited[i][j]==false) {
    				visited[i][j]=true;
    				al.add(a[i][j]);
    				i++;
    				count++;
    			}
    		i--;
    		j--;
    		//goleft
    			while(j>-1 && visited[i][j]==false) {
    				visited[i][j]=true;
    				al.add(a[i][j]);
    				j--;
    				count++;
    			}
    		i--;
    		j++;
    		//gotop
    		while(i>-1 && visited[i][j]==false) {
    			visited[i][j]=true;
    			al.add(a[i][j]);
    			i--;
    			count++;
    		}
    		i++;
    		j++;
    		
    		

    	}
    	Collections.reverse(al);
    	int []ans=new int [count];
        for(int k=0;k<count;k++)
        	ans[k]=al.get(k);
        return ans;

    }
}