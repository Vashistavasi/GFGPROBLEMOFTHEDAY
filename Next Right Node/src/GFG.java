//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
    public String toString() {
    	return this.data+" ";
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        PrintWriter out=new PrintWriter(System.out);
	        int test = Integer.parseInt(br.readLine());
	        while(test-- > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
    	    	int key = Integer.parseInt(br.readLine());
        	    Solution obj = new Solution();
        	    Node res = obj.nextRight(root, key);
        	    out.println(res.data);
        }
        out.close();
    }
  
}

// } Driver Code Ends


//User function Template for Java

class Solution{
	  static int getLevelUtil(Node node, int data, int level)
	    {
	        if (node == null)
	            return 0;
	 
	        if (node.data == data)
	            return level;
	 
	        int downlevel
	            = getLevelUtil(node.left, data, level + 1);
	        if (downlevel != 0)
	            return downlevel;
	 
	        downlevel
	            = getLevelUtil(node.right, data, level + 1);
	        return downlevel;
	    }
	 
	    /* Returns level of given data value */
	   static int getLevel(Node node, int data)
	    {
	        return getLevelUtil(node, data, 1);
	    }
    public static void levelOrder(Node root,ArrayList<Node> al){
        if(root==null)
        return;
        ArrayDeque<Node> que=new ArrayDeque<Node>();
        que.add(root);
        while(!que.isEmpty()){
            Node curr=que.poll();
            al.add(curr);
            if(curr.left!=null)
        que.add(curr.left);
        if(curr.right!=null)
        que.add(curr.right);
        }
    }
	Node nextRight(Node root, int key)
    {
		//Write your code here
		ArrayList<Node> al=new ArrayList<Node> ();
		boolean flag=false;
		levelOrder(root,al);
		Node curr=null,next=null;
		for(int i=0;i<al.size()-1;i++) {
			curr=al.get(i);
			if(curr.data==key) {
				next=al.get(i+1);
				flag=true;
				break;
			}
		}
		if(flag) {
			int depthCurr=getLevel(root, key);
			int depthNext=getLevel(root,next.data);
			if(depthCurr==depthNext)
				return next;
			else 
				return new Node(-1);
		}
		
		return new Node(-1);
		
		
		
		
		
		
		
		
    }
}