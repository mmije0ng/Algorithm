import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[] visited;
	private static int f,s,g,u,d;
	
	private static void bfs() {
		Queue<Integer> queue=new LinkedList<>();
		visited[s]=1;
		queue.add(s);
		
		while(!queue.isEmpty()) {
			int now=queue.remove();
			if(now==g) {
				System.out.println(visited[now] - 1);
				return;
			}
	
			int upStairs=now+u; //올라갈 층
			if(upStairs<=f && visited[upStairs]==0) {
				queue.offer(upStairs);
				visited[upStairs]=visited[now]+1;
			}
			
			int downStairs=now-d; //내려갈 층
			if(downStairs>0 && visited[downStairs]==0) {
				queue.offer(downStairs);
				visited[downStairs]=visited[now]+1;
			}	
		}
		
		System.out.println("use the stairs");
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));	
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		f=Integer.parseInt(st.nextToken());
		s=Integer.parseInt(st.nextToken());
		g=Integer.parseInt(st.nextToken());
		u=Integer.parseInt(st.nextToken());
		d=Integer.parseInt(st.nextToken());
		visited=new int[f+1];
		
		bfs();
	}
}