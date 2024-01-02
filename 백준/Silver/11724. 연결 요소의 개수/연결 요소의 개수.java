import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] graph;
	private static boolean[] visited;
	private static int n;
	private static Queue<Integer> queue;
	private static int count=0;
	
	//너비 우선 탐색
	private static void bfs(int v) {
		queue.add(v);
	
		while(!queue.isEmpty()) {
			v=queue.remove();
			for(int w=0;w<n;w++) {
				if(graph[v][w]==1 && !visited[w]) {
					visited[w]=true;
					queue.add(w);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		queue=new LinkedList<>();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		n=Integer.parseInt(st.nextToken());
		int edge=Integer.parseInt(st.nextToken());
		graph=new int[n][n];
		visited=new boolean[n];
	
		for(int i=0;i<edge;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int x=Integer.parseInt(st.nextToken())-1;
			int y=Integer.parseInt(st.nextToken())-1;
			graph[x][y]=1;
			graph[y][x]=1;
		}
		
		for(int i=0;i<n;i++) {
			//한 그래프의 bfs 탐색이 모두 끝나면 정점들은 모두 방문되었음
			//방문되지 않았으면 그래프의 연결 요소의 시작점
			if(!visited[i]) {
				visited[i]=true;
				count++;
				bfs(i);
			}
		}
		
		System.out.println(count);
	}
}