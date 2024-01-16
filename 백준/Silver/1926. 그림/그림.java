import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[][] graph;
	private static boolean [][] visited;
	private static int count=0; //그림의 개수
	private static int max=0; //최대 넓이 값
	private static int width=0; //각 그림의 넓이
	//우, 하, 좌, 상 
	private static int[] dx= {1,0,-1,0};
	private static int[] dy= {0,1,0,-1};
	
	private static void dfs(int rows,int cols) {
		visited[rows][cols]=true;
		width++;
		
		for(int i=0;i<4;i++) {
			try {
				if(!visited[rows+dy[i]][cols+dx[i]] && graph[rows+dy[i]][cols+dx[i]]==1) {
					dfs(rows+dy[i],cols+dx[i]);
				}		
			}
			
			catch(ArrayIndexOutOfBoundsException e) {
				continue;
			}
		}
	}
	
	public static void main(String[] args)throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int n=Integer.parseInt(st.nextToken());
		int m=Integer.parseInt(st.nextToken());
		graph=new int[n][m];
		visited=new boolean[n][m];
		
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<m;j++) 
				graph[i][j]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				if(!visited[i][j] && graph[i][j]==1) {
					count++; // dfs가 열릴 때 그림의 개수 count
					dfs(i,j);
					max=Math.max(max, width); //최대 넓이와 dfs가 끝난 후 넓이 비교
					width=0; //넓이 초기화
				}
			}
		}
		
		System.out.println(count);
		System.out.println(max);
		
		br.close();
	}
}