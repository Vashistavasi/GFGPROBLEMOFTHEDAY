//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            List<List<String>> adj = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                List<String> l = new ArrayList<>();

                String name = sc.next();
                l.add(name);

                int tmp = sc.nextInt();

                sc.nextLine();
                for (int j = 0; j < tmp; j++) {
                    String h = sc.next();

                    l.add(h);
                }

                adj.add(l);
            }

            Solution obj = new Solution();
            List<List<String>> ans = obj.mergeDetails(adj);
            Collections.sort(ans,
                             (x, y)->{ return x.get(0).compareTo(y.get(0)); });

            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class pair{
	String name;
	ArrayList<String> mailIds;
	public pair(String name, ArrayList<String> mailIds) {
		super();
		this.name = name;
		this.mailIds = mailIds;
	}
	@Override
	public String toString() {
		return "[name=" + name + ", mailIds=" + mailIds + "]";
	}
	
}

class Solution {

    public List<List<String>> mergeDetails(List<List<String>> details) {
        // Your code here
    	List<List<String>> rem=new ArrayList<List<String>>();
    	
    	for(int i=0;i<details.size();i++) {
    		HashSet<String> hs=new HashSet<String>();
    		rem.add(new ArrayList<String>());
    		for(int j=1;j<details.get(i).size();j++) {
    			if(!hs.contains(details.get(i).get(j))) {
    				hs.add(details.get(i).get(j));
    				rem.get(i).add(details.get(i).get(j));
    			}
    		}
    	}
    	details=rem;
    	for(int i=0;i<details.size();i++) {
    		HashMap<String,String> hm=new HashMap<String,String>();
    		String name=details.get(i).get(0); 
    		for(int j=1;j<details.get(i).size();j++) {
    			hm.put(details.get(i).get(j), name);
    		}
    		for(int k=i+1;k<details.size();k++) {
    			for(int l=1;l<details.get(k).size();l++) {
    			
        			if(hm.containsKey(details.get(k).get(l))) {
        				for(int m=1;m<details.get(k).size();m++) {
        					if(!details.get(i).contains(details.get(k).get(m))){
        						details.get(i).add(details.get(k).get(m));	
            					hm.put(details.get(k).get(m), name);
        					}
        				
        				}
        				details.remove(k);
        				k--;
        				break;
        			}
        			
    			}
    			
    		}
    		
    	}
    	List<List<String>> ans=new ArrayList<List<String>>();
    	for(int i=0;i<details.size();i++) {
    		String name=details.get(i).get(0);
    		ans.add(new ArrayList<String>());
    		ans.get(i).add(name);
    		List<String> subList= details.get(i).subList(1, details.get(i).size());
    		Collections.sort(subList);
    		ans.get(i).addAll(subList);
    	}
    	
  return ans;
    }
}