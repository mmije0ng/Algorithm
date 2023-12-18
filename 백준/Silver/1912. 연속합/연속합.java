import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	private static int arr[]; //수열
	private static int sum[]; //수열에서 각각 최대 원소합을 담은 배열
	
	private static int len; //수열 길이
	private static int arrIndex=1; //수열 인덱스
	private static int sumIndex=0; //연속합 인덱스
	private static int max;
	
	private static void getMaxSum() {
		while(arrIndex<len) {
			int elementsArr=arr[arrIndex];
			int elementsSum=sum[sumIndex];
			//연속합에 자신을 더한 것 보다 자신이 더 크면
			if(elementsArr> elementsSum+elementsArr ) {
				sum[++sumIndex]=elementsArr;
			}
			//연속합에 자신을 더한것이 자신보다 큰 경우 
			else {
				sum[++sumIndex]=elementsSum+elementsArr;
			}
			
			max=Math.max(max,sum[sumIndex]);
		
			arrIndex++;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		len=Integer.parseInt(br.readLine()); 
		arr=new int[len];
		sum=new int[len];
		
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0;i<len;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			if(i==0) {
				sum[i]=arr[i];
				max=arr[i];
			}
		}
		
		getMaxSum();
		System.out.println(max);
	}
}