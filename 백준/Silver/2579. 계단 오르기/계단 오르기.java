import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int n;
	private static int[] list;
	private static int[] dp;
	
	private static void getStairs() {
		dp[0]=list[0];
		if(n==1)
			return;
		dp[1]=list[0]+list[1];
		if(n==2)
			return;
		//한 계단+두 계단 또는 두 계단+한 계단
		dp[2]=Math.max(list[0]+list[2], list[1]+list[2]);
		
		//두 계단+한 계단 또는 연속된 두 계단
		for(int i=3;i<n;i++) {
			dp[i]=Math.max(dp[i-3]+list[i-1]+list[i], dp[i-2]+list[i]);
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine());
		list=new int[n];
		dp=new int[n];
		
		for(int i=0;i<n;i++)
			list[i]=Integer.parseInt(br.readLine());
		
		getStairs();
	
		System.out.println(dp[n-1]);
	}
}