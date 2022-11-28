
//{ Driver Code Starts
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

	public static Node buildTree(String str) {
		// Corner Case
		if (str.length() == 0 || str.charAt(0) == 'N')
			return null;

		// Creating array of Strings from input
		// String after spliting by space
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
			if (i >= ip.length)
				break;

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

	public static Node inputTree(BufferedReader br) throws IOException {
		return buildTree(br.readLine().trim());
	}

	public static void inorder(Node root) {
		if (root == null)
			return;
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
}

class GFG {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t;
		t = Integer.parseInt(br.readLine());
		while (t-- > 0) {

			String s;
			s = br.readLine();

			Solution obj = new Solution();
			Node res = obj.treeFromString(s);

			Node.inorder(res);
			System.out.println();

		}
	}
}

// } Driver Code Ends

/*
 * 
 * Definition for Binary Tree Node class Node { int data; Node left; Node right;
 * 
 * Node(int data) { this.data = data; left = null; right = null; } }
 */

class Solution {
	public static Node treeFromString(String s) {
		// code here
		Node ans = construct(s);
		return ans;
	}

	private static Node construct(String s) {
		if (s.length() == 0)
			return null;
		StringBuffer sb = new StringBuffer();
		int i = 0;
		while (i<s.length()  && s.charAt(i) != '(' ) {
			sb.append(s.charAt(i));
			i++;
		}
		Node n = new Node(Integer.parseInt(sb.toString()));
		if (s.length() == 1)
			return n;
		else {
			String left_part = "", right_part = "";
			int div = divide(s, i);
			if(i+1<s.length()) {
				left_part = s.substring(i+1, div - 1);
				n.left = construct(left_part);
			}
			if (div + 1 < s.length()) {
				right_part = s.substring(div + 1, s.length() - 1);
				n.right = construct(right_part);
			}
		}
		return n;
	}

	private static int divide(String s, int k) {
		int count_open = 1, count_close = 0;
		int i;
		for (i = k + 1; i < s.length(); i++) {
			if (count_open == count_close)
				break;
			else {
				if (s.charAt(i) == '(')
					count_open++;
				else if (s.charAt(i) == ')')
					count_close++;
			}
		}
		return i;
	}
}
