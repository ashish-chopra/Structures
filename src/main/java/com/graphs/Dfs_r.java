import java.util.*;
public class Dfs_r{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int node=sc.nextInt();
		int edge=sc.nextInt();
		int[][] adj=new int[node][node];
		boolean[] visited=new boolean[node];
		for(int i=0;i<edge;i++){
			int u=sc.nextInt();
			int v=sc.nextInt();
			adj[u-1][v-1]=1;
			adj[v-1][u-1]=1;
		}
		int start=sc.nextInt();
		dfs(adj,node,start-1,visited);
	}
	static void dfs(int[][] adj,int n,int start,boolean[] visited){
		visited[start]=true;
		System.out.print(start+1);
		for(int i=0;i<n;i++){
			if(adj[start][i]==1 && visited[i]==false){
				dfs(adj,n,i,visited);
			}
		}
	}
}