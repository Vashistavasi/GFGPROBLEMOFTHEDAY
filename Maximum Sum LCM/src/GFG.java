//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;
class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();

            System.out.println(ob.maxSumLCM(n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    static long maxSumLCM(int n) {
        // code here
        long sum=0;
        HashSet<Long> hs=new HashSet<Long>();
        for(int i=1;i<Math.sqrt(n)+1;i++){
            long a=i;
            if(n%a==0){
                long b=n/a;
                if(!hs.contains(a) && !hs.contains(b)){
                    if(a==b)
                    sum+=a;
                    else
                sum+=a+b;
                hs.add(a);
                hs.add(b);
                }
            }
        }
        return sum;
    }
    static long gcd(long a, long b)
{
	if (a == 0)
		return b;
	return gcd(b % a, a);
}


static long lcm(long a, long b)
{
	return (a / gcd(a, b)) * b;
}
    
}