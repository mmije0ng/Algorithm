import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1번 집의 색은 2번 집의 색과 같지 않아야 한다.
// N번 집의 색은 N-1번 집의 색과 같지 않아야 한다.
// i(2 ≤ i ≤ N-1)번 집의 색은 i-1번, i+1번 집의 색과 같지 않아야 한다.

public class Main {
	private static int[][] rgb; 	
	//나의 색상과 겹치지 않는 최소 비용을 담아두고 n번쨰의 나의 색상의 비용을 담아둠
	private static int[][] house;
	
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
	
		int n=Integer.parseInt(bf.readLine());
		rgb=new int[n][3];
		house=new int[n][3];
		
		for(int i=0;i<n;i++) {
			String s=bf.readLine();
			StringTokenizer st=new StringTokenizer(s);
			
			rgb[i][0]=Integer.parseInt(st.nextToken());
			rgb[i][1]=Integer.parseInt(st.nextToken());
			rgb[i][2]=Integer.parseInt(st.nextToken());
		}
			
		house[0][0]=rgb[0][0];
		house[0][1]=rgb[0][1];
		house[0][2]=rgb[0][2];
		
		for(int i=1;i<n;i++) {
			house[i][0]+=Math.min(house[i-1][1],house[i-1][2])+rgb[i][0];
			house[i][1]+=Math.min(house[i-1][0],house[i-1][2])+rgb[i][1];
			house[i][2]+=Math.min(house[i-1][1],house[i-1][0])+rgb[i][2];	
		}
		
		System.out.println(Math.min(house[n-1][0], Math.min(house[n-1][1],house[n-1][2])));
	}
}