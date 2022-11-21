//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] input = new String[2]; 
            input = br.readLine().split(" "); 
            int l = Integer.parseInt(input[0]); 
            int r = Integer.parseInt(input[1]); 
            Solution ob = new Solution();
            System.out.println(ob.sumOfAll(l,r));
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution
{
    static int[]spf;
     static void sieve(int maxn) {
         spf=new int[maxn];
	 spf[1]=1;
	 for(int i=2;i<maxn;i++)
		 spf[i]=i;
	 for(int i=4;i<maxn;i+=2) {
		 spf[i]=2;
	 }
	 for(int i=3;i*i<maxn;i++)
		 if(spf[i]==i) {
			 for(int j=i*i;j<maxn;j+=i) {
				 if(spf[j]==j)
					 spf[j]=i;
			 }
		 }
 }
 public static int  getFactors(int x){
	 int sum=0;
	 HashSet<Integer> hs = new HashSet<Integer>();
	 while(x!=1) {
		 if(!hs.contains(spf[x]))
			 sum+=spf[x];
		 hs.add(spf[x]);
		 x=x/spf[x];
	 }
	 return sum;
 }
    public int sumOfAll(int l, int r)
    {
        // code here
    	int sum=0;
    	sieve(r+1);
    	for(int i=l;i<=r;i++) {
    		sum+=getFactors(i);
    	}
    	return sum;
    }
}