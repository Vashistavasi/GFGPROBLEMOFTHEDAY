//{ Driver Code Starts
// Initial Template for Java

import java.util.LinkedList;
import java.util.Queue;
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;
    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
} class pair {
    int first;
    int second;
    pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
} class GfG {

    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
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
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }
    static void printInorder(Node root) {
        if (root == null) return;

        printInorder(root.left);
        System.out.print(root.data + " ");

        printInorder(root.right);
    }

    public static boolean isBST(Node n, int lower, int upper) {
        if (n == null) return true;
        if (n.data <= lower || n.data >= upper) return false;
        return (isBST(n.left, lower, n.data) && isBST(n.right, n.data, upper));
    }

    public static boolean compare(Node a, Node b, ArrayList<pair> mismatch) {
        if (a == null && b == null) return true;
        if (a == null || b == null) return false;

        if (a.data != b.data) {
            pair temp = new pair(a.data, b.data);
            mismatch.add(temp);
        }

        return (compare(a.left, b.left, mismatch) &&
                compare(a.right, b.right, mismatch));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Node duplicate = buildTree(s);

            Solution g = new Solution();

            root = g.correctBST(root);

            // check 1: is tree now a BST
            if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE) == false) {
                out.println(0);
                continue;
            }

            // check 2: comparing with duplicate tree

            ArrayList<pair> mismatch = new ArrayList<pair>();
            // an arraylist to store data of mismatching nodes

            if (compare(root, duplicate, mismatch) == false) {
                // false output from this function indicates change in structure
                // of tree
                out.println(0);
                continue;
            }

            // finally, analysing the mismatching nodes
            if (mismatch.size() != 2 ||
                mismatch.get(0).first != mismatch.get(1).second ||
                mismatch.get(0).second != mismatch.get(1).first)
                out.println(0);
            else
                out.println(1);
        }
        out.close();
    }
}

// } Driver Code Ends


// User function Template for Java


/*
    class Node {
        int data;
        Node left;
        Node right;
        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
*/

class Solution {
	static ArrayList<Integer> al ;
	int i;
    public Node correctBST(Node root) {
        // code here.
    	
    	//Do Inorder traversal of root node it prints the tree in ascending order
    	//Swap the two misplaced elements in the array
    	//Construct a binary tree from the new array.
    	al=new ArrayList<Integer>();
    	inOrder(root);
    	sorted();
    	i=0;
    	reArrange(root);
    	return root;
    	
    
    	
    }
    public void reArrange(Node root) {
    	if (root==null) 
    		return;
    	else {
    		reArrange(root.left);
    		root.data=al.get(i++);
    		reArrange(root.right);
    	}
    }
    public void inOrder(Node root){
    	if(root==null)
    		return;
    	else {
    		inOrder(root.left);
    		al.add(root.data);
    		inOrder(root.right);
    	}
    }
    public ArrayList<Integer> sorted(){
    	
    	int n=al.size();
    	
    	for (int i = n - 1; i > 0; i--)
        {
            // Check if arr[i]
            // is not in order
            if (al.get(i) < al.get(i-1))
            {
                // Find the other element
                // to be swapped with arr[i]
                int j = i - 1;
                while (j >= 0 && al.get(i)<al.get(j))
                    j--;
     
                // Swap the pair
                int temp = al.get(i);
                al.set(i, al.get(j+1));               
                al.set(j+1, temp);
                
         
                break;
            }
        }
    	return al;
    }
    public Node constructBst(int start,int end) {
    	if(start>end)
    		return null;
    	int mid=(start+end)/2;
    	Node node =new Node(al.get(mid));	
    	node.left=constructBst(start,mid-1);
    	node.right=constructBst(mid+1,end);
    	return node;
    }
}


