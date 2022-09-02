//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        Scanner sc=new Scanner(System.in);
        t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            String P[]=br.readLine().trim().split(" ");
            int m=Integer.parseInt(P[0])-1;
            int n=Integer.parseInt(P[1])-1;
            String A[]=br.readLine().trim().split(" ");
            String B[]=br.readLine().trim().split(" ");
            ArrayList<Integer> l=new ArrayList<>();
            for(String s : A){
                if(s.equals(""))
                continue;
                l.add(Integer.parseInt(s));
            }
            for(String s : B){
                if(s.equals(""))
                continue;
                l.add(Integer.parseInt(s));
            }
            int [] X =new int[m];
            int [] Y=new int[n];
            int ind=0;
            for(int i=0;i<m;i++){
                X[i]=l.get(ind++);
            }
            for(int i=0;i<n;i++){
                Y[i]=l.get(ind++);
            }
            
            Solution obj = new Solution();
            int res = obj.minimumCostOfBreaking(X, Y,m,n);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends
class Pair{
	int idx;
	int value;
	public Pair(int idx, int value) {
		super();	
		this.idx = idx;
		this.value = value;
	}
	@Override
	public String toString() {
		return "[" + idx + ", " + value + "]";
	}
	
}
class Dimensions{
	int hstart;
	int hend;
	int vstart;
	int vend;
	public Dimensions(int hstart, int hend, int vstart, int vend) {
		super();
		this.hstart = hstart;
		this.hend = hend;
		this.vstart = vstart;
		this.vend = vend;
	}
	@Override
	public String toString() {
		return "[" + hstart + ", " + hend + ", " + vstart + ", " + vend + "]";
	}
	public static ArrayList<Pair> tolist(int[]x){
		ArrayList<Pair> al=new ArrayList<Pair>();
		for(int i=0;i<x.length;i++) {
			al.add(new Pair(i+1,x[i]));
		}
		Collections.sort(al,new Comparator<Pair>() {

			@Override
			public int compare(Pair o1, Pair o2) {
				// TODO Auto-generated method stub
				return o2.value-o1.value;
			}
		});
		return al;
	}
	
}
class Solution {
	static int count;
	public static ArrayList<Dimensions>  partition(ArrayList<Dimensions> al,int idx,boolean flag,int value) {
		ArrayList<Dimensions>bl=new ArrayList<Dimensions>();
		
		int temp=0;
		if(flag) {
			int size=al.size();
			
			for(int i=0;i<size;i++) {
				Dimensions d=al.get(i);
				
				int hs=d.hstart;
				int he=d.hend;
				int vs=d.vstart;
				int ve=d.vend;
				if(idx<=hs ) {
					bl.add(al.get(i));
					continue;
				}
				else if(idx>he)
				{
					bl.add(al.get(i));
					continue;
				}
					
				else {
				
					temp++;
					int area=(idx-hs)*(ve-vs);
					if (area!=1)
					bl.add( new Dimensions(hs,idx,vs,ve));
					area=(he-idx)*(ve-vs);
					if(area!=1)
					bl.add(new Dimensions(idx, he, vs, ve));
					
				}
			}
		}else {
			int size=al.size();
			for(int i=0;i<size;i++) {
				Dimensions d=al.get(i);
				int hs=d.hstart;
				int he=d.hend;
				int vs=d.vstart;
				int ve=d.vend;
				if(idx<=vs){
					bl.add(al.get(i));
					continue;
				}
				else if (idx>ve) {
					bl.add(al.get(i));
					continue;
				}
				else {
				    temp++;
					int area=(he-hs)*(idx-vs);
					if (area!=1)
					bl.add( new Dimensions(hs,he,vs,idx));
					area=(he-hs)*(ve-idx);
					if(area!=1)
					bl.add(new Dimensions(hs, he, idx, ve));
					
				}
			}
			
		}
		
		count+=temp*value;
		return bl;
		
	}
	public static int alternate(int []X,int []Y,int m,int n) {
	
	Integer x[]=new Integer[X.length];
	int idx=0;
	for(int i:X)
		x[idx++]=i;
	Integer y[]=new Integer[Y.length];
	idx=0;
	for(int i:Y)
		y[idx++]=i;
	
	Arrays.sort(x,Collections.reverseOrder());
	Arrays.sort(y,Collections.reverseOrder());
		int h=1,l=1;
		int i=0,j=0;
		int ans=0;
		while(i<m && j<n) {
			if(x[i]>y[j]) {
				ans+=x[i]*l;
				h++;
				i++;
			}
			else {
				ans+=y[j]*h;
				l++;
				j++;
			}
		}
		      int total = 0;
		        while (i < m)
		            total += x[i++];
		        ans += total * l;
		      
		        total = 0;
		        while (j < n)
		            total += y[j++];
		        ans += total * h;
		      
		        return ans;

		
	}
	public static int solution(int []X, int[]Y, int M,int N) {
		int x=X.length;
    	int y=Y.length;
    	count=0;
    	Dimensions d=new Dimensions(0, x+1, 0, y+1);
    	ArrayList<Dimensions> dl=new ArrayList<>();
    	dl.add(d);
    	ArrayList<Pair> hl=d.tolist(X);
    	ArrayList<Pair> vl=d.tolist(Y);
    	
    	int i=0,j=0;
    	int k=x+y;
    	while(k-->0) {
    		
    	 if(i!=x&&j!=y) {
    			if(hl.get(i).value>=vl.get(j).value) {
    				int index=hl.get(i).idx;
    				int value=hl.get(i).value;
    				
    				
    				dl=partition(dl,index,true,value);
    				i++;
    			}
    			else {
    				int index=vl.get(j).idx;
    				int value=vl.get(j).value;
    				
    				
    				dl=partition(dl,index,false,value);
    				j++;
    			}
    			
    		}
    		else if(i!=x) {
				int index=hl.get(i).idx;
				int value=hl.get(i).value;
			
	
				dl=partition(dl,index,true,value);
				i++;
    		}
    		else {
    			int index=vl.get(j).idx;
				int value=vl.get(j).value;
				
				
				dl=partition(dl,index,false,value);
				j++;
    		}
    		
    		
    	}
    	return count;
	}
    public static int minimumCostOfBreaking(int[] X, int[] Y,int M,int N) {
        // code here
    	
     return alternate(X, Y, M, N);
    	
    }
}
        
