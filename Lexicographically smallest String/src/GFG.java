//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.io.*;
// Position this line where user code will be pasted.
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] input = new String[2]; 
            input = read.readLine().split(" "); 
            String S = input[0];
            int k =  Integer.parseInt(input[1]);
            Solution ob = new Solution();

            System.out.println(ob.lexicographicallySmallest(S, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
static int transform(int k,int n) {
	int t=(int) (Math.log(n)/Math.log(2));
	if(Math.pow(2, t)==n)return k/2;
	return k*2;
}
       static String lexicographicallySmallest(String S, int k) {
       int n=S.length();
       boolean [] vis=new boolean[n];
       int[]rem=new int[n];
       ArrayDeque<Integer> stack=new ArrayDeque<>();
       String ans="";
       k=transform(k,n);
       if(k>=n)
    	   return "-1";
       else if(k==0)
    	   return S;
       stack.push(0);
       int i=1;
       while(i<n) {
    	   while(S.charAt(stack.peek())>S.charAt(i)) {
    		   vis[stack.peek()]=true;
    		   k--;
    		   stack.pop();
    		   if(stack.isEmpty() || k==0)break;
    	   }
    	   if(k==0)break;
    	   stack.push(i);
    	   i++;
       }
       while(k>0 && !stack.isEmpty()) {
    	   vis[stack.peek()]=true;
    	   k--;
    	   stack.pop();
       }
       for( i=0;i<n;i++)
    	   if(!vis[i]) ans+=S.charAt(i);
       
       return ans;
    
}
}