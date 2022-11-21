//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine().trim());
        while(T-->0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            Solution ob = new Solution();
            int[] ans = ob.leafNodes(arr, N);
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
  static ArrayList<Integer> leaf;

	public int[] leafNodes(int arr[], int N)
    {
        // code here
		leaf=new ArrayList<>();
    	ArrayList<Integer>tree=new ArrayList<>();
    	for (int i = 0; i < arr.length; i++) {
			tree.add(arr[i]);
		}
    	condense(tree);
    	int []ans=new int[leaf.size()];
    	for(int i=0;i<leaf.size();i++) {
    		ans[i]=leaf.get(i);
    	}
	return ans;
    }

	private void condense(ArrayList<Integer> tree) {
		// TODO Auto-generated method stub
		if(tree.size()==1)
		{
			leaf.add(tree.get(0));
			return;
		}
		if(tree.size()==0)
			return;
		ArrayList<Integer> left = new ArrayList<Integer>();
    	ArrayList<Integer> right = new ArrayList<Integer>();
    	int head=tree.get(0);
    	for (int i = 1; i < tree.size(); i++) {
			if(tree.get(i)<head)
				left.add(tree.get(i));
			else
				right.add(tree.get(i));
		}
    	condense(left);
    	condense(right);
	}
}