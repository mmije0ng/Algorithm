import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

//최소힙을 이용한 풀이
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine()); 
		//최상위 최대값 n개를 minheap에 저장
		PriorityQueue<Integer> minHeap=new PriorityQueue<Integer> ();
		
		StringTokenizer st;
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			for(int j=0;j<n;j++) {
				int num=Integer.parseInt(st.nextToken());
				
				if(minHeap.isEmpty() || minHeap.size()<n)
					minHeap.offer(num);				
				else {					
					//원소가 현재 뽑힌 최상위 최대값의 가장 최소값보다 크다면 minHeap에 추가
					if(num>minHeap.peek()) {
						minHeap.poll();
						minHeap.offer(num);
					}
				}
			}
		}
			
		//n번째로 큰 숫자는 최상위 최대값 n개를 저장해놓은 minHeap에서의 최솟값
		System.out.println(minHeap.peek());
	}
}
