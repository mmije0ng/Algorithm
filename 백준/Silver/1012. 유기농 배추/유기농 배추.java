import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	private static int graph[][];
	private static boolean visited[][];
	private static final int dx[] = {0,0,1,-1};  //상하좌우 방향 설정
	private static final int dy[] = {1,-1,0,0};  //상화좌우 방향 설정
	private static int count=0;
	private static int n,m;
	
	private static void dfs(int rows, int cols) {
		visited[rows][cols]=true;		
		
		for(int i=0;i<4;i++) {		
			int x=rows+dx[i];
			int y=cols+dy[i];
			try {
				//상하좌우로 배추(1)가 심어져있고 아직 방문되지 않은 점이라면 탐색 시작
				if(graph[x][y]==1 && !visited[x][y]) 
					dfs(x,y);			
			}
			
			catch(ArrayIndexOutOfBoundsException e) {
				continue;
			}	
		}	
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());
	    
	    while(testCase--!=0) {
	    	count=0;
	    	StringTokenizer st = new StringTokenizer(br.readLine()," ");
	    	
	    	n=Integer.parseInt(st.nextToken());
	    	m = Integer.parseInt(st.nextToken());
	    	int k=Integer.parseInt(st.nextToken());
	    	
	    	graph=new int[n][m];
	    	visited=new boolean[n][m];
	    	
	    	for(int i=0;i<k;i++) {
	    		st = new StringTokenizer(br.readLine()," ");
	    		int rows=Integer.parseInt(st.nextToken());;
	    		int cols=Integer.parseInt(st.nextToken());
	    		graph[rows][cols]=1;
	    	}
	    	
	    	for(int i=0;i<n;i++) {
	    		for(int j=0;j<m;j++) {
	    			if(graph[i][j]==1 && !visited[i][j]) {
	    				//main에서 count증가. main에서 호출된 점에서 인접 정점(배추)들을 탐색하기 때문
	    				count++;	    				
	    				dfs(i,j);
	    			}
	    		}
	    	}     		
	    	System.out.println(count);
	    }	    
	}
}