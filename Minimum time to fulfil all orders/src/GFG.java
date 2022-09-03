//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int l; 
            l = Integer.parseInt(br.readLine());
            
            
            int[] arr = IntArray.input(br, l);
            
            Solution obj = new Solution();
            int res = obj.findMinTime(n, l, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
	public static boolean isPossible(int time,int n,int arr[]) {
		int donuts=0;
		int size=arr.length;
		for(int i=0;i<size;i++) {
			int chefTime=arr[i];
			int tempTime=time;
			while(tempTime>=0) {
				tempTime=tempTime-chefTime;
				if(tempTime>=0)
					donuts++;
				chefTime+=arr[i];
				if(donuts>=n)
					return true;
			}
			if(donuts>=n)
				return true;
		}
		if(donuts>=n)
			return true;
		
		return false;
	}
	
    public static int findMinTime(int n, int l, int[] arr) {
        // code here
    	int minTime=1;
    	int chefTime=arr[0];
    	int maxTime=0;
    	int donuts=0;
    	while(donuts<=n) {
    		donuts++;
    		maxTime+=chefTime;
    		chefTime+=arr[0];
    	}
    	while(minTime<=maxTime) {
    		int midTime=minTime+(maxTime-minTime)/2;
    		
    		if(isPossible(midTime, n, arr)) {
    			maxTime=midTime-1;
    		}
    		else {
    			minTime=midTime+1;
    		}
    		
    	}
    	return minTime;
    	
    }
}


