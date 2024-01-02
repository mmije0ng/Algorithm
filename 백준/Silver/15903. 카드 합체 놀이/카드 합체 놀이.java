import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args)throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Long> minHeap = new PriorityQueue<>(); //최소힙
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		long n=Long.parseLong(st.nextToken()); //카드의 개수
		long range=Long.parseLong(st.nextToken()); //카드 홥체 횟수
		
		st=new StringTokenizer(br.readLine()," ");
		while(st.hasMoreTokens()) 
			minHeap.add(Long.parseLong(st.nextToken()));
		
		for(int i=0;i<range;i++) {
			long x=minHeap.remove();
			long y=minHeap.remove();
			long sum=x+y;
			minHeap.add(sum);
			minHeap.add(sum);
		}
		
		long sum=0;
		while(!minHeap.isEmpty()) 
			sum+=minHeap.remove();
		
		System.out.println(sum);
	}
}