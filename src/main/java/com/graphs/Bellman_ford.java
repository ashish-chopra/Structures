import java.util.*;
public class Bellman_ford{
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
		bellman(adj,node,start-1,end-1,visited);
	}
	static void bellman(int[][] adj,int n,int start,int end,boolean[] visited){
		int[] dist=new int[n];
		for(int i=0;i<n;i++){
			dist[i]=Integer.MAX_VALUE;
		}	
		Queue<Integer> q=new <Integer>();
		q.add(start);
		visited[start]=true;
		dist[start]=0;
		while(!q.isEmpty()){
			int o=q.remove();
			for(int i=0;i<n;i++){
				if(adj[o][i]!=0){
					if(visited[i]==false){
						visited[i]=true;
					}
					if(dist[o]+adj[o][i]<dist[i]){
						dist[i]=dist[o]+adj[o][i];
						q.add(i);
					}
				}
			}
		}
		System.out.println(dist[end]);
	}
}