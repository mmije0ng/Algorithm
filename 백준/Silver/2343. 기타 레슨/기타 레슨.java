import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	private static int[] arr;
	public static void main(String[] args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String s=bf.readLine();
		StringTokenizer st=new StringTokenizer(s);
		
		int N=Integer.parseInt(st.nextToken());
		int len=Integer.parseInt(st.nextToken());
		arr=new int[N];
		
		s=bf.readLine();
		st=new StringTokenizer(s);
		int left=0; //이분탐색에서 왼쪽
		int right=0;
				
		for(int i=0;i<N;i++) {
			arr[i]=Integer.parseInt(st.nextToken());
			right+=arr[i];
			left=Math.max(left,arr[i]);
		}
		//이분탐색을 처음 시작할 때 left는 가장 큰 값이어야 처음에 탐색을 시작할 때
		//모든 블루레이를 담을 수 있음
		
//		Arrays.sort(arr); 강의의 순서가 뒤바끼면 안 되기 때문에 정
		
		//이분탐색에서 블루레이크기를 넘지 않게 더한 후 결과가 len보다 크면 블루레이 크기를 늘리고
		//len 보다 크기가 작다면 블루레이 크기를 줄인다.		
		while(left<=right) {
			int mid=(left+right)/2; //블루레이 크기
			int sum=0;
			int count=0;
			
			for(int i=0;i<N;i++) {
				if(sum+arr[i]>mid) {
					sum=0;
					count++;
				}
				sum+=arr[i];
			} 
			if(sum!=0)
				count++;
			 //count의 개수가 len과 같아도 right를 줄임
			//left와 right가 교차되면 left부터 끝까지는 이미 len크기에 맞게 블루레이에 들어갈 수 있도록 보장되었기 때문
			if(count<=len)
				right=mid-1;
			else 
				left=mid+1;
		}
		
		//left와 right가 교차되고 난 후 left값이 블루레이 크기의 최솟값
		System.out.println(left);
	}
}