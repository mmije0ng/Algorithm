import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static ArrayList<ArrayList<Integer>> graph;
	private static int res=0;
	private static boolean[] visited;
	
	private static void dfs(int w, int depth) {
		visited[w]=true;
		
		for(int vertex:graph.get(w)) {
			if(!visited[vertex]) {
				dfs(vertex,depth+1);
			}
		}
		
		//노드가 루프 노드가 아니고 노드의 인접리스트 사이즈가 1이면 리프노드
		if(w!=0 && graph.get(w).size()==1)
			res+=depth;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));		
		
		int n=Integer.parseInt(br.readLine());
		graph=new ArrayList<>();
		visited=new boolean[n];
		
		for(int i=0;i<n;i++)
			graph.add(new ArrayList<>());
		
		for(int i=0;i<n-1;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int x=Integer.parseInt(st.nextToken())-1;
			int y=Integer.parseInt(st.nextToken())-1;
			
			graph.get(x).add(y);
			graph.get(y).add(x);
		}
		
		dfs(0,0);
		
		//탐색 깊이가 홀수이면 승리, 짝수이면 패배
		if(res%2==1)
			System.out.println("Yes");
		else
			System.out.println("No");
		
		br.close();
	}
}