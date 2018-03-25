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
public class Prims{
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
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int node=sc.nextInt();
		int edge=sc.nextInt();
		Node[] a=new Node[edge];
		Boolean[] visited =new Boolean[node];
		for(int i=0;i<node;i++){
			visited[i]=false;
		}
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
			a[i]=new Node(u-1,v-1,w);
		}
		/*for(int i=0;i<a.length;i++){
			System.out.println("i="+a[i].i+"j="+a[i].j+"c="+a[i].cost);
			//System.out.println(visited[i]);
		}*/
		int sum=0;
		for(int k=0;k<node;k++){
			visited[k]=true;
			for(int l=0;l<a.length;l++){
				if((a[l].i==k || a[l].j==k) && (visited[a[l].i]==false || visited[a[l].j]==false)){
					pq.add(new Node(a[l].i,a[l].j,a[l].cost));
				}
			}
			//System.out.println();
			/*while(!pq.isEmpty()){
				Node q=pq.remove();
				System.out.println("i="+q.i+"j="+q.j+"c="+q.cost);
			}*/
			
		}
		while(!pq.isEmpty()){
			Node t=pq.remove();
			if(root(t.i)!=root(t.j)){
				union(t.i,t.j);
				sum=sum+t.cost;
				//System.out.println("cost="+t.cost);
			}
		}
		System.out.println(sum);
	}
}