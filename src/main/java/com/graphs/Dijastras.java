import java.util.*;
class Node implements Comparable<Node>{
	int node,cost;
	Node(int node,int cost){
		this.cost=cost;
		this.node=node;
	}
	public int compareTo(Node x){
		return Integer.compare(this.cost,x.cost);
	}

}
public class Dijastras{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int node=sc.nextInt();
		int edge=sc.nextInt();
		int[][] adj=new int[node][node];
		boolean[] visited=new boolean[node];
		for(int i=0;i<edge;i++){
			int u=sc.nextInt();
			int v=sc.nextInt();
			int w=sc.nextInt();
			adj[u-1][v-1]=w;
			adj[v-1][u-1]=w;
		}
		int start=sc.nextInt();
		int end=sc.nextInt();
		Dijastras(adj,node,start-1,end-1,visited);
	}
	static void Dijastras(int[][] adj,int n,int start,int end,boolean[] visited){
		int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
		PriorityQueue<Node> q=new PriorityQueue<Node>();
		q.add(new Node(start,0));
		visited[start]=true;
		while(!q.isEmpty()){
			Node o=q.remove();
			for(int i=0;i<n;i++){
				if(adj[o.node][i]!=0){
					if(dist[o.node]+adj[o.node][i]<dist[i]){
						dist[i]=dist[o.node]+adj[o.node][i];
						q.add(new Node(i,dist[i]));
					}
					if(visited[i]==false){
						visited[i]=true;
					}
				}
			}
		}
	System.out.println(dist[end]);
	}
}