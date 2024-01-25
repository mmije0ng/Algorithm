import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Beer implements Comparable<Beer>{
	int pref,level; //선호도, 도수
	Beer(int pref, int level){
		this.pref=pref;
		this.level=level;
	}
	
	@Override
	public int compareTo(Beer b) { //리스트에서 도수 기준 오름차순
		 // level을 기준으로 오름차순 정렬
        return Integer.compare(this.level, b.level);
	}
}

public class Main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine()," ");
		int size=Integer.parseInt(st.nextToken());
		int limit =Integer.parseInt(st.nextToken());
		int n=Integer.parseInt(st.nextToken());
		
		List<Beer> list=new ArrayList<>();
		for(int i=0;i<n;i++) {
			st=new StringTokenizer(br.readLine()," ");
			int pref=Integer.parseInt(st.nextToken());
			int level=Integer.parseInt(st.nextToken());
			list.add(new Beer(pref,level));
		}
		Collections.sort(list); //도수 기준 오름차순

		PriorityQueue<Integer> minHeap=new PriorityQueue<>(size); //선호도 기준 최소 힙
		int sum=0;
		for(Beer beer:list) {
			minHeap.add(beer.pref);
			sum+=beer.pref;
			//힙사이즈가 사이즈 보다 커지면 맨 위 요소(가잔 낮은 선호도)를 제거하고 sum에서 빼기
			if(minHeap.size()>size) 
				sum-=minHeap.poll();
			//힙사이즈가 사이즈와 같고 sum이 limit보다 크거나 같으면
			//맨 위 요소가 조건을 만족하는 최소 선호도
			if(minHeap.size()==size && sum>=limit) {
				System.out.println(beer.level);
				System.exit(0);
			}
		}
		System.out.println(-1);
	}
}