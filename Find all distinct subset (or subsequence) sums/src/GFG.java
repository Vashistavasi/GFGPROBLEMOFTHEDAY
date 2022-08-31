//{ Driver Code Starts
//Initial Template for Java

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
            int n = Integer.parseInt(br.readLine().trim());
            String[] s = br.readLine().trim().split(" ");
            int[] nums = new int[n];
            for(int i = 0; i < n; i++)
                nums[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            int[] ans = obj.DistinctSum(nums);
            for(int i = 0; i < ans.length; i++)
                System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
	static ArrayList<Integer> al;
	public static void sum(int[]a, int index,int arrSum) {
		if(a.length==index)
			al.add(arrSum);
		else {
			sum(a,index+1,arrSum+a[index]);
			sum(a,index+1,arrSum);
		}
	}
	public int[] sum(int nums[]) {
		int[] ans = null;
		int size=nums.length;
		int sum=0;
		for(int i:nums)
			sum+=i;
		boolean arr[]=new boolean[sum+1];
		arr[0]=true;
		boolean curr[]=new boolean[sum+1],next[]=new boolean[sum+1];
		for(int i=0;i<size;i++) {
			for(int j=0;j<sum+1;j++) {
				if(arr[j]) {
					curr[j+nums[i]]=true;
				}
			}
			for(int j=0;j<sum+1;j++) {
				if(curr[j]) {
					arr[j]=true;
					curr[j]=false;
				}
			}
		}
		ArrayList<Integer> bl=new ArrayList<Integer> ();
		for(int i=0;i<sum+1;i++)
		{
			if(arr[i])
				bl.add(i);
		}
		ans=new int[bl.size()];
		int j=0;
		for(int i:bl)
		{
			ans[j]=i;
			j++;
		}
		
		
		return ans;
	}

    public int[] DistinctSum(int[] nums)
    {
        // Code here
       int ans[]=sum(nums);
    	return ans;
 
    }
}