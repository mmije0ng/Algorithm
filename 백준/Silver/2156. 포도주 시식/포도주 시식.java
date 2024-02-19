import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int n;
	private static int[] list;
	private static int[] dp;
	
	private static void getDp() {
		dp[1]=list[1];
		if(n==1)
			return;
		
		dp[2]=list[1]+list[2];
	
		//Bottom-Up
		for(int i=3;i<=n;i++) {
			// 한 칸 뛰고 한 칸 또는 연속된 두 칸 + 한칸
			int first=dp[i-2]+list[i];
			int second=dp[i-3]+list[i-1]+list[i];
			//앞의 경우를 먼저 비교한 후 이전 dp와 비교
			//마지막 숫자가 선택되는 경우인지 아닌지 확인 필요
			dp[i]=Math.max(dp[i-1],Math.max(first,second));
		}	
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		n=Integer.parseInt(br.readLine());
		list=new int[n+1]; 
		dp=new int[n+1];
		
		for(int i=1;i<=n;i++) 
			list[i]=Integer.parseInt(br.readLine());
	
		getDp();
		
		System.out.println(dp[n]);
	}
}