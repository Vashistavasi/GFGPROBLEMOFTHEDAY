////{ Driver Code Starts
////Initial Template for Java
//import java.io.*;
//import java.util.*; 
//
//class GFG{
//    public static void main(String args[]) throws IOException { 
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int t = Integer.parseInt(br.readLine());
//        while(t > 0){
//            int n = Integer.parseInt(br.readLine());
//            String s = br.readLine();
//            Solution ob = new Solution();
//            System.out.println(ob.minLength(s, n));
//            t--;
//        }
//    } 
//} 
//// } Driver Code Ends
//
//
////User function Template for Java
//
//class Solution { 
//	 public int minLength(String s, int n) {
//		StringBuffer sb=minLength1(s, n);
//		int len=sb.length();
//		do {
//			len=sb.length();
//			sb=minLength1(new String(sb), len);
//		}
//		while(len!=sb.length());
//		return len;
//	 }
//    public StringBuffer minLength1(String s, int n) { 
//    	StringBuffer sb=new StringBuffer();
//    	HashMap<Character,Character>hm=new HashMap<Character,Character>();
//    	HashMap<Character,Character> hm1=new HashMap<Character,Character>();
//    	hm.put('0','9');hm.put('1','2');hm.put('2','3');hm.put('3','4');hm.put('4','5');hm.put('5','6');hm.put('6','7');hm.put('7','8');hm.put('8','9');
//    	hm1.put('9','0');hm1.put('2','1');hm1.put('3','2');hm1.put('4','3');hm1.put('5','4');hm1.put('6','5');hm1.put('7','6');hm1.put('8','7');
//    	for(int i=0;i<n;i++) {
//
//    		char c=s.charAt(i);
//    		if(i==n-1) {
//    			sb.append(c);
//    			continue;
//    		}
//    		char next=s.charAt(i+1);
//    		
//    	 if(hm.get(c)!=null && hm.get(c)==next) {
//    			i++;
//    		}
//    	 else if(hm1.get(c)!=null && hm1.get(c)==next) {
//    		 i++;
//    	 }
//    		else {
//    			sb.append(c);
//    		}
//    	}
//    
//    	return sb;
//    	// code here 
//    }
//}















//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while(t > 0){
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();
            Solution ob = new Solution();
            System.out.println(ob.minLength(s, n));
            t--;
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution { 
	public int minLength(String s, int n) { 
 
    	HashMap<Character,Character>hm=new HashMap<Character,Character>();
        ArrayDeque<Character> stack=new ArrayDeque<>();
    	hm.put('1','2');hm.put('2','1');hm.put('3','4');hm.put('4','3');hm.put('5','6');
    	hm.put('6','5');hm.put('7','8');hm.put('8','7');hm.put('0','9');hm.put('9','0');
    
    	for(int i=0;i<n;i++) {

    		char c=s.charAt(i);
    		if(i==n-1) {
                if(!stack.isEmpty()) {
                	char chr=stack.peek();
                	if(hm.get(chr)==c) {
                		stack.pop();
                	}
                	else {
                		stack.push(c);
                	}
                }
    			continue;
    		}
    		char next=s.charAt(i+1);
    		if(!stack.isEmpty()) {
				char chr=stack.peek();
				if(hm.get(chr)==c) {
					stack.pop();
					continue;
				}
			}
			
    		if(hm.get(c)!=null && hm.get(c)==next) {
    			i++;
    		}
    		else {
    		stack.push(c);	
    		}
    	}
  
    	return stack.size();
    	// code here 
    }

	//Test cases
	//12
	//431226543561
	
	
	
	
	
	
	
	
//	 public int minLength(String s, int n) {
//		StringBuffer sb=minLength1(s, n);
//		int len=sb.length();
//	
//		return len;
//	 }
//    public StringBuffer minLength1(String s, int n) { 
//    	StringBuffer sb=new StringBuffer();
//    	HashMap<Character,Character>hm=new HashMap<Character,Character>();
//        ArrayDeque<Character> stack=new ArrayDeque<>();
//    	hm.put('1','2');hm.put('2','1');hm.put('3','4');hm.put('4','3');hm.put('5','6');
//    	hm.put('6','5');hm.put('7','8');hm.put('8','7');hm.put('0','9');hm.put('9','0');
//    
//    	for(int i=0;i<n;i++) {
//
//    		char c=s.charAt(i);
//    		if(i==n-1) {
//    			sb.append(c);
//                stack.push(c);
//    			continue;
//    		}
//    		char next=s.charAt(i+1);
//    		
//    	 if(hm.get(c)!=null && hm.get(c)==next) {
//    			i++;
//    		}
//    		else {
//    			if(!stack.isEmpty()) {
//    				char chr=stack.peek();
//    				if(hm.get(chr)==c)
//    					stack.pop();
//    					continue;
//    			}
//    			else {
//                    stack.push(c);
//        			sb.append(c);	
//    			}
//    		}
//    	}
//  
//    	return ans;
//    	// code here 
//    }
}