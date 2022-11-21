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
            ArrayList<Integer> res = obj.findLeastGreater(n, arr);
            
            IntArray.print(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
        // code here
    	ArrayList<Integer> al = new ArrayList<Integer>();
    	HashSet<Integer> hs=new HashSet<Integer> ();
    	HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
    	HashMap<Integer,ArrayList<Integer>> ahm=new HashMap<Integer,ArrayList<Integer>>();
    	for(int i=0;i<n;i++) {
    		ArrayList<Integer> id=ahm.getOrDefault(ahm, new ArrayList<>());
    		id.add(i);
    		ahm.put(arr[i], id);
    		if(!hs.contains(arr[i])) {
    			hs.add(arr[i]);
    			al.add(arr[i]);
    		}
    	}
    	Collections.sort(al);
    	for(int i=0;i<al.size();i++) {
    		hm.put(al.get(i), i);
    	}
    	ArrayList<Integer> ans=new ArrayList<>();
    	for(int i=0;i<n;i++) {
    		int nextIdx=hm.get(arr[i])+1;
    		if(nextIdx==al.size())
    			ans.add(-1);
    		else {
    			int next=al.get(nextIdx);
    			ArrayList<Integer> indices=ahm.get(next);
    			boolean flag=true;
    			for(int k:indices) {
    				if(k>i) {
    					flag=false;
    					break;
    				}
    			}
    			if(flag)
    				ans.add(-1);
    			else
    				ans.add(next);
    		}
    		
    	}
          return ans;
    	
    }
}
        
