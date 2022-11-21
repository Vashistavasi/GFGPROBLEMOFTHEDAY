//{ Driver Code Starts
import java.io.*;
import java.util.*;

// } Driver Code Ends
class Solution{
	
	static String maxSum(String w,char x[],int b[], int n){
        //code here
    	HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
    	for(int i=0;i<n;i++) {
    		hm.put(x[i], b[i]);
    	}
    	int sum=0;
   
    
    	int len=w.length();
    
    	String ret="";
    	String retAns="";
    	int prev=Integer.MIN_VALUE;
    	for(int i=0;i<len;i++) {
    		char curr=w.charAt(i);
    		if(sum<0) {
    			sum=0;
    			ret="";
    		}
    		 {
    			if(hm.containsKey(curr)) {
    				sum+=hm.get(curr);
    			}
    			else
    				sum+=curr;
    			ret+=curr;
    			if(prev<sum) {
    				prev=sum;
    				retAns=ret;
    			}
    		}
    		
    }
    	return retAns;
	}
	
	
	
	
	
	
	
	
	
	
	
//    static String maxSum(String w,char x[],int b[], int n){
//        //code here
//    	HashMap<Character,Integer> hm = new HashMap<Character,Integer>();
//    	for(int i=0;i<n;i++) {
//    		hm.put(x[i], b[i]);
//    	}
//    	int sum=0;
//    	int ans=Integer.MIN_VALUE;
//    
//    	int len=w.length();
//    	int arr[]=new int[len];
//    	boolean flag=false;
//    	for(int i=0;i<len;i++) {
//    		char curr=w.charAt(i);
//    		if(hm.containsKey(curr)) {
//    			sum+=hm.get(curr);
//    			arr[i]=sum;
//    			if(sum<0) {
//    				sum=0;
//    			arr[i]=-1;
//    			}
//    			ans=Math.max(ans, sum);
//    			
//    				
//    		}
//    		else {
//    			sum+=curr;
//    			ans=Math.max(ans, sum);
//    			arr[i]=sum;
//    		}
//    	}
//    int idx=0;
//    for(int i=0;i<len;i++) {
//    	if(arr[i]==ans)
//    		idx=i;
//    	if(arr[i]>=0)
//			flag=true;
//    }
//    if(!flag) {
//    	int val=Integer.MIN_VALUE;
//    	char c=' ';
//    	for(int i=0;i<len;i++) {
//    		char curr=w.charAt(i);
//    		if(val<=hm.get(curr)) {
//    			val=hm.get(curr);
//    			c=curr;
//    		}
//    	}
//    	String rt=new String();
//    	rt=rt+c;
//    	return rt.trim();
//    }
//    StringBuffer sb=new StringBuffer();
//    int i=idx;
//    while(i>-1 &&arr[i]!=-1) {
//    	sb.append(w.charAt(i));
//    	i--;
//    }
//    System.out.println(Arrays.toString(arr));
//    	return new String(sb.reverse());
//    }
}

//{ Driver Code Starts.
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String w = read.readLine();
            int n = Integer.parseInt(read.readLine());
            String TE[] = read.readLine().trim().split(" ");
            char x[] = new char[n];
            for(int i = 0;i<n;i++)
            {
                x[i] = TE[i].charAt(0);
            }
            
            String TR[] = read.readLine().trim().split(" ");
            int b[] = new int[n];
            for(int i = 0;i<n;i++)
            {
                b[i] = Integer.parseInt(TR[i]);
            }
           
            Solution ob = new Solution();
            System.out.println(ob.maxSum(w,x,b,n));
        }
    }
}
// } Driver Code Ends