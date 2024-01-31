import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int[][] tri;
	private static int[][] dp;
	private static int n;

	//삼각형 맨 아래층 부터 탐색
	private static void getMaxSum(int rows) {
		if(rows==0) //0행에 오면 종료(1행에서 0행 0열의 값이 더해짐)
			return;
		
		for(int i=0;i<tri[rows].length-1;i++) {
			//구해야 할 dp 값은 같은 행의 tri 값 + 아래층의 dp값의 오른쪽과 왼쪽 중 큰 값
			//dp는 삼각형의 위층(dp의 행과 같은 층)+삼각형의 아래층(dp행의 아래층)의 왼쪽과 오른쪽 중 더 큰 값
			dp[rows-1][i]=tri[rows-1][i]+Math.max(dp[rows][i], dp[rows][i+1]);
		}
		getMaxSum(rows-1);
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		tri=new int[n][];
		dp=new int[n][];
		
		for(int i=0;i<n;i++) {
			tri[i]=new int[i+1];
			dp[i]=new int[i+1];
			
			int idx=0;
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			while(st.hasMoreTokens()) 
				tri[i][idx++]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<n;i++)
			dp[n-1][i]=tri[n-1][i];
		
		getMaxSum(n-1);
		
		System.out.print(dp[0][0]);
	}
}