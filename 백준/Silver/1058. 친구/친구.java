import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static final int INF=100000000;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[][] graph=new int[n][n];
		
		String[] isFriend;		
		for(int i=0;i<n;i++) {
			isFriend = br.readLine().split("");
			for(int j=0;j<n;j++) {
				if(i==j)
					continue;
				if(isFriend[j].equals("Y")) 
					graph[i][j]=1;
				else
					graph[i][j]=INF;
			}		
		}
		
		//최단 경로 설정
		for (int k = 0; k<n; k++) {
			for (int i = 0; i<n; i++) {
				for (int j = 0; j<n; j++) {
					if(i==j)continue;
					graph[i][j]=Math.min(graph[i][k]+graph[k][j], graph[i][j]);				
				}				
			}
		}

		int max=0; //최대 친구의 개수
		for (int i = 0; i<n; i++) {
			int cnt=0;
			for (int j = 0; j<n; j++) {
				if(i==j)
					continue;
				if(graph[i][j]<=2)
					cnt++;
			}				
			max=Math.max(max, cnt);
		}
		
		System.out.println(max);
		br.close();
	}
}