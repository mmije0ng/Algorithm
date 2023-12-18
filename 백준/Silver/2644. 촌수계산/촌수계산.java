import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
	private static LinkedList<Integer>list[]; //인접배열
	private static boolean visited[];
	private static int result=-1;
	private static boolean isFind=false; //두 사람의 촌수 관계를 찾았는지
	
	private static void dfs(int start,int end, int count) {	
		visited[start]=true;	
		
		for(int i=0;i<list[start].size();i++) {
			int vertex=list[start].get(i);	
			if(!visited[vertex]) {		
				if(vertex==end) { //찾으려는 사람의 도달
					result=++count;
					return;
				}
				
				dfs(vertex,end, count+1); //방문되지 않았고 찾으려는 사람에 도달하지 못했다면
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int length = Integer.parseInt(br.readLine())+1;
		visited=new boolean[length];
		list=new LinkedList[length];
		
		for(int i=0;i<length;i++)
			list[i]=new LinkedList<Integer>();
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int start=Integer.parseInt(st.nextToken()); //촌수를 찾으려는 사람1
		int end=Integer.parseInt(st.nextToken()); //촌수를 찾으려는 사람2
		
		int testCase=Integer.parseInt(br.readLine());
		for(int i=0;i<testCase;i++) {
			st = new StringTokenizer(br.readLine());
			int parent=Integer.parseInt(st.nextToken());
			int child=Integer.parseInt(st.nextToken());
			list[parent].add(child);
			list[child].add(parent);
		}
		
		dfs(start,end,0);	
		System.out.println(result);
	}
}