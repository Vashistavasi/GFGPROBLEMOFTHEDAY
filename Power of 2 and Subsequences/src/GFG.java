//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
     
        int t = 1;
        while(t-- > 0)
        {
        	try(BufferedReader bf=new BufferedReader(new FileReader("C:\\Users\\10683788\\Desktop\\fileInput.txt"))){
        		  int N = Integer.parseInt(bf.readLine());
        		  ArrayList<Long> A = new ArrayList<Long>();
                  String in[] = bf.readLine().trim().split(" ");
                  for(var i : in){
                      Long x = Long.parseLong(i);
                      A.add(x);
                  }
                  Solution ob = new Solution();
                  System.out.println(ob.numberOfSubsequences(N,A));
          			
          	}
          	catch (Exception e) {
        		// TODO: handle exception
        	}

          
         

          
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static Long numberOfSubsequences(int N, ArrayList<Long> A){
        // code here
    	HashMap<Integer,Long>hm=new HashMap<Integer,Long>();
    
    	Long value=1l;
    	for(int i=0;i<31;i++) {
    		hm.put(i,value);
    		value=value*2;
    	}
    	int count=0;
    	for(int i=0;i<A.size();i++) {
    		if(hm.containsValue(Long.valueOf(A.get(i))))
    			count++;
    	}
    	java.math.BigInteger b=new java.math.BigInteger("1");
    	for(int i=0;i<count;i++) {
    		
    		b=b.multiply(java.math.BigInteger.TWO);
    	}
    	System.out.println(count);
    	System.out.println(b);
    	System.out.println(b.mod( new java.math.BigInteger("1000000007")));
    	if(count>0)
    		return b.mod(new java.math.BigInteger("1000000007")).longValue()-1;
    	else
    		return 0l;
    }
}