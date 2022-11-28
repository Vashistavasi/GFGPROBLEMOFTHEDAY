//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            ArrayList<Integer> ans = new Solution().findSubarray(a, n);
            for(int i:ans){
                out.print(i+" ");
            }out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Obj{
int idx,sum;
ArrayList<Integer> al;
public Obj(int idx, int sum, ArrayList<Integer> al) {
	super();
	this.idx = idx;
	this.sum = sum;
	this.al = al;
}
	
}
class Solution {

    ArrayList<Integer> findSubarray(int a[], int n) {
        // code here
    	Obj ans=new Obj(Integer.MAX_VALUE,Integer.MIN_VALUE,new ArrayList<>());
    	for(int i=0;i<n;) {
    		Obj curr=new Obj(i,0,new ArrayList<>());
    		for(int j=i;j<n;j++) {
    			if(a[j]<0) {
    				ans = compare(ans, curr);
    				i++;
    				break;
    			}
    			else {
    				ArrayList<Integer> al=curr.al;
    				al.add(a[j]);
    				curr.sum+=a[j];
    				i++;
    			}
    		}
    		if(ans.idx==Integer.MAX_VALUE)
        		ans=curr;
    		ans=compare(ans,curr);
    	}
    	
    	return ans.al;
    }

	private Obj compare(Obj ans, Obj curr) {
		if(ans.sum<curr.sum) {
			ans=curr;
		}
		else if(ans.sum==curr.sum && ans.al.size()<curr.al.size()) {
			ans=curr;
		}
		else if(ans.sum==curr.sum && ans.al.size()==curr.al.size() && ans.idx>curr.idx)
			ans=curr;
		return ans;
	}
}