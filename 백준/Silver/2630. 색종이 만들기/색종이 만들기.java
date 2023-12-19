import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Main {
	private static int[][] arr;
	private static int white=0;
	private static int blue=0;
	
	private static void partition(int start, int end, int div) {
		boolean isPartition=false;
		
		for(int i=start;i<start+div;i++) {
			for(int j=end;j<end+div;j++) {
				if(arr[i][j]!=arr[start][end]) {
					isPartition=true;
					break;
				}
			}
		}
		
		//분할이 필요한 경우
		if(isPartition) {
			div/=2;
			partition(start,end,div); //1사분면
			partition(start,end+div, div); //2사분면
			partition(start+div,end, div); //3사분면 
			partition(start+div,end+div, div); //4사분면			
		}
		
		//분할이 필요 없는 상태, 모두 1 또는 0
		else {
			if(arr[start][end]==1)
				blue++;
			else
				white++;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
	
		int n=Integer.parseInt(br.readLine());
		arr=new int[n][n];
		for(int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) 
				arr[i][j]=Integer.parseInt(st.nextToken());	
		}

		partition(0,0,n);
		
		System.out.println(white);
		System.out.println(blue);
	}
}