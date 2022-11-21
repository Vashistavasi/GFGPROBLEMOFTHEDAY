//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int n = Integer.parseInt(in.readLine());
            String a[] = in.readLine().trim().split("\\s+");
            
            Solution ob = new Solution();
            System.out.println(ob.minFind(n, a));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int minFind(int n, String a[]){
        // code here
     ArrayDeque<String> que = new ArrayDeque<String>();
     que.add(a[0]);
     for (int i = 1; i < a.length; i++) {
		que.addLast(a[i]);
		int size=0;
		do {
			size=que.size();
			condense(que);
		}
		while(size!=que.size());
		
	}
     return que.size();
    }

	private static void condense(ArrayDeque<String> que) {
		// TODO Auto-generated method stub
		if(que.size()>1) {
			String last=que.removeLast();
			String penu=que.removeLast();
			if(!last.equals(penu)) {
				if((last.equals("R") && penu.equals("B") )||(last.equals("B") && penu.equals("R") ) )
					que.add("G");
				else if((last.equals("G") && penu.equals("B") )||(last.equals("B") && penu.equals("G") ) )
				que.add("R");
				else
					que.add("B");
			}
			else {
				que.addLast(penu);
				que.addLast(last);
			}
		}
	}
}