import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	private static int[] array;
	
	private static int search(int low, int high, int total) {	
		while(low<=high) {
			int mid=(low+high)/2; //상한액
			int sum=0; //상한액으로 얻을 수 있는 예산
			
			for(int i=0;i<array.length;i++) {
				if(array[i]>mid)
					sum+=mid;
				else
					sum+=array[i];
			}
			
			if(sum<=total) //예산이 아직 총량에 도달하지 못함
				low=mid+1;
			else //예산 초과
				high=mid-1;
		}
		
		return high;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine()); //지방의 수
		StringTokenizer st = new StringTokenizer(br.readLine()," ");

		array=new int[n];
		int high=0;
		for(int i=0;i<n;i++) {
			array[i]=Integer.parseInt(st.nextToken());
			high=Math.max(high,array[i]);
		}
		int total=Integer.parseInt(br.readLine()); //총 예산
		
		int max=search(0,high,total);
		System.out.println(max);
	}
}
