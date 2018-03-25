import java.util.*;
class Node implements Comparable<Node>{
	int cost,i,j;
	Node(int i, int j,int cost){
		this.i=i;
		this.j=j;
		this.cost=cost;
	}
	public int compareTo(Node x){
		return Integer.compare(this.cost,x.cost);
	}
}
public class Kruskal{
	static int[] arr;
	static int[] size;
	static PriorityQueue<Node> pq;
	static int root(int i){
		while(arr[i]!=i){
			arr[i]=arr[arr[i]];
			i=arr[i];
		}
		return i;
	}
	static void union(int a,int b){
		int root_a=root(a);
		int root_b=root(b);
		if(size[root_a]>size[root_b]){
			arr[root_b]=root_a;
			size[root_a]+=root_b;
		}
		else{
			arr[root_a]=root_b;
			size[root_b]+=root_a;
		}
	}
	static int kruskal(){
		int c=0;
		while(!pq.isEmpty()){
			Node q=pq.remove();
			//System.out.println(q.cost);
			if(root(q.i)!=root(q.j)){
				union(q.i,q.j);
				c+=q.cost;
			}
		}
		return c;
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int node=sc.nextInt();
		int edge=sc.nextInt();
		pq=new PriorityQueue<Node>();
		arr=new int[node];
		size=new int[node];
		for(int i=0;i<node;i++){
			arr[i]=i;
			size[i]=1;
		}

		for(int i=0;i<edge;i++){
			int u=sc.nextInt();
			int v=sc.nextInt();
			int w=sc.nextInt();
			pq.add(new Node(u-1,v-1,w));
		}
		
		System.out.println(kruskal());
	}
}