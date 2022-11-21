//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG{
    public static void main(String args[]) throws IOException { 
        
        int t = 1;
        
        while(t > 0){
        	try(BufferedReader bf=new BufferedReader(new FileReader("C:\\Users\\10683788\\Desktop\\fileInput (2).txt"))){
        		 int N = Integer.parseInt(bf.readLine());
                 int[] Arr = new int[N];
                 String s=bf.readLine();
                 StringTokenizer st=new StringTokenizer(s," ");
                 int i=0;
                 while(st.hasMoreTokens()){
                     Arr[i++] = Integer.parseInt(st.nextToken());
                 }
                 Solution ob = new Solution();
                 int ans = ob.minSubset(Arr,N);
                 System.out.println(ans);
                 t--;
        			
        	}
        	catch (Exception e) {
      		// TODO: handle exception
      	}
           
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution { 
    int minSubset(int[] Arr,int N) { 
        Arrays.sort(Arr);
        
        long total=0;
        
        for(int i=0;i<N;i++){
            total+=Arr[i];
        }
      
       long count=0;
        int elements=1;
        
        for(int i=N-1;i>-1;i--){
                count+=Arr[i];
                if(count>(total-count))
                break;
                else
                elements++;
        }
        return elements;
    }
}