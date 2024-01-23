import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	private static LinkedList<Integer>[] graph;
	private static int n;
	
	private static void checkCutVertex(int v) {
		//v정점을 제거 했을 때 v정점이 포함된 그래프가 2개 이상으로 나뉘는 경우
		if(graph[v].size()>1) //정점이 2개 이상이면 단절점 
			System.out.println("yes");
		else
			System.out.println("no");
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		graph=new LinkedList[n];
		for(int i=0;i<n;i++)
			graph[i]=new LinkedList<>();
		
		for(int i=0;i<n-1;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int v=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken())-1;
			graph[v].add(w);
			graph[w].add(v);
		}
		
		int testCase=Integer.parseInt(br.readLine());
		for(int i=0;i<testCase;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine());
			int t=Integer.parseInt(st.nextToken());
			int v=Integer.parseInt(st.nextToken())-1;
			if(t==1) 
				checkCutVertex(v);
			
			else //모든 간선이 단절선, 그래프가 2개 이상으로 나뉨
				System.out.println("yes");	
		}
		
		br.close();
	}
}