import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		int[] list=new int[n]; //데이터 값
		long[] dp=new long[1101]; //횟수를 저장해 놓은 dp
		
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		
		for(int i=0;i<n;i++) {
			list[i]=Integer.parseInt(st.nextToken());
			dp[i]=Integer.MAX_VALUE; //dp의 모든 값들을 가장 큰 정수로
		}
		dp[0]=0; //dp[0]은 0으로 초기화
		
		for(int i=0;i<n;i++) {
			for(int j=1;j<=list[i];j++) { //리스트 숫자 만큼
				try {
					//원래 존재하던 dp[i+j]의 값과 i번째 loop에서 dp[i]+1(한번에 점프)값 중
					//더 최솟값을 dp[i+j]로 선택
					dp[i+j]=Math.min(dp[i+j], dp[i]+1);
				}
			
				catch(ArrayIndexOutOfBoundsException e) {
					continue;
				}
			}
		}
		
		if(dp[n-1]>=Integer.MAX_VALUE) //오른쪽 끝으로 갈 수 없는 경우
			System.out.print(-1);
		else
			System.out.print(dp[n-1]);
	
		br.close();
	}
}