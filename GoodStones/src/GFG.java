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
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.goodStones(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int goodStones(int n, int[] a) {
        // code here
    	boolean visited[]=new boolean[n];
    	int next=0;
    	int i=0;
    	HashSet<Integer> hs =new HashSet<Integer>();
    	for(i=0;i<n;i++) {
    	next=i;
    	hs=new HashSet<Integer>();
    	while(next>-1&&next<n) {
    		if(!visited[next]) {
                if(next>-1 && next<n)
    			hs.add(next);
    		next=next+a[next];
    		if(next<0 || next>=n)
    		{
    			
    			hs=new HashSet<Integer>();
    			break;
    		}
    		if(hs.contains(next)) {
    			Iterator<Integer> it=hs.iterator();
    			while(it.hasNext()) {
    				visited[it.next()]=true;
    			}
    			hs=new HashSet<Integer>();
    			break;
    		}
    		else {
    			if(next<i && !visited[next])
    			{
    				hs=new HashSet<Integer>();
    				break;
    			}
    			if(next>-1 && next<n)
    			hs.add(next);
    		}
    		
    	}
    		else {
    			if(next!=i)
    				visited[i]=true;
    			break;
    		}
    	}}
    	int ans=0;
    	for(boolean b:visited) {
    		if(!b)
    			ans++;
    	}
    	return ans;
    	
    }
}
        
