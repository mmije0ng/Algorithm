import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int start,end;
	Node(int start,int end){
		this.start=start;
		this.end=end;
	}
	
	@Override
	// 시작 시간을 기준으로 정렬하기 위한 compareTo 메서드 구현
    public int compareTo(Node other) {
        return this.start - other.start;
    }
}

public class Main {
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		List<Node> list=new ArrayList<>();
		
		for(int i=0;i<n;i++) {
			StringTokenizer st=new StringTokenizer(br.readLine()," ");
			int start=Integer.parseInt(st.nextToken());
			int end=Integer.parseInt(st.nextToken());
			list.add(new Node(start,end));
		}		
		//시작 시간을 기준으로 정렬
		Collections.sort(list);
		
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		minHeap.add(list.get(0).end);
		
		int count=1;	
		for(int i=1;i<n;i++) {
			if(minHeap.peek()<=list.get(i).start) {
				minHeap.poll();
			}
			
			minHeap.add(list.get(i).end);
		}
		
		System.out.print(minHeap.size());
		
		br.close();
	}
}