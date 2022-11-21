//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

class Solution {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String S[] = read.readLine().split(" ");
            int[] A = new int[N];
            
            for(int i=0; i<N; i++)
                A[i] = Integer.parseInt(S[i]);

            GFG ob = new GFG();
            int[] ptr = ob.satisfyEqn(A,N);
            
            System.out.println(ptr[0] + " " + ptr[1] + " " + ptr[2] + " " + ptr[3]);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Pair{
	int x;int y;
	Pair(int x,int y){
		this.x=x;
		this.y=y;
	}
   static boolean isEqual(Pair p,Pair q) {
	   if(p.x!=q.x && p.x!=q.y && p.y!=q.x && p.y!=q.y)
		   return false;
	   return true;
   }
@Override
public String toString() {
	return  x + " " + y ;
}
   
}
class GFG {
    static int[] satisfyEqn(int[] A, int N) {
        // code here
    	HashMap<Integer,ArrayList<Pair>> hm=new HashMap<Integer,ArrayList<Pair>>();
    	for (int i = 0; i < A.length; i++) {
			for (int j = i+1; j < A.length; j++) {
				int sum=A[i]+A[j];
				Pair p=new Pair(i,j);
				ArrayList<Pair> list=hm.getOrDefault(sum, new ArrayList<>());
				list.add(p);
				hm.put(sum, list);
			}
		}
    	Set<Integer> keys=hm.keySet();
    	int [] ans=new int[4];
    	for(int i=0;i<4;i++) {
    		ans[i]=Integer.MAX_VALUE;
    	}
    	Iterator<Integer> it=keys.iterator();
    	while(it.hasNext()) {
    		int key=it.next();
    		ArrayList<Pair> pair=hm.get(key);
    		for(int i=0;i<pair.size();i++) {
    			for(int j=i+1;j<pair.size();j++) {
    				if(!Pair.isEqual(pair.get(i), pair.get(j))) {
    					boolean flag=false;
    					int temp[]=new int[4];
    					temp[0]=pair.get(i).x;temp[1]=pair.get(i).y;temp[2]=pair.get(j).x;temp[3]=pair.get(j).y;
    					for(int k=0;k<4;k++) {
    						if(temp[k]>ans[k])
    							break;
    						if(ans[k]>temp[k]) {
    							flag=true;
    							break;
    						}
    					}
    					if(flag)
    						ans=temp;
    				}
    			}
    		}
    	}
    	if(ans[0]!=Integer.MAX_VALUE)
     return ans;
    	else
    	{
    		for(int i=0;i<4;i++)
    			ans[i]=-1;
    		return ans;
    	}
    	
    }
};