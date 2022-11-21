//{ Driver Code Starts
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
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends




//User function Template for Java



class Solution {
    int median(int matrix[][], int R, int C) {
        // code here
    	ArrayList<Integer> al=new ArrayList<Integer>();
    	for(int i=0;i<R;i++) {
    		{
    			al=consolidate(al,i,C,matrix);
    		}
    	}
    	 if(al.size()%2==0)
    	    {
    	    	int size=al.size()/2;
    	    	return (al.get(size)+al.get(size-1))/2;
    	    }
    	 else
    		 return al.get(al.size()/2);
    }

	private ArrayList<Integer> consolidate(ArrayList<Integer> al, int i, int c, int[][] matrix) {
		// TODO Auto-generated method stub
		int tot=al.size()+c;
		int k=0;
		int idx=0,sdx=0;
		ArrayList<Integer> temp=new ArrayList<>();
		 {
			while(idx<al.size()&& sdx<c)
			{
				if(al.get(idx)>matrix[i][sdx]) {
					temp.add(matrix[i][sdx]);
					sdx++;
				}
				else {
					temp.add(al.get(idx));
					idx++;
				}
				k++;
			}
			{
				while(idx<al.size()) {
					temp.add(al.get(idx));
					idx++;
					k++;
				}
				while(sdx<c) {
					temp.add(matrix[i][sdx]);
					sdx++;
					k++;
				}
			}
			
			
		}
		return temp;
	}
   

}


