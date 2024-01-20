import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
	private int x,y;
	Node(int x, int y){
		this.x=x;
		this.y=y;
	}
	int getX() {return x;}
	int getY() {return y;}
}

public class Main {
	static int[][] graph;
	static boolean[][] visited;
	static Queue<Node>queue;
	static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
	static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
	static int endX,endY;
	static int size;
	
	private static void bfs(int startX, int startY) {
		visited[startX][startY]=true;
		queue.add(new Node(startX,startY));
		
		while(!queue.isEmpty()) {
			Node node=queue.poll();
			int x=node.getX();
			int y=node.getY();
			
			for(int i=0;i<dx.length;i++) {
				int nx = x + dx[i];
	            int ny = y + dy[i];
				if(nx>=0 && ny>=0 && nx <size && ny < size && !visited[nx][ny]) {
					visited[nx][ny]=true;
					graph[nx][ny]=graph[x][y]+1;
					queue.add(new Node(nx,ny));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int testCase=Integer.parseInt(br.readLine());
		
		while(testCase--!=0) {
			size=Integer.parseInt(br.readLine());
			graph=new int[size][size];
			visited=new boolean[size][size];
			queue=new LinkedList<>();
			
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int startX=Integer.parseInt(st.nextToken());
			int startY=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine()," ");
			endX=Integer.parseInt(st.nextToken());
			endY=Integer.parseInt(st.nextToken());
			
			bfs(startX,startY);
			System.out.println(graph[endX][endY]);
		}
	}
}