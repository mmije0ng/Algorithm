import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	int vertex,length;
	Node(int vertex, int length){
		this.vertex=vertex;
		this.length=length;
	}
}

public class Main {
	private static void bfs() {
		Queue<Node> queue=new LinkedList<>();
		visited[start]=true;
		queue.add(new Node(start,0));
		
		while(!queue.isEmpty()) {
			Node node=queue.poll();		
			int v=node.vertex;
			int len=node.length; //시작 정점과의 거리
			if(len==shortLength) {
				lengthList.add(v);
			}

			for(int i=0;i<graph[v].size();i++) {		
				Node n=graph[v].get(i); //인접리스트에서 연결된 노드(정점, length)
				if(!visited[n.vertex]) { //방문되지 않았다면 len+1 로 설정하여 큐에 삽입
					visited[n.vertex]=true;
					queue.add(new Node(n.vertex,len+1));
				}
			}
		}
	}
	
	private static int n,testCase,shortLength,start;
	private static LinkedList<Node>[] graph;
	private static boolean[] visited;
	private static ArrayList<Integer> lengthList; //최단거리가 같은 정점들을 넣어두는 배열
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		n=Integer.parseInt(st.nextToken());
		testCase=Integer.parseInt(st.nextToken());
		shortLength=Integer.parseInt(st.nextToken());
		start=Integer.parseInt(st.nextToken());
		
		graph=new LinkedList[n+1];
		for(int i=1;i<n+1;i++)
			graph[i]=new LinkedList<>();
		visited=new boolean[n+1];
		lengthList=new ArrayList<>();
		
		for(int i=0;i<testCase;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int v=Integer.parseInt(st.nextToken());
			int w=Integer.parseInt(st.nextToken());
			graph[v].add(new Node(w,0));
		}
		
		bfs();
		if(lengthList.size()!=0) {
			Collections.sort(lengthList); //최단 거리 정점들을 오름차순으로 정렬
			for(int i=0;i<lengthList.size();i++)
				System.out.println(lengthList.get(i));
		}
		
		else
			System.out.println(-1); //일치하는 최단 거리 정점이 없음
		
		br.close();
	}
}