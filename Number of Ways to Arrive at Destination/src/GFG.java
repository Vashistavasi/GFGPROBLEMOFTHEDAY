//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
// Position this line where user code will be pasted.

class GFG {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j < 3; j++) {
                    int x = sc.nextInt();
                    temp.add(x);
                }
                adj.add(temp);
            }

            Solution obj = new Solution();
            System.out.println(obj.countPaths(n, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    static int countPaths(int n, List<List<Integer>> roads) {
        // Your code here
    	ArrayList<ArrayList<ArrayList<Integer>>> graph=new ArrayList<ArrayList<ArrayList<Integer>>>();
        for(int i=0;i<n;i++)
        	graph.add (new ArrayList<ArrayList<Integer>>());
        for(int i=0;i<roads.size();i++) {
        	List<Integer> edges =roads.get(i);
        	int src=edges.get(0);
        	int dest=edges.get(1);
        	int time=edges.get(2);
        	ArrayList<Integer> t1=new ArrayList<Integer>();
        	t1.add(dest);t1.add(time);
        	ArrayList<Integer> t2=new ArrayList<Integer>();
        	t2.add(src);t2.add(time);
        	graph.get(src).add(t1);
        	graph.get(dest).add(t2);
        }
        
        PriorityQueue<ArrayList<Integer>>pq=new PriorityQueue<>((a,b)->a.get(0)-b.get(0));
        int [] minCost=new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        long ways[]=new long[n];
        ways[0]=1;
        minCost[0]=0;
        ArrayList <Integer> start=new ArrayList<Integer>();
        start.add(0);
        start.add(0);
        pq.add(start);
        while(!pq.isEmpty()) {
        	ArrayList<Integer> currNode=pq.poll();
        	int city=currNode.get(0);
        	int currCost=currNode.get(1);
        	if(currCost>minCost[city])
        		continue;
        	for(ArrayList<Integer> neighbourData: graph.get(city)) {
        		int neighbour=neighbourData.get(0);
        		int time=neighbourData.get(1);
        		if(currCost+time<minCost[neighbour]) {
        			minCost[neighbour]=currCost+time;
        			ArrayList<Integer> al=new ArrayList<Integer>();
        			al.add(neighbour);
        			al.add(minCost[neighbour]);
        			pq.add(al);
        			ways[neighbour]=ways[city];
        		}
        		else if(currCost+time==minCost[neighbour]) {
        			ways[neighbour]=(ways[neighbour]+ways[city])%(1000_000_007);
        		}
        		
        	}
        }
        return (int)ways[n-1];
        
    		
    	}
    	
    	
    }

