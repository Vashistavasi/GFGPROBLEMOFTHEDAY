//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            int K = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            System.out.println(ob.countOfSubstrings(S,K));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
	static int check(int []a) {
		int count=0;
		for(int i=0;i<a.length;i++) {
			if(a[i]>0)
				count++;
		}
		return count;
	}
    static int countOfSubstrings(String S, int K) {
        // code here
    	int a[]=new int[27];
    	ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
    	for(int i=0;i<K;i++) {
    	  int curr=S.charAt(i)-'a';
    	  queue.add(curr);
    	  a[curr]++;
    	}
    	int count=check(a);
    	int ans=0;
    	if(count==K-1)
    		ans++;
    	for(int i=K;i<S.length();i++) {
    		int pop=queue.poll();
    		a[pop]--;
    		int curr=S.charAt(i)-'a';
    		queue.add(curr);
    		a[curr]++;
    		count=check(a);
    		if(count==K-1)
    			ans++;
    	}
    	return ans;
    	
    }
};