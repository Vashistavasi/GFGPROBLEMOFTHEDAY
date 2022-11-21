//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());
		while (T-- > 0) {
			int n = Integer.parseInt(br.readLine().trim());
			Solution ob = new Solution();
			ArrayList<ArrayList<Integer>> ans = ob.UniquePartitions(n);
			for (ArrayList<Integer> i : ans)
				for (int j : i)
					System.out.print(j + " ");
			System.out.println();
		}
	}
}

// } Driver Code Ends

// User function Template for Java

class Solution {
	static ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();

	void print(int a[], int j) {
		ArrayList<Integer> curr = new ArrayList<Integer>();
		for (int i = 0; i < j; i++) {
			curr.add(a[i]);
		}

		ans.add(curr);
	}

	public ArrayList<ArrayList<Integer>> UniquePartitions(int n) {
		int[] p = new int[n];
		int k = 0;
		p[k] = n;
		while (true) {
			print(p, k + 1);
			int rem_val = 0;
			while (k >= 0 && p[k] == 1) {
				rem_val += p[k];
				k--;
			}

			if (k < 0)
				break;

			p[k]--;
			rem_val++;

			while (rem_val > p[k]) {
				p[k + 1] = p[k];
				rem_val = rem_val - p[k];
				k++;
			}

			p[k + 1] = rem_val;
			k++;

		}
		return ans;
	}

}