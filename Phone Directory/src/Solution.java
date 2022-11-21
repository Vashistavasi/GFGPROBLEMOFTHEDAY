//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String contact[] = in.readLine().trim().split("\\s+");
            String s = in.readLine();
            
            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for(int i = 0;i < ans.size();i++){
                for(int j = 0;j < ans.get(i).size();j++)
                    System.out.print(ans.get(i).get(j) + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class TrieNode{
	TrieNode[] child=new TrieNode[26];
	boolean isend;
	TrieNode() {
		isend=false;
		for (int i = 0; i < child.length; i++) {
			child[i]=null;
		}
	}
	static void insert(TrieNode temp,String key) {
		int level;
		int len=key.length();
		int idx;
		TrieNode root=temp;
		for( level=0;level<len;level++) {
			idx=key.charAt(level)-'a';
		    if (root.child[idx] == null) {
				root.child[idx]=new TrieNode();
			}
		    root=root.child[idx];
		}
		root.isend=true;
	}
	static boolean search(TrieNode root,String key) {
		TrieNode temp=root;
		int idx;
		for(int i=0;i<key.length();i++) {
			idx=key.charAt(i)-'a';
			if(temp.child[idx]==null)
				return false;
			temp=temp.child[idx];
		}
		return true;
	}
}
class Solution{
    static ArrayList<ArrayList<String>> displayContacts(int n, 
                                        String contact[], String s)
    {
    	ArrayList<ArrayList<String>>ans=new ArrayList<ArrayList<String>>();
        // code here
//      TrieNode root=new TrieNode();
//      for (int i = 0; i < contact.length; i++) {
//		root.insert(root, contact[i]);
//	}
//      int end=1;
    	Arrays.sort(contact);
    	
      for(int i=0;i<s.length();i++) {
    	  ArrayList<String> al=new ArrayList<String>();
    	  String sub=s.substring(0,i+1);
    	 
    	  for(int j=0;j<n;j++) {
    		  String curr=contact[j];
    		  String currSub=curr.substring(0,i+1);
    		  if(sub.equals(currSub) && !hs.contains(curr)) {
    			  al.add(curr);
    			  hs.add(curr);
    		  }
    		  
    	  }
    	  if(al.size()>0) {
    		  ans.add(al);
    	  }
    	  else {
    		  al.add("0");
    		  ans.add(al);
    	  }
      }
	return ans;
    }
    
}